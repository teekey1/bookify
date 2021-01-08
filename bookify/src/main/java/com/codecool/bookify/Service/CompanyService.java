package com.codecool.bookify.Service;

import com.codecool.bookify.Exceptions.NotFoundException;
import com.codecool.bookify.Model.Company;
import com.codecool.bookify.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService implements HelperService<Company>{

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company getById(Long id) {
        Optional<Company> company = companyRepository.findById(id);
        if (company.isPresent()) return company.get();
        throw new NotFoundException();
    }

    @Override
    public void update(Company company, Long id) {
    }

    @Override
    public void insert(Company company) {
        companyRepository.save(company);
    }

    @Override
    public void delete(Long id) {
        companyRepository.deleteById(id);
    }
}
