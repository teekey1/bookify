package com.codecool.bookify.repository;


import com.codecool.bookify.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//        @Query("select e from users email e where")
        Optional<User> findByEmail(String email);


}
