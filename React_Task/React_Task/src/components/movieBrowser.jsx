import React, { useState, useEffect } from "react";
import axios from "axios";
import MovieCard from "./MovieCard";
import SearchBar from "./searchBar";
import "./movieBrowser.css";

const MovieBrowser = () => {
  const [movies, setMovies] = useState([]);
  const [searchTerm, setSearchTerm] = useState("");
  const [selectedGenre, setSelectedGenre] = useState("");
  const [genres, setGenres] = useState([]);

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

  const filteredMovies = movies.filter((movie) => {
    const matchesTitle = movie.title.toLowerCase().includes(searchTerm.toLowerCase());
    const matchesGenre = selectedGenre === "" || movie.genre === selectedGenre;
    return matchesTitle && matchesGenre;
  });

  return (
    <div className="movie-browser-container">
      <div className="header">
        <h1>Movie Browser</h1>
        <SearchBar
          searchTerm={searchTerm}
          setSearchTerm={setSearchTerm}
          genres={genres}
          setSelectedGenre={setSelectedGenre}
        />
      </div>
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
    </div>
  );
};

export default MovieBrowser;
