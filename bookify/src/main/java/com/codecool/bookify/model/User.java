package com.codecool.bookify.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
@Setter
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    @Email
    private String email;
    @Column(nullable = false)
    private String password;
    private Boolean active;
    private String phone;
    @Column(nullable = false)
    private boolean isActive;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @JsonIgnoreProperties({"id"})
    private Set<Role> roles = new HashSet<>();
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    @ManyToOne
    private Company company;

    public User(String email, String password, String phone, Company company) {
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.company = company;
    }

}
