package org.search.jobportal.service.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.internal.build.AllowNonPortable;
import org.search.jobportal.dto.CompanyDto;
import org.search.jobportal.entity.Company;
import org.search.jobportal.repository.CompanyRepository;
import org.search.jobportal.service.ICompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements ICompanyService {

    private final CompanyRepository companyRepository;

//    @AllowNonPortable
//    public CompanyServiceImpl(CompanyRepository companyRepository) {
//        this.companyRepository = companyRepository;
//    }

    @Override
    public List<CompanyDto> getAllCompanies() {

        List<Company> companyList = companyRepository.findAll();
        return companyList.stream().map(this::transformtoDTO).collect(Collectors.toList());

    }

    private CompanyDto transformtoDTO(Company company) {

        return new CompanyDto(company.getId(), company.getName(), company.getLogo(), company.getIndustry(),
                company.getSize(), company.getRating(), company.getDescription(), company.getEmployees(),
                company.getWebsite(), company.getCreatedAt());

    }
}
