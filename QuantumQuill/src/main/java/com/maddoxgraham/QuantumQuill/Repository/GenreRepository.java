package com.maddoxgraham.QuantumQuill.Repository;

import com.maddoxgraham.QuantumQuill.Models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    void deleteGenreByIdGenre(Long idGenre);
    Optional<Genre> findGenreByIdGenre(Long idGenre);
}
