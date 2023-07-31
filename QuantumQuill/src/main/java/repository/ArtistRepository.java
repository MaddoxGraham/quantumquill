package repository;

import model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    void deleteArtistById(Long idArtist);
    Optional<Artist> findArtistById(Long idArtist);
}
