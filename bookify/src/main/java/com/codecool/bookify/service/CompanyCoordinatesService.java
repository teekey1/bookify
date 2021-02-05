package com.codecool.bookify.service;

import com.codecool.bookify.exceptions.NotFoundException;
import com.codecool.bookify.model.CompanyCoordinates;
import com.codecool.bookify.model.CompanyDetail;
import com.codecool.bookify.repository.CompanyCoordinatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class CompanyCoordinatesService implements HelperService<CompanyCoordinates>{

    private final CompanyCoordinatesRepository companyCoordinatesRepository;

    @Autowired
    public CompanyCoordinatesService(CompanyCoordinatesRepository companyCoordinatesRepository) {
        this.companyCoordinatesRepository = companyCoordinatesRepository;
    }

    @Override
    public List<CompanyCoordinates> getAll() {
        return companyCoordinatesRepository.findAll();
    }

    @Override
    public CompanyCoordinates getById(Long id) {
        Optional<CompanyCoordinates> companyCoordinates = companyCoordinatesRepository.findById(id);
        if (companyCoordinates.isPresent()) return companyCoordinates.get();
        throw new NotFoundException();
    }


    @Override
    public void update(CompanyCoordinates companyDetail, Long id) {
    }

    @Override
    public void insert(CompanyCoordinates companyCoordinates) {
        companyCoordinatesRepository.save(companyCoordinates);
    }

    @Override
    public void delete(Long id) {
        companyCoordinatesRepository.deleteById(id);
    }


}

