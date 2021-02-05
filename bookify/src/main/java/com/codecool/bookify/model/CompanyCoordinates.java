package com.codecool.bookify.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "company_coordinates")
@Getter
@Setter
@NoArgsConstructor
public class CompanyCoordinates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "company_id", nullable = false)
    @OneToOne(cascade = CascadeType.MERGE)
    private Company company;
    @Column(nullable = false)
    private float let;
    @Column(nullable = false)
    private float lng;


    public CompanyCoordinates(Company company, float let, float lng) {
        this.company = company;
        this.let = let;
        this.lng = lng;
    }
}
