package com.codecool.bookify.Service;

import com.codecool.bookify.Model.User;
import com.codecool.bookify.Security.MyUserDetails;
import com.codecool.bookify.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public MyUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByEmail(email);
        user.orElseThrow(() -> new UsernameNotFoundException("User " + email + " not found"));
        return user.map(MyUserDetails::new).get();
    }

}
