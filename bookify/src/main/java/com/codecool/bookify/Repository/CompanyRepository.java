package com.codecool.bookify.Repository;

import com.codecool.bookify.Model.Category;
import com.codecool.bookify.Model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
