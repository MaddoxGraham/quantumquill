package com.maddoxgraham.QuantumQuill.Models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long idBook;

    @Column(nullable = false, updatable = false)
    private String title;

    private Integer totalRatings; // le nombre total de votes
    private float rating; // la note moyenne

    private LocalDate publishedDate;
    private String resume;
    private Integer tome;

    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToMany
    @JoinTable(name = "book_artist",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id"))
    private Set<Artist> artists = new HashSet<>();

    public Book() {
    }

    public Book(Long idBook, String title, Integer totalRatings, float rating, LocalDate publishedDate, String resume, Integer tome, String imageUrl, Genre genre, Publisher publisher, Set<Artist> artists) {
        this.idBook = idBook;
        this.title = title;
        this.totalRatings = totalRatings;
        this.rating = rating;
        this.publishedDate = publishedDate;
        this.resume = resume;
        this.tome = tome;
        this.imageUrl = imageUrl;
        this.genre = genre;
        this.publisher = publisher;
        this.artists = artists;
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTotalRatings() {
        return totalRatings;
    }

    public void setTotalRatings(Integer totalRatings) {
        this.totalRatings = totalRatings;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Integer getTome() {
        return tome;
    }

    public void setTome(Integer tome) {
        this.tome = tome;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Set<Artist> getArtists() {
        return artists;
    }

    public void setArtists(Set<Artist> artists) {
        this.artists = artists;
    }
}
