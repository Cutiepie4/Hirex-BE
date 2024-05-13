package com.ptit.Hirex.service;

import java.util.Optional;

import com.ptit.Hirex.dtos.Company0DTO;
import com.ptit.Hirex.entity.Company;

public interface CompanyService {
	Company saveCompany(Company0DTO companyDTO);

	Company updateCompany(Long id, Company0DTO companyDTO);

	Optional<Company> getCompany(Long id);
	
	Company0DTO getCompanyById(Long id);
	
	void deleteCompany(Long id);
}
