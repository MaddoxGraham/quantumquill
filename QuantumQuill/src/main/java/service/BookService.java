package service;

import exception.UserNotFoundException;
import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BookRepository;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

 public Book addBook(Book book){
        return bookRepository.save(book);
 }

    public List<Book> findAllBooks(){
          return bookRepository.findAll();
      }

    public Book updateBook(Book book){
         return bookRepository.save(book);
      }

    public Book findBookById(Long idBook){
          // ici comme on retoune un optional dans bookrepository on va devoir lui préciser :
          // retoune un book par son id si tu le trouve sinon retoure l'exception usernotfound
         return bookRepository.findBookById(idBook).orElseThrow(() -> new UserNotFoundException("User n° " + idBook + " was not found"));
      }

    public void addRating(Long bookId, float ratingValue) {
        Book book = bookRepository.findById(bookId).get();
        // Calculer la nouvelle note moyenne
        float newRating = ((book.getRating() * book.getTotalRatings()) + ratingValue) / (book.getTotalRatings() + 1);
        // Mettre à jour le nombre total de notes et la note moyenne
        book.setTotalRatings(book.getTotalRatings() + 1);
        book.setRating(newRating);
        // Sauvegarder le livre mis à jour dans la base de données
        bookRepository.save(book);
    }


    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }


}
