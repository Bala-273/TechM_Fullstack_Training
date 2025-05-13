import axios from "axios";

const BASE_URL = "http://localhost:3000";

export const getMovies = () => {
    return axios.get(`${BASE_URL}/movies`);
};

export const addMovie = (movie) => {
    return axios.post(`${BASE_URL}/movies`, movie);
};

