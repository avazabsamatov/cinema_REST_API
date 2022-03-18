package uz.pdp.cinema_rest_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.cinema_rest_api.model.Genre;
import uz.pdp.cinema_rest_api.repository.GenreRepository;

import java.util.List;

@Service
public class GenreService {
    @Autowired
    GenreRepository genreRepository;
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    public Genre create(Genre genre) {
        return genreRepository.save(genre);
    }
}
