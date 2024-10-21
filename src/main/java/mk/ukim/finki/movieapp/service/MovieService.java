package mk.ukim.finki.movieapp.service;

import mk.ukim.finki.movieapp.model.Movie;
import mk.ukim.finki.movieapp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public void save(Movie todo) {
        movieRepository.save(todo);
    }

    public Optional<Movie> findById(Long id) {
        return movieRepository.findById(id);
    }

    public void delete(Long id) {
        movieRepository.deleteById(id);
    }
}
