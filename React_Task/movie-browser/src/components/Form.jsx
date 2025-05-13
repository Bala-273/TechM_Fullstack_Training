import {v4 as uuidv4} from 'uuid';
import {useForm} from 'react-hook-form';
import "../styles/Form.css"

const AddMovieForm = ({addMovie}) => {
    const {register, handleSubmit,formState:{errors}, reset} = useForm();

    function formatCase (str) {
        return str .toLowerCase().split(' ').map(word => word.charAt(0).toUpperCase()+word.slice(1)).join(' ');
    }

    const onSubmit = (data) => {
        const newMovie = {
            id: uuidv4(),
            title: formatCase(data.title),
            year: data.year,
            genre: formatCase(data.genre),
            poster: data.poster
        };
        addMovie(newMovie);
        reset();
    };

    return (
        <div className='add-movie-form-container'>
            <h3>Add a new movie</h3>
            <form className="add-movie-form" onSubmit={handleSubmit(onSubmit)}>
                <div className='form-group'>
                    <label htmlFor='title'>Title:</label>
                    <input
                        type='text'
                        id='title'
                        {...register('title', {required: 'Title is required'})}
                    />
                    {errors.title && <p className='error-message'>{errors.title.message}</p>}
                </div>

                <div className='form-group'>
                    <label htmlFor="year">Year:</label>
                    <input 
                        type="number"
                        id='year'
                        {...register('year', {required:'Year is required'})} 
                    />
                    {errors.year && <p className='error-message'>{errors.year.message}</p>}
                </div>

                <div className='form-group'>
                    <label htmlFor="genre">Genre:</label>
                        <input 
                            type="text"
                            id='genre'
                            {...register('genre', {required:'Genre is required'})}
                        />
                        {errors.genre && <p className='error-message'>{errors.genre.message}</p>}
                </div>

                <div className='form-group'>
                    <label htmlFor="poster">Poster:</label>
                    <input 
                        type="text"
                        id='poster' 
                        {...register('poster', {required:'Poster is required'})}
                    />
                    {errors.poster && <p className='error-message'>{errors.poster.message}</p>}
                </div>

                <button type='submit'>Add Movie</button>
            </form>
        </div>
    );
}
export default AddMovieForm;