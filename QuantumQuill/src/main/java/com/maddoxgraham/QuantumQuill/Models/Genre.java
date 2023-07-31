package com.maddoxgraham.QuantumQuill.Models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Genre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long idGenre;
    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Genre parentGenre;

    @OneToMany(mappedBy = "parentGenre", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Genre> subGenres = new HashSet<>();

    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Book> books = new HashSet<>();

    public Genre() {
    }

    public Genre(Long idGenre, String name, Genre parentGenre, Set<Genre> subGenres) {
        this.idGenre = idGenre;
        this.name = name;
        this.parentGenre = parentGenre;
        this.subGenres = subGenres;
    }


}