package com.tips.hibernate.services;

import com.tips.hibernate.entities.Book;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Description(value = "")
@Service
public class BookService {

    @PersistenceContext
    private EntityManager entityManager;

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
     * Method for getting list of books published after current date
     *
     * @return List of Books published after current date
     */
    public List<Book> getByPublishedAt()
    {
        TypedQuery<Book> bookTypedQuery = entityManager
                .createNamedQuery("FetchBookByPublishedDateGreaterThanCurrent", Book.class);
        return bookTypedQuery.getResultList();
    }
}
