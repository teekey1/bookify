package com.codecool.bookify.Repository;


import com.codecool.bookify.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//        @Query("select e from users email e where")
        Optional<User> findByEmail(String email);


}
