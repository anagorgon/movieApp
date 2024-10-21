package mk.ukim.finki.movieapp.repository;

import mk.ukim.finki.movieapp.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
