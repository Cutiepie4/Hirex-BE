package com.ptit.Hirex.service;

import java.util.Optional;

import com.ptit.Hirex.dtos.CompanyDTO;
import com.ptit.Hirex.entity.Company;

public interface CompanyService {
	Company saveCompany(CompanyDTO companyDTO);

	Company updateCompany(Long id, CompanyDTO companyDTO);

	Optional<Company> getCompany(Long id);
	
	CompanyDTO getCompanyById(Long id);
	
	void deleteCompany(Long id);
}
