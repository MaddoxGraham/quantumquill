package repository;

import model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    void deletePublisherById(Long idPublisher);
    Optional<Publisher> findPublisherById(Long idPublisher);
}