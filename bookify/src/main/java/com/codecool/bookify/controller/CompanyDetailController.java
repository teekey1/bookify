package com.codecool.bookify.controller;

import com.codecool.bookify.model.CompanyDetail;
import com.codecool.bookify.service.CompanyDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company-details")
public class CompanyDetailController {
    private final CompanyDetailService companyDetailService;

    @Autowired
    public CompanyDetailController(CompanyDetailService companyDetailService) {
        this.companyDetailService = companyDetailService;
    }

    @GetMapping()
    public List<CompanyDetail> getCompanyDetail(){
        return companyDetailService.getAll();
    }

    @GetMapping(value = "/{id}")
    public CompanyDetail getCompanyDetail(@PathVariable Long id){
        return companyDetailService.getById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void removeCompanyDetail(@PathVariable Long id) {
        companyDetailService.delete(id);
    }

    @PostMapping()
    public void addCompanyDetail(@RequestBody CompanyDetail companyDetail){
        companyDetailService.insert(companyDetail);
    }

    @PutMapping(value = "/{id}")
    public void updateCompanyDetail(@RequestBody CompanyDetail companyDetail, @PathVariable Long id) {
    }
}
