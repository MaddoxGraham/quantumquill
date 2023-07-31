package com.maddoxgraham.QuantumQuill.Controller;


import com.maddoxgraham.QuantumQuill.Models.Publisher;
import com.maddoxgraham.QuantumQuill.Services.PublisherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publisher")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Publisher>> getAllPublisher() {
        List<Publisher> publishers = publisherService.findAllPublishers();
        return new ResponseEntity<>(publishers, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    //pathVariale prend l'id envoyé par le mapping puis on spésifie son type
    public ResponseEntity<Publisher> getPublisherById(@PathVariable("id") Long id) {
        Publisher publisher = publisherService.findPublisherById(id);
        return new ResponseEntity<>(publisher, HttpStatus.OK);
    }

    //add empoyee doit utiliser post car c'est un create
    @PostMapping("/add")
    // ici requestBody permet de récupérer l'employé créer
    public ResponseEntity<Publisher> addPublisher(@RequestBody Publisher publisher){
        Publisher newPublisher = publisherService.addPublisher(publisher);
        // on va cete fois ci retourne un created parce qu'on viens de créer quelque chose sur le serveur
        return new ResponseEntity<>(newPublisher, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<Publisher> updateBook(@RequestBody Publisher publisher){
        Publisher updatePublisher = publisherService.updatePublisher(publisher);
        return new ResponseEntity<>(updatePublisher, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePublisher(@PathVariable("id") Long id){
        publisherService.deletePublisher(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}