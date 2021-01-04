package com.codecool.bookify.Repository;

import com.codecool.bookify.Model.UserRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRateRepository extends JpaRepository<UserRate, Long> {
}
