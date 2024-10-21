package mk.ukim.finki.movieapp.web;
import mk.ukim.finki.movieapp.model.Movie;
import mk.ukim.finki.movieapp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public String listMovies(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        return "index";
    }

    @GetMapping("/create")
    public String createMovieForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "create";
    }

    @PostMapping("/create")
    public String saveMovie(@ModelAttribute("movie") Movie movie) {
        movieService.save(movie);
        return "redirect:/movies";
    }

    @GetMapping("/edit/{id}")
    public String editMovieForm(@PathVariable Long id, Model model) {
        model.addAttribute("movie", movieService.findById(id).orElse(null));
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String editMovie(@PathVariable Long id, @ModelAttribute("movie") Movie movie) {
        movie.setId(id);
        movieService.save(movie);
        return "redirect:/movies";
    }

    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Long id) {
        movieService.delete(id);
        return "redirect:/movies";
    }
}
