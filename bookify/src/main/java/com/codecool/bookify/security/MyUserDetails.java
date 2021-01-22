//package com.codecool.bookify.security;
//
//import com.codecool.bookify.model.Role;
//import com.codecool.bookify.model.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//public class MyUserDetails implements UserDetails {
//
//    private String email;
//    private String password;
//    private Boolean isActive;
//    private final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//
//    public MyUserDetails(User user) {
//        this.email = user.getEmail();
//        this.password = user.getPassword();
//        this.isActive = user.isActive();
//        for (Role role : user.getRoles()) {
//            String role1 = "ROLE_" + role.getName();
//            authorities.add(new SimpleGrantedAuthority(role1));
//        }
//    }
//
//    public MyUserDetails() {
//    }
//
//    public MyUserDetails(String s) {
//        this.email = s;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return email;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return isActive;
//    }
//}
