package com.maddoxgraham.QuantumQuill.Repository;

import com.maddoxgraham.QuantumQuill.Models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    void deleteArtistByIdArtist(Long idArtist);
    Optional<Artist> findArtistByIdArtist(Long idArtist);
}
