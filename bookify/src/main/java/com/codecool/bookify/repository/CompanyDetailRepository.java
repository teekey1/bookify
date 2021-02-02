package com.codecool.bookify.repository;

import com.codecool.bookify.model.Company;
import com.codecool.bookify.model.CompanyDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyDetailRepository extends JpaRepository<CompanyDetail, Long> {

    public CompanyDetail findByCompanyId(Long companyId);
}
