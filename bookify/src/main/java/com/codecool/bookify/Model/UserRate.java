package com.codecool.bookify.Model;

import com.sun.istack.NotNull;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne
    private User user;
    @JoinColumn(name = "company_id", nullable = false)
    @ManyToOne
    private Company company;
    @Column(nullable = false)
    private int rate;
    private String comment;

    public UserRate(User user, Company company, int rate, String comment) {
        this.user = user;
        this.company = company;
        this.rate = rate;
        this.comment = comment;
    }
}
