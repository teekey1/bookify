package com.codecool.bookify.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "company_details")
@Getter
@Setter
@NoArgsConstructor
public class CompanyDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "company_id", nullable = false)
    @ManyToOne(cascade = CascadeType.MERGE)
    private Company company;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String zip_code;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private int street_number;
    @Column(nullable = false)
    private String phone;

    public CompanyDetail(Company company, String city, String zip_code, String street, int street_number, String phone) {
        this.company = company;
        this.city = city;
        this.zip_code = zip_code;
        this.street = street;
        this.street_number = street_number;
        this.phone = phone;
    }
}
