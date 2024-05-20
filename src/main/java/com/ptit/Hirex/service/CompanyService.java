package com.ptit.Hirex.service;

import java.util.*;

import com.ptit.Hirex.dtos.*;
import com.ptit.Hirex.entity.Company;

public interface CompanyService {
	Company saveCompany(Company0DTO companyDTO);

	Company updateCompany(Long id, Company0DTO companyDTO);

	List<Company> getCompanies();

	Optional<Company> getCompany(Long id);
	
	Company0DTO getCompanyById(Long id);

	CompanyDetailDTO getCompanyDetailById(Long id);
	
	void deleteCompany(Long id);
}
