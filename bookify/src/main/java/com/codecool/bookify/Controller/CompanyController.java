package com.codecool.bookify.Controller;

import com.codecool.bookify.Model.Company;
import com.codecool.bookify.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/companies")
    public List<Company> getCompany(){
        return companyService.getAll();
    }

    @GetMapping("companies/{id}")
    public Company getCompany(@PathVariable Long id){
        return companyService.getById(id);
    }

    @DeleteMapping("companies/{id}")
    public void removeCompany(@PathVariable Long id) {
        companyService.delete(id);
    }

    @PostMapping("/companies")
    public void addCompany(@RequestBody Company company){
        companyService.insert(company);
    }

    @PutMapping("/companies/{id}")
    public void updateCompany(@RequestBody Company company, @PathVariable Long id) {
    }
}
