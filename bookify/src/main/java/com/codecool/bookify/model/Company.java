package com.codecool.bookify.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @JoinColumn (name = "category_id", nullable = false)
    @ManyToOne
    @JsonIgnoreProperties({"id"})
    private Category category;

    public Company(String name, Category category) {
        this.name = name;
        this.category = category;
    }
}
