import React, { useState, useEffect } from "react";
import axios from "axios";
import MovieCard from "./MovieCard";
import SearchBar from "./SearchBar";
import AddMovieForm from "./AddMovieForm";
import LoginForm from "./LoginForm";
import "./movieBrowser.css";

const MovieBrowser = () => {
  const [movies, setMovies] = useState([]);
  const [searchTerm, setSearchTerm] = useState("");
  const [selectedGenre, setSelectedGenre] = useState("");
  const [genres, setGenres] = useState([]);
  const [isLoggedIn, setIsLoggedIn] = useState(false); // Track login status


  useEffect(() => {
    const savedUsername = localStorage.getItem("username");
    if (savedUsername) {
      setIsLoggedIn(true);
    }
  }, []);

  useEffect(() => {
    axios
      .get("http://localhost:4500/movies")
      .then((response) => {
        const allMovies = response.data;
        setMovies(allMovies);

        const uniqueGenres = [...new Set(allMovies.map((movie) => movie.genre))];
        setGenres(uniqueGenres);
      })
      .catch((error) => console.error("Error fetching data:", error));
  }, []);

  const handleLogin = (username) => {
    setIsLoggedIn(true);
    alert(`Welcome, ${username}!`);
  };

  const handleLogout = () => {
    localStorage.removeItem("username");
    setIsLoggedIn(false);
  };

// Handle adding a new movie
const handleAddMovie = (newMovie) => {
  axios
    .post("http://localhost:4500/movies", newMovie)
    .then((response) => {
      // Update the movies state with the newly added movie
      setMovies((prevMovies) => [...prevMovies, response.data]);

      // Update genres with the new movie's genre
      if (!genres.includes(newMovie.genre)) {
        setGenres((prevGenres) => [...prevGenres, newMovie.genre]);
      }
    })
    .catch((error) => console.error("Error adding movie:", error));
};


  const filteredMovies = movies.filter((movie) => {
    const matchesTitle = movie.title.toLowerCase().includes(searchTerm.toLowerCase());
    const matchesGenre = selectedGenre === "" || movie.genre === selectedGenre;
    return matchesTitle && matchesGenre;
  });

  return (
    <div className="movie-browser-container">
      <div className="header">
        <h1>Movie Browser</h1>
        {isLoggedIn && (
          <button onClick={handleLogout} className="btn btn-danger logout-btn">
            Logout
          </button>
        )}
        {isLoggedIn && (
  <div className="search-bar-container">
    <SearchBar
      searchTerm={searchTerm}
      setSearchTerm={setSearchTerm}
      genres={genres}
      setSelectedGenre={setSelectedGenre}
    />
  </div>
)}

      </div>

      {!isLoggedIn ? (
        <div className="centered-container">
        <LoginForm onLogin={handleLogin} />
        </div>
      ) : (
        <>
          <div className="row movie-row">
            {filteredMovies.length > 0 ? (
              filteredMovies.map((movie) => (
                <div key={movie.id} className="col-6 col-md-3 mb-4">
                  <MovieCard movie={movie} />
                </div>
              ))
            ) : (
              <div className="col-12 text-center">
                <p>No movies found.</p>
              </div>
            )}
          </div>
          <AddMovieForm onAddMovie={handleAddMovie} />
          </>
      )}
    </div>
  );
};

export default MovieBrowser;


