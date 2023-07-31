package model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long idBook ;

    @Column(nullable = false, updatable = false)
    private String title ;

    private Integer totalRatings; // le nombre total de votes
    private float rating; // la note moyenne

    private LocalDate publishedDate;
    private String resume ;
    private Integer tome;

    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    public Book() {  }

    public Book(
            Long idBook,
            String title,
            Integer tome,
            float rating,
            Integer totalRatings,
            String imageUrl,
            LocalDate publishedDate,
            String resume,
            Genre genre,
            Publisher publisher) {

        this.idBook = idBook;
        this.title = title;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.totalRatings = totalRatings;
        this.tome =tome;
        this.publishedDate = publishedDate;
        this.resume = resume;
        this.genre = genre;
        this.publisher = publisher;
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getTotalRatings() { return totalRatings;}

    public void setTotalRatings(Integer totalRatings) { this.totalRatings = totalRatings; }

    public Integer getTome() { return tome; }

    public void setTome(Integer tome) { this.tome = tome; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    @Override
    public String toString() {
        return "Book{" +
                "idBook='" + idBook + '\'' +
                ", title='" + title + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", rating=" + rating +
                ", totalRatings=" + totalRatings +
                ", tome=" + tome +
                ", publishedDate=" + publishedDate +
                ", resume='" + resume + '\'' +
                ", genre=" + genre +
                ", publisher=" + publisher +
                '}';
    }
}
