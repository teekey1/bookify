package com.codecool.bookify.repository;

import com.codecool.bookify.model.CompanyDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDetailRepository extends JpaRepository<CompanyDetail, Long> {
}
