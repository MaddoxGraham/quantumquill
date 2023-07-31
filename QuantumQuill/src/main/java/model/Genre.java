package model;

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
    @JoinColumn(name="parent_id")
    private Genre parentGenre;

    @OneToMany(mappedBy="parentGenre", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Genre> subGenres = new HashSet<>();

    public Genre(){}

    public Genre(Long idGenre, String name) {
        this.idGenre = idGenre;
        this.name = name;
    }

    // Getters and Setters
    public Long getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(Long idGenre) {
        this.idGenre = idGenre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getParentGenre() {
        return parentGenre;
    }

    public void setParentGenre(Genre parentGenre) {
        this.parentGenre = parentGenre;
    }

    public Set<Genre> getSubGenres() {
        return subGenres;
    }

    public void setSubGenres(Set<Genre> subGenres) {
        this.subGenres = subGenres;
    }

    public void addSubGenre(Genre genre) {
        subGenres.add(genre);
        genre.setParentGenre(this);
    }

    public void removeSubGenre(Genre genre) {
        subGenres.remove(genre);
        genre.setParentGenre(null);
    }

    @Override
    public String toString() {
        return "Genre{" +
                "idGenre=" + idGenre +
                ", name='" + name + '\'' +
                '}';
    }
}
