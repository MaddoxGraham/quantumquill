package repository;

import model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    void deleteGenreById(Long idGenre);
    Optional<Genre> findGenreById(Long idGenre);
}
