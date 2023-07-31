package com.maddoxgraham.QuantumQuill.Repository;

import com.maddoxgraham.QuantumQuill.Models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    void deletePublisherByIdPublisher(Long idPublisher);
    Optional<Publisher> findPublisherByIdPublisher(Long idPublisher);
}