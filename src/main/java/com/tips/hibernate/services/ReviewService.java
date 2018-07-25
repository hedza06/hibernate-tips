package com.tips.hibernate.services;

import com.tips.hibernate.dto.ReviewCustomDTO;
import com.tips.hibernate.dto.ReviewDTO;
import com.tips.hibernate.mappers.ReviewMapper;
import com.tips.hibernate.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Description(value = "Review Service.")
@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ReviewMapper reviewMapper;

    /**
     * Method for getting Review DTO by review identifier
     *
     * @param id - provided review identifier
     * @return Optional of Review DTO
     */
    @Transactional(readOnly = true)
    public Optional<ReviewDTO> findDTO(Integer id)
    {
       return reviewRepository.findById(id)
               .map(reviewMapper::reviewEntityToReviewDTO);
    }

    /**
     * Method for getting Review Custom DTO by review identifier
     *
     * @param id - provided review identifier
     * @return Optional of Review Custom DTO
     */
    @Transactional(readOnly = true)
    public Optional<ReviewCustomDTO> findCustomDTO(Integer id)
    {
        return reviewRepository.findById(id)
                .map(reviewMapper::reviewEntityToReviewCustomDTO);
    }
}
