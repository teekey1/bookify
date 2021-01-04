package com.codecool.bookify.Model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "appointments")
@Getter
@Setter
@NoArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue
    private Long id;
    private Date start_datetime;
    private Date end_datetime;
    private int price;
    @Column(name = "client_id")
    @ManyToOne
    private User client;
    @Column(name = "employee_id")
    @ManyToOne
    private User employee;
    @Column(name = "company_detail_id")
    @ManyToOne
    private CompanyDetail companyDetail;

    public Appointment(Date start_datetime, Date end_datetime, int price, User client, User employee, CompanyDetail companyDetail) {
        this.start_datetime = start_datetime;
        this.end_datetime = end_datetime;
        this.price = price;
        this.client = client;
        this.employee = employee;
        this.companyDetail = companyDetail;
    }
}
