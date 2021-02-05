package com.codecool.bookify.repository;

import com.codecool.bookify.model.CompanyCoordinates;
import com.codecool.bookify.model.CompanyDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyCoordinatesRepository extends JpaRepository<CompanyCoordinates, Long> {


}
