package com.codecool.bookify.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

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
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private Timestamp start_datetime;
    @Column(nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private Timestamp end_datetime;
    @Column(nullable = false)
    private int price;
    @JoinColumn(name = "client_id", nullable = false, referencedColumnName = "id")
    @ManyToOne
    private User client;
    @JoinColumn (name = "employee_id", nullable = false, referencedColumnName = "id")
    @ManyToOne
    private User employee;
    @JoinColumn (name = "company_detail_id", nullable = false)
    @ManyToOne
    private CompanyDetail companyDetail;

    public Appointment(Timestamp start_datetime, Timestamp end_datetime, int price, User client, User employee, CompanyDetail companyDetail) {
        this.start_datetime = start_datetime;
        this.end_datetime = end_datetime;
        this.price = price;
        this.client = client;
        this.employee = employee;
        this.companyDetail = companyDetail;
    }
}
