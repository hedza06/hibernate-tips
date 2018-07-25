package com.tips.hibernate.services;

import com.tips.hibernate.entities.Book;
import com.tips.hibernate.entities.BookView;
import com.tips.hibernate.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

@Description(value = "")
@Service
public class BookService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private BookRepository bookRepository;

    /**
     * Method for getting book by title - named query.
     *
     * @param title - provided title parameter
     * @return Book entity
     */
    public Book getByTitle(String title)
    {
        TypedQuery<Book> bookTypedQuery = entityManager.createNamedQuery("FetchBookByTitle", Book.class);
        bookTypedQuery.setParameter("title", title);

        return bookTypedQuery.getSingleResult();
    }

    /**
     * Method for getting immutable book view
     *
     * @return List of Book Views
     */
    public List<BookView> findBookView()
    {
        return bookRepository
                .findAll()
                .stream()
                .map(book -> {
                    BookView bookView = new BookView();
                    bookView.setId(book.getId());
                    bookView.setPublisher(book.getPublisher());
                    bookView.setTitle(book.getTitle());
                    return bookView;
                }).collect(Collectors.toList());
    }

    /**
     * Method for updating immutable entity
     *
     * @param book - provided book to update
     * @return Book entity
     */
    public Book update(Book book) {
        return bookRepository.save(book);
    }
}
