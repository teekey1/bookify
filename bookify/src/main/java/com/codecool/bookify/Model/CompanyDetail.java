package com.codecool.bookify.Model;


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
    @GeneratedValue
    private Long id;
    @Column(name = "company_id")
    @ManyToOne
    private Company company;
    private String city;
    private String zip_code;
    private String street;
    private int street_number;
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
