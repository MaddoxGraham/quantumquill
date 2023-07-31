package service;


import exception.UserNotFoundException;
import model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ArtistRepository;

import java.util.List;

@Service
public class ArtistService {
    private final ArtistRepository artistRepository;

    @Autowired
    public ArtistService(ArtistRepository artistRepository){
        this.artistRepository = artistRepository;
    }

    public Artist addArtist(Artist artist){
        return artistRepository.save(artist);
    }

    public List<Artist> findAllArtists(){
        return artistRepository.findAll();
    }

    public Artist updateArtist(Artist artist){
        return artistRepository.save(artist);
    }

    public Artist findArtistById(Long idArtist){
        // ici comme on retoune un optional dans employeerepository on va devoir lui préciser :
        // retoune un employé par son id si tu le trouve sinon retoure l'exception usernotfound
        return artistRepository.findArtistById(idArtist).orElseThrow(() -> new UserNotFoundException("User n° " + idArtist + " was not found"));
    }

    public void deleteArtist(Long idArtist){
        artistRepository.deleteById(idArtist);
    }


}