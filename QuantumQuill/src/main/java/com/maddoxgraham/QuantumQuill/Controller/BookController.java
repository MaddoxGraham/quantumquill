package com.maddoxgraham.QuantumQuill.Controller;

import com.maddoxgraham.QuantumQuill.Models.Book;
import com.maddoxgraham.QuantumQuill.Services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //On veux une méthode qui retourne tous les livres donc on veux utiliser http c'est à cela que sert ResponseEntity
    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBook() {
        List<Book> books = bookService.findAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    //pathVariale prend l'id envoyé par le mapping puis on spésifie son type
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) {
        Book book = bookService.findBookById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    //add empoyee doit utiliser post car c'est un create
    @PostMapping("/add")
    // ici requestBody permet de récupérer l'employé créer
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book newBook = bookService.addBook(book);
        // on va cete fois ci retourne un created parce qu'on viens de créer quelque chose sur le serveur
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        Book updateBook = bookService.updateBook(book);
        return new ResponseEntity<>(updateBook, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Long id){
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
