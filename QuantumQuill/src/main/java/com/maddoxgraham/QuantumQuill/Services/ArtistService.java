package com.maddoxgraham.QuantumQuill.Services;


import com.maddoxgraham.QuantumQuill.Exceptions.UserNotFoundException;
import com.maddoxgraham.QuantumQuill.Models.Artist;
import com.maddoxgraham.QuantumQuill.Repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return artistRepository.findArtistByIdArtist(idArtist).orElseThrow(() -> new UserNotFoundException("User n° " + idArtist + " was not found"));
    }

    public void deleteArtist(Long idArtist){
        artistRepository.deleteById(idArtist);
    }


}