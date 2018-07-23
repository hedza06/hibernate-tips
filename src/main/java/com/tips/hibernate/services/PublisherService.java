package com.tips.hibernate.services;

import com.tips.hibernate.entities.Publisher;
import com.tips.hibernate.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Description(value = "Publisher Service.")
@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;


    /**
     * Method for getting publisher by first name
     *
     * @param firstName - provided first name
     * @return Optional of Publisher.
     */
    @Transactional(readOnly = true)
    public Optional<Publisher> findOneByFirstName(String firstName) {
        return publisherRepository.findOneByFirstName(firstName);
    }
}
