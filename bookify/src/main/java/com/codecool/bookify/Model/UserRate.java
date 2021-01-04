package com.codecool.bookify.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users_rates")
@Getter
@Setter
@NoArgsConstructor
public class UserRate {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "user_id")
    @ManyToOne
    private User user;
    @Column(name = "company_id")
    @ManyToOne
    private Company company;
    private int rate;
    private String comment;

    public UserRate(User user, Company company, int rate, String comment) {
        this.user = user;
        this.company = company;
        this.rate = rate;
        this.comment = comment;
    }
}
