package service;

import exception.UserNotFoundException;
import model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.GenreRepository;

import java.util.List;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository){
        this.genreRepository = genreRepository;
    }

    public Genre addGenre(Genre genre){
        return genreRepository.save(genre);
    }

    public List<Genre> findAllGenres(){
        return genreRepository.findAll();
    }

    public Genre updateGenre(Genre genre){
        return genreRepository.save(genre);
    }

    public Genre findGenreById(Long idGenre){
        return genreRepository.findGenreById(idGenre).orElseThrow(() -> new UserNotFoundException("User n° " + idGenre + " was not found"));
    }

    public void deleteGenre(Long idGenre){
        genreRepository.deleteById(idGenre);
    }


}