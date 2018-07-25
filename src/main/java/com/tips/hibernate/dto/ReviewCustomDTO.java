package com.tips.hibernate.dto;

import org.springframework.context.annotation.Description;

import java.io.Serializable;

@Description(value = "Review Custom Data Transfer Object.")
public class ReviewCustomDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer identifier;
    private String comm;

    public Integer getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Integer identifier) {
        this.identifier = identifier;
    }

    public String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm;
    }

    @Override
    public String toString()
    {
        return "ReviewCustomDTO{" +
                "identifier=" + identifier +
                ", comm='" + comm + '\'' +
                '}';
    }
}
