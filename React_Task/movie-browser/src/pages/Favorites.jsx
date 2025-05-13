import "../styles/Favorites.css";
import { useMovieContext } from "../contexts/MovieContext";
import MovieCard from "../components/MovieCard";

function Favorites(){
    const {favorites} = useMovieContext();

    if (favorites.length > 0){
        return (
            <div className="favorites">
                <h2>Your Favorites</h2>
                <div className="movies-grid">
                    {favorites.map((movie) => (
                        <MovieCard key={movie.id} movie={movie} />
                    ))}
                </div>
            </div>
        )
    }
    return (
        <div className="favorites-empty">
            <h3>No Favorites movie</h3>
            <p>Start adding movies to view your favorites</p>
        </div>
    )
}

export default Favorites;