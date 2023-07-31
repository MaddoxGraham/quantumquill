package repository;

import model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    void deleteBookById(Long idBook);
    Optional<Book> findBookById(Long idBook);
}
