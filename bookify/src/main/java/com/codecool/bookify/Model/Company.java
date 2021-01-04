package com.codecool.bookify.Model;


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
    @GeneratedValue
    private Long id;
    private String name;
    @JoinColumn (name = "category_id")
    @ManyToOne
    private Category category;

    public Company(String name, Category category) {
        this.name = name;
        this.category = category;
    }
}
