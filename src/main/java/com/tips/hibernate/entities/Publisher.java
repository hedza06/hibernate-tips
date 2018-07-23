package com.tips.hibernate.entities;

import org.hibernate.annotations.Formula;
import org.springframework.context.annotation.Description;

import javax.persistence.*;
import java.io.Serializable;

@Description(value = "Representation of Publisher entity.")
@Entity
@Table(name = "publisher")
public class Publisher implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Formula(value = "concat(first_name, ' ', last_name)")
    private String fullNameWithFormula;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return this.firstName.concat(" ").concat(this.lastName);
    }

    public String getFullNameWithFormula() {
        return fullNameWithFormula;
    }

    @Override
    public String toString()
    {
        return "Publisher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
