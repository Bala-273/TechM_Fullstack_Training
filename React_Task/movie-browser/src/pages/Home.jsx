import MovieCard from "../components/MovieCard"
import { useEffect, useState } from "react";
import "../styles/Home.css"
import {getMovies} from "../services/movieServices"

function Home() {

    const [searchQuery, setSearchQuery] = useState("");
    const [movies, setMovies] = useState([]);
    const [selectedGenre, setSelectedGenre] = useState("All");
    const [genres, setGenres] = useState(["All"]);

    useEffect(() => {
        getMovies().then((response) => {
            setMovies(response.data);
            const extractedGenres = [...new Set(response.data.map((movie) => movie.genre))];
            setGenres(["All", ...extractedGenres]);
        });
    }, []);
   

    const handleSearch = (e) => {
        e.preventDefault();
    };


    const filteredMovies = movies.filter((movie) => {
        const matchesSearch = movie.title.toLowerCase().includes(searchQuery.toLowerCase().trim());
        const matchesGenre = selectedGenre === "All" || movie.genre === selectedGenre;
        return matchesSearch && matchesGenre;
    });

    return (
    <div className="Home">
        
        <form onSubmit={handleSearch} className="search-form">
            <input type="text" 
            placeholder="Search..." 
            className="search-input" 
            value={searchQuery}
            onChange={(e) => setSearchQuery(e.target.value)}/>

           <div className="select-wrapper">
            <select className="genre-select"
             value={selectedGenre}
             onChange={(e) => setSelectedGenre(e.target.value)}>
                {genres.map((genre) => (
                    <option value={genre} key={genre}>{genre}</option>
                ))}
             </select>
            </div>
            <button type="submit" className="search-button">Search</button>
        </form>
        
        <div className="movies-grid">
            {filteredMovies.map((movie) => (
                <MovieCard movie={movie} key={movie.id}/>
                ))}
        </div>
    </div>
    
);
}

export default Home;