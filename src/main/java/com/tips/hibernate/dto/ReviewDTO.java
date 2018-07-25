package com.tips.hibernate.dto;

import org.springframework.context.annotation.Description;

import java.io.Serializable;

@Description(value = "Review Data Transfer Objects.")
public class ReviewDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String comment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString()
    {
        return "ReviewDTO{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }
}
