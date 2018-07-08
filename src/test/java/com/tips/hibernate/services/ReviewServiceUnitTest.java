package com.tips.hibernate.services;

import com.tips.hibernate.entities.Review;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ReviewServiceUnitTest {

    @Autowired
    private ReviewService reviewService;

    @Test
    public void fetchByPublisherFirstNameTest()
    {
        List<Review> reviews = reviewService.getByPublisherFirstName("Heril");
        assertThat(reviews).isNotNull();
        assertThat(reviews).size().isEqualTo(4);
    }
}
