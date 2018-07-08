package com.tips.hibernate.repositories;

import com.tips.hibernate.entities.Review;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    @EntityGraph(value = "graph.Review.book", type = EntityGraph.EntityGraphType.FETCH)
    List<Review> findByBookPublisherFirstName(String firstName);

}
