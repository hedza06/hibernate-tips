package com.tips.hibernate.entities;

import org.hibernate.annotations.Immutable;
import org.springframework.context.annotation.Description;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Description(value = "Representation of Book entity.")
@Entity
@Table(name = "book")
@NamedQueries(value = {
    @NamedQuery(
        name = "FetchBookByTitle",
        query = "select b from Book b where b.title = :title"
    ),
    @NamedQuery(
        name = "FetchBookByPublishedDateGreaterThanCurrent",
        query = "select b from Book b where b.publishedAt > current_date()"
    )
})
// @Immutable
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisher;

    @Column(nullable = false)
    private String title;

    @Temporal(TemporalType.DATE)
    @Column(name = "published_at", nullable = false)
    private Date publishedAt;

    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
    private Set<Review> reviews = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(final Set<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString()
    {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publishedAt=" + publishedAt +
                '}';
    }
}
