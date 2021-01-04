package com.codecool.bookify.Model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public enum CategoryEnum {
        BOWLING, DARTS, CARTING, BILLARD
    }
}
