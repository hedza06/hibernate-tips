package com.tips.hibernate.entities;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.context.annotation.Description;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Description(value = "Representation of Review entity.")
@Entity
@Table(name = "review")
@NamedEntityGraph(name = "graph.Review.book",
    attributeNodes = @NamedAttributeNode(value = "book", subgraph = "book"),
    subgraphs = @NamedSubgraph(name = "book", attributeNodes = @NamedAttributeNode("publisher"))
)
public class Review implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(nullable = false)
    private String comment;

    @Temporal(TemporalType.TIMESTAMP)
    @Generated(value = GenerationTime.INSERT)
    @Column(name = "published_at")
    private Date publishedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }

    @Override
    public String toString()
    {
        return "Review{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", publishedAt=" + publishedAt +
                '}';
    }
}
