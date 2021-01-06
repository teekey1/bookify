package com.codecool.bookify.Model;

import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
@Setter
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String password;
    private String phone;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    @JoinColumn(name = "company_id")
    @ManyToOne
    private Company company;

    public User(String email, String password, String phone, Company company) {
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.company = company;
    }

}
