package model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Artist implements Serializable {

    public enum Role {
        STORYTELLER, ILLUSTRATOR, AUTHOR_ILLUSTRATOR
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long idArtist;

    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToMany(mappedBy = "artists")
    private List<Book> books;


    public Artist() {    }

    public Artist(Long idArtist, String firstName, String lastName, Role role, List<Book> books) {
        this.idArtist = idArtist;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.books = books;
    }

    public Long getIdArtist() {
        return idArtist;
    }

    public void setIdArtist(Long idArtist) {
        this.idArtist = idArtist;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "idArtist=" + idArtist +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role=" + role +
                ", books=" + books +
                '}';
    }
}