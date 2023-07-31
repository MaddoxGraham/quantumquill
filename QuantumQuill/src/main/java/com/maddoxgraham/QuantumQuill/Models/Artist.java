package com.maddoxgraham.QuantumQuill.Models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private Set<Book> books = new HashSet<>();


    public Artist() {
    }

    public Artist(Long idArtist, String firstName, String lastName, Role role, Set<Book> books) {
        this.idArtist = idArtist;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.books = books;
    }
}