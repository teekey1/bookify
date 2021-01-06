package com.codecool.bookify;

import com.codecool.bookify.Model.Role;
import com.codecool.bookify.Model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetails implements UserDetails {


    private String email;
    private String password;
    private final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();


    public MyUserDetails(User user) {
        this.email = user.getEmail();
        this.password = user.getPassword();
        for (Role role : user.getRoles()) {
            String role1 = "ROLE_" + role.getName();
            authorities.add(new SimpleGrantedAuthority(role1));
        }


    }

    public MyUserDetails() {
    }

    public MyUserDetails(String s) {
        this.email = s;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}