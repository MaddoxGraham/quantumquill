package controller;

import model.Artist;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ArtistService;


import java.util.List;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    //On veux une méthode qui retourne tous les livres donc on veux utiliser http c'est à cela que sert ResponseEntity
    @GetMapping("/all")
    public ResponseEntity<List<Artist>> getAllArtist() {
        List<Artist> artists = artistService.findAllArtists();
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    //pathVariale prend l'id envoyé par le mapping puis on spésifie son type
    public ResponseEntity<Artist> getArtistById(@PathVariable("id") Long id) {
        Artist artist = artistService.findArtistById(id);
        return new ResponseEntity<>(artist, HttpStatus.OK);
    }

    //add empoyee doit utiliser post car c'est un create
    @PostMapping("/add")
    // ici requestBody permet de récupérer l'employé créer
    public ResponseEntity<Artist> addArtist(@RequestBody Artist artist){
        Artist newArtist = artistService.addArtist(artist);
        // on va cete fois ci retourne un created parce qu'on viens de créer quelque chose sur le serveur
        return new ResponseEntity<>(newArtist, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<Artist> updateBook(@RequestBody Artist artist){
        Artist updateArtist = artistService.updateArtist(artist);
        return new ResponseEntity<>(updateArtist, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteArtist(@PathVariable("id") Long id){
        artistService.deleteArtist(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}