package org.search.jobportal.service;

import org.search.jobportal.dto.CompanyDto;
import org.search.jobportal.entity.Company;

import java.util.List;

public interface ICompanyService {
    List<CompanyDto> getAllCompanies();
}
