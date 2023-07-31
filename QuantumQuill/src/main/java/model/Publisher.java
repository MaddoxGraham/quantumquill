package model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Publisher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long idPublisher;
    private String name;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Book> books = new HashSet<>();

    public Publisher(){};

    public Publisher(Long idPublisher, String name) {
        this.idPublisher = idPublisher;
        this.name = name;
    }

    public Long getIdPublisher() {
        return idPublisher;
    }

    public void setIdPublisher(Long idPublisher) {
        this.idPublisher = idPublisher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        books.add(book);
        book.setPublisher(this);
    }

    public void removeBook(Book book) {
        books.remove(book);
        book.setPublisher(null);
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "idPublisher=" + idPublisher +
                ", name='" + name + '\'' +
                '}';
    }
}
