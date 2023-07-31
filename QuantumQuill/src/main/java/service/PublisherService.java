package service;

import exception.UserNotFoundException;
import model.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PublisherRepository;

import java.util.List;

@Service
public class PublisherService {
    private final PublisherRepository publisherRepository;

    @Autowired
    public PublisherService(PublisherRepository publisherRepository){
        this.publisherRepository = publisherRepository;
    }

    public Publisher addPublisher(Publisher publisher){
        return publisherRepository.save(publisher);
    }

    public List<Publisher> findAllPublishers(){
        return publisherRepository.findAll();
    }

    public Publisher updatePublisher(Publisher publisher){
        return publisherRepository.save(publisher);
    }

    public Publisher findPublisherById(Long idPublisher){
        return publisherRepository.findPublisherById(idPublisher).orElseThrow(() -> new UserNotFoundException("User n° " + idPublisher + " was not found"));
    }

    public void deletePublisher(Long idPublisher){
        publisherRepository.deleteById(idPublisher);
    }


}