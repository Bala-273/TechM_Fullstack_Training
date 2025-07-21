 import "../styles/MovieCard.css";
 import { useMovieContext } from "../contexts/MovieContext";
 
 function MovieCard({movie}){ 
    const {isFavorite, addToFavorites, removeFromFavorites} = useMovieContext();
    const favorite = isFavorite(movie.id)

    function onFavoriteClick(e){
        e.preventDefault()
        if (favorite) removeFromFavorites(movie.id)
            else addToFavorites(movie)
    }
    
    return <div className="movie-card">
        <div className="movie-poster">
            <img src={movie.poster} alt={movie.title} />
            <div className="movie-overlay">
                <button className="favorite-btn"
                onClick={onFavoriteClick}>{favorite ? "❤️" : "🤍"}</button>
            </div>
        </div>
        <div className="movie-info">
            <h3>{movie.title}</h3>
            <p>{movie.year}</p>
            <p>{movie.genre}</p>
        </div>

    </div>
 }

 export default MovieCard;