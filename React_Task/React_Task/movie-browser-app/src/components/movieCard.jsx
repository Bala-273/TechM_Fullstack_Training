import React from "react";

const MovieCard = ({ movie }) => {
  return (
    <div className="card shadow-sm fixed-size-card">
      <img src={movie.poster} className="card-img-top" alt={movie.title} />
      <div className="card-body">
        <h5 className="card-title">{movie.title}</h5>
        <p className="card-text">Year: {movie.year}</p>
        <p className="card-text">Genre: {movie.genre}</p>
        <p className="card-text">Rating: {movie.rating}</p>
      </div>
    </div>
  );
};

export default MovieCard;
