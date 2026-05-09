package org.search.jobportal.company.controller;

import lombok.RequiredArgsConstructor;
import org.search.jobportal.dto.CompanyDto;
import org.search.jobportal.entity.Company;
import org.search.jobportal.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final ICompanyService companyService;

//    @Autowired
//    public CompanyController(ICompanyService companyService) {
//        this.companyService = companyService;
//    }

    @GetMapping(version = "1.0")
    public ResponseEntity<List<CompanyDto>> getAllCompanies() {
        List<CompanyDto> companies = companyService.getAllCompanies();

        return ResponseEntity.ok().body(companies);
    }


}
