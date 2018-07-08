package com.tips.hibernate.services;

import com.tips.hibernate.entities.Review;
import com.tips.hibernate.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Description(value = "Review Service.")
@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Transactional(readOnly = true)
    public List<Review> getByPublisherFirstName(String firstName) {
        return reviewRepository.findByBookPublisherFirstName(firstName);
    }
}
