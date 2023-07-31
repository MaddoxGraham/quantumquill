package com.maddoxgraham.QuantumQuill.Repository;

import com.maddoxgraham.QuantumQuill.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    void deleteBookByIdBook(Long idBook);
    Optional<Book> findBookByIdBook(Long idBook);
}
