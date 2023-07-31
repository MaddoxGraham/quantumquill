package controller;

import model.Genre;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.GenreService;


import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Genre>> getAllGenre() {
        List<Genre> genres = genreService.findAllGenres();
        return new ResponseEntity<>(genres, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    //pathVariale prend l'id envoyé par le mapping puis on spésifie son type
    public ResponseEntity<Genre> getGenreById(@PathVariable("id") Long id) {
        Genre genre = genreService.findGenreById(id);
        return new ResponseEntity<>(genre, HttpStatus.OK);
    }

    //add empoyee doit utiliser post car c'est un create
    @PostMapping("/add")
    // ici requestBody permet de récupérer l'employé créer
    public ResponseEntity<Genre> addGenre(@RequestBody Genre genre){
        Genre newGenre = genreService.addGenre(genre);
        // on va cete fois ci retourne un created parce qu'on viens de créer quelque chose sur le serveur
        return new ResponseEntity<>(newGenre, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<Genre> updateBook(@RequestBody Genre genre){
        Genre updateGenre = genreService.updateGenre(genre);
        return new ResponseEntity<>(updateGenre, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteGenre(@PathVariable("id") Long id){
        genreService.deleteGenre(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}