package com.codecool.bookify.auth;

import com.codecool.bookify.exceptions.NotFoundException;
import com.codecool.bookify.model.Role;
import com.codecool.bookify.model.User;
import com.codecool.bookify.repository.UserRepository;
import com.codecool.bookify.security.ApplicationUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ApplicationUserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public ApplicationUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private ApplicationUser createApplicationUser(User user) {

        Set<GrantedAuthority> authorities = user.getRoles().stream().flatMap(role ->
                ApplicationUserRole.valueOf(role.getName()).getGrantedAuthorities().stream()).collect(Collectors.toSet());
        return new ApplicationUser(
                user.getEmail(),
                user.getPassword(),
                authorities,
                true,
                true,
                true,
                user.isActive()
        );
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new NotFoundException("User not found [email: " + email + "]")
                );

        return createApplicationUser(user);
    }
}
