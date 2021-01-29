package com.codecool.bookify.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @ManyToMany(mappedBy = "roles", cascade = {CascadeType.ALL})
    @JsonIgnore
    private Set<User> users = new HashSet<>();

    public Role(String name) {
        this.name = name;
    }

    public enum UserRoleEnum {
        ADMIN, USER, EMPLOYEE, OWNER
    }


}
