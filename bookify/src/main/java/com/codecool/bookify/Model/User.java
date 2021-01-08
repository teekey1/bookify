package com.codecool.bookify.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
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
    private String phone;
    @Column(nullable = false)
    private Boolean isActive;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @JsonIgnoreProperties({"id"})
    private Set<Role> roles = new HashSet<>();
    @JoinColumn(name = "company_id")
    @ManyToOne
    private Company company;

    public User(String email, String password, String phone, Company company, Boolean isActive) {
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.company = company;
        this.isActive = isActive;
    }

}
