package com.codecool.bookify.controller;

import com.codecool.bookify.model.Company;
import com.codecool.bookify.model.CompanyCoordinates;
import com.codecool.bookify.model.CompanyDetail;
import com.codecool.bookify.service.CompanyCoordinatesService;
import com.codecool.bookify.service.CompanyDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company_coordinates")
public class CompanyCoordinatesController {
    private final CompanyCoordinatesService companyCoordinatesService;

    @Autowired
    public CompanyCoordinatesController(CompanyCoordinatesService companyCoordinatesService) {
        this.companyCoordinatesService = companyCoordinatesService;
    }

    @GetMapping()
    public List<CompanyCoordinates> getCompanyCoordinates(){
        return companyCoordinatesService.getAll();
    }

    @GetMapping(value = "/{id}")
    public CompanyCoordinates getCompanyCoordinates(@PathVariable Long id){
        return companyCoordinatesService.getById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void removeCompanyCoordinates(@PathVariable Long id) {
        companyCoordinatesService.delete(id);
    }

    @PostMapping()
    public void addCompanyCoordinates(@RequestBody CompanyCoordinates companyCoordinates){
        companyCoordinatesService.insert(companyCoordinates);
    }

    @PutMapping(value = "/{id}")
    public void updateCompanyCoordinates(@RequestBody CompanyCoordinates companyDetail, @PathVariable Long id) {
    }



}
