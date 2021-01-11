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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Date start_datetime;
    @Column(nullable = false)
    private Date end_datetime;
    @Column(nullable = false)
    private int price;
    @JoinColumn(name = "client_id", nullable = false)
    @ManyToOne
    private User client;
    @JoinColumn (name = "employee_id", nullable = false)
    @ManyToOne
    private User employee;
    @JoinColumn (name = "company_detail_id", nullable = false)
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
