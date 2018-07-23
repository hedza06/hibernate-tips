package com.tips.hibernate.services;

import com.tips.hibernate.entities.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceUnitTest {

    @Autowired
    private BookService bookService;

    @Test
    public void fetchTransientNumberOfAttributes()
    {
        Book book = bookService.getByTitle("Hibernate Tips");
        assertThat(book.getTitle()).isEqualTo("Hibernate Tips");
        assertThat(book.getReviews()).isNotNull();

        assertThat(book.getNumberOfReviewsTransient()).isNotNull();
        assertThat(book.getNumberOfReviewsTransient()).isEqualTo(book.getReviews().size());
    }


}
