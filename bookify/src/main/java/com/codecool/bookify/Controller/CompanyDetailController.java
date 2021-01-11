package com.codecool.bookify.Controller;

import com.codecool.bookify.Model.CompanyDetail;
import com.codecool.bookify.Service.CompanyDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyDetailController {
    private final CompanyDetailService companyDetailService;

    @Autowired
    public CompanyDetailController(CompanyDetailService companyDetailService) {
        this.companyDetailService = companyDetailService;
    }

    @GetMapping("/company-details")
    public List<CompanyDetail> getCompanyDetail(){
        return companyDetailService.getAll();
    }

    @GetMapping("company-details/{id}")
    public CompanyDetail getCompanyDetail(@PathVariable Long id){
        return companyDetailService.getById(id);
    }

    @DeleteMapping("company-details/{id}")
    public void removeCompanyDetail(@PathVariable Long id) {
        companyDetailService.delete(id);
    }

    @PostMapping("/company-details")
    public void addCompanyDetail(@RequestBody CompanyDetail companyDetail){
        companyDetailService.insert(companyDetail);
    }

    @PutMapping("/company-details/{id}")
    public void updateCompanyDetail(@RequestBody CompanyDetail companyDetail, @PathVariable Long id) {
    }
}
