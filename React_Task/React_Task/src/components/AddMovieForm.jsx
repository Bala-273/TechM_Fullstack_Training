import React from "react";
import { useForm } from "react-hook-form";

const AddMovieForm = ({ onAddMovie }) => {
  const {
    register,
    handleSubmit,
    formState: { errors },
    reset,
  } = useForm();

  const onSubmit = (data) => {
    const newMovie = {
      id: Date.now(),
      title: data.title,
      year: parseInt(data.year),
      genre: data.genre,
      rating: parseFloat(data.rating),
      poster: data.poster,
    };

    onAddMovie(newMovie);
    reset(); // Clear the form after submission
  };

  return (
    <div className="add-movie-form mb-4">
      <h3>Add a New Movie</h3>
      <form onSubmit={handleSubmit(onSubmit)}>
        <div className="mb-3">
          <label>Title</label>
          <input
            type="text"
            className="form-control"
            {...register("title", { required: "Title is required" })}
          />
          {errors.title && <p className="text-danger">{errors.title.message}</p>}
        </div>

        <div className="mb-3">
          <label>Year</label>
          <input
            type="number"
            className="form-control"
            {...register("year", {
              required: "Year is required",
              min: { value: 1888, message: "Year must be from 1888 onwards" },
              max: { value: new Date().getFullYear(), message: "Invalid year" },
            })}
          />
          {errors.year && <p className="text-danger">{errors.year.message}</p>}
        </div>

        <div className="mb-3">
          <label>Genre</label>
          <input
            type="text"
            className="form-control"
            {...register("genre", { required: "Genre is required" })}
          />
          {errors.genre && <p className="text-danger">{errors.genre.message}</p>}
        </div>

        <div className="mb-3">
          <label>Rating</label>
          <input
            type="number"
            step="0.1"
            className="form-control"
            {...register("rating", {
              required: "Rating is required",
              min: { value: 0, message: "Minimum rating is 0" },
              max: { value: 10, message: "Maximum rating is 10" },
            })}
          />
          {errors.rating && <p className="text-danger">{errors.rating.message}</p>}
        </div>

        <div className="mb-3">
          <label>Poster URL</label>
          <input
            type="text"
            className="form-control"
            {...register("poster", { required: "Poster URL is required" })}
          />
          {errors.poster && <p className="text-danger">{errors.poster.message}</p>}
        </div>

        <button type="submit" className="btn btn-primary w-100">Add Movie</button>
      </form>
    </div>
  );
};

export default AddMovieForm;
