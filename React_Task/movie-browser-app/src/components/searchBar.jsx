import React from "react";

const SearchBar = ({ searchTerm, setSearchTerm, genres, setSelectedGenre }) => {
  return (
    <div className="search-bar">
      <input
        type="text"
        className="form-control me-2"
        placeholder="Search movies..."
        value={searchTerm}
        onChange={(e) => setSearchTerm(e.target.value)}
      />
      <select
        className="form-select"
        onChange={(e) => setSelectedGenre(e.target.value)}
      >
        <option value="">All Genres</option>
        {genres.map((genre) => (
          <option key={genre} value={genre}>
            {genre}
          </option>
        ))}
      </select>
    </div>
  );
};

export default SearchBar;
