package com.tips.hibernate.services;

import com.tips.hibernate.entities.Book;
import com.tips.hibernate.entities.BookView;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceUnitTest {

    @Autowired
    private BookService bookService;

    @Test
    public void fetchBookView()
    {
        List<BookView> bookViewList = bookService.findBookView();
        assertThat(bookViewList).isNotNull();
        assertThat(bookViewList.size()).isGreaterThan(0);
    }

    @Test
    public void updateBook()
    {
        Book book = bookService.getByTitle("Spring Boot And Redis");
        book.setTitle("test-update");

        Book afterUpdate = bookService.update(book);
        assertThat(book.getTitle()).isEqualTo(afterUpdate.getTitle());
    }
}
