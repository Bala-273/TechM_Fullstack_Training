import AddMovieForm from "../components/Form";
import { useNavigate } from "react-router-dom";
import { addMovie } from "../services/movieServices";

const AddMovie = () => {
    const navigate = useNavigate();

    const handleAddMovie = async (movie) => {
        try {
            await addMovie(movie);
            navigate("/");
        }catch (error) {
            console.error("Failed to add movie: ", error);
        }
    };

    return (
        <div className="add-movie-page">
            <AddMovieForm addMovie={handleAddMovie} />
        </div>
    );
};

export default AddMovie;