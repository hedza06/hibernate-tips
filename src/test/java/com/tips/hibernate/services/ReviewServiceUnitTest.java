package com.tips.hibernate.services;

import com.tips.hibernate.dto.ReviewCustomDTO;
import com.tips.hibernate.dto.ReviewDTO;
import com.tips.hibernate.entities.Review;
import com.tips.hibernate.repositories.ReviewRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ReviewServiceUnitTest {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void fetchReviewDTO()
    {
        Optional<Review> optionalReview = reviewRepository.findById(1);
        Optional<ReviewDTO> optionalReviewDTO = reviewService.findDTO(1);

        if (optionalReview.isPresent() && optionalReviewDTO.isPresent())
        {
            assertThat(optionalReview.get().getId()).isEqualTo(optionalReviewDTO.get().getId());
            assertThat(optionalReview.get().getComment()).isEqualTo(optionalReviewDTO.get().getComment());
        }
    }

    @Test
    public void fetchReviewCustomDTO()
    {
        Optional<Review> optionalReview = reviewRepository.findById(1);
        Optional<ReviewCustomDTO> optionalReviewCustomDTO = reviewService.findCustomDTO(1);

        if (optionalReview.isPresent() && optionalReviewCustomDTO.isPresent())
        {
            assertThat(optionalReview.get().getId()).isEqualTo(optionalReviewCustomDTO.get().getIdentifier());
            assertThat(optionalReview.get().getComment()).isEqualTo(optionalReviewCustomDTO.get().getComm());
        }
    }
}
