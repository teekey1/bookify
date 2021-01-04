package com.codecool.bookify.Repository;

import com.codecool.bookify.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Category, Long> {
}
