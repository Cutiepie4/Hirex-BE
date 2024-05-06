package com.ptit.Hirex.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ptit.Hirex.dtos.CompanyDTO;
import com.ptit.Hirex.entity.Company;
import com.ptit.Hirex.repository.CompanyRepository;
import com.ptit.Hirex.service.CompanyService;
import org.modelmapper.ModelMapper;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Company saveCompany(CompanyDTO companyDTO) {
		Company company = modelMapper.map(companyDTO, Company.class);
		return companyRepository.save(company);
	}

	@Override
	public Company updateCompany(Long id, CompanyDTO companyDTO) {
		Optional<Company> existingCompany = companyRepository.findById(id);
		if (existingCompany.isPresent()) {
			Company company = existingCompany.get();
			modelMapper.map(companyDTO, company);
			return companyRepository.save(company);
		} else {
			throw new RuntimeException("Company not found");
		}
	}

	@Override
	public Optional<Company> getCompany(Long id) {
		return companyRepository.findById(id);
	}

	@Override
	public void deleteCompany(Long id) {
		if (companyRepository.existsById(id)) {
			companyRepository.deleteById(id);
		} else {
			throw new RuntimeException("Company not found");
		}
	}
}
