package com.codecool.bookify.controller;

import com.codecool.bookify.model.Company;
import com.codecool.bookify.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping()
    public List<Company> getCompany(){
        return companyService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Company getCompany(@PathVariable Long id){
        return companyService.getById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void removeCompany(@PathVariable Long id) {
        companyService.delete(id);
    }

    @PostMapping()
    public void addCompany(@RequestBody Company company){
        companyService.insert(company);
    }

    @PutMapping(value = "/{id}")
    public void updateCompany(@RequestBody Company company, @PathVariable Long id) {
    }


    @GetMapping("/category/{id}")
    public List<Company> getCompaniesByCategoryId(@PathVariable Long id) {
        return companyService.getCompaniesByCategoryId(id);
    }

    @GetMapping("/name/{name}")
    public Company getCompanyByName(@PathVariable String name) {
        return companyService.getCompanyByName(name);
    }
}
