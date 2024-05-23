package com.ptit.Hirex.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.Hirex.dtos.Company0DTO;  
import com.ptit.Hirex.dtos.CompanyDTO;
import com.ptit.Hirex.dtos.CompanyDetailDTO;
import com.ptit.Hirex.entity.Company;
import com.ptit.Hirex.entity.Review;
import com.ptit.Hirex.exceptions.EntityNotFoundException;
import com.ptit.Hirex.repository.CompanyRepository;
import com.ptit.Hirex.service.CompanyService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService {

	private final CompanyRepository companyRepository;
	private final ModelMapper modelMapper;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Company saveCompany(Company0DTO companyDTO) {
		Company company = modelMapper.map(companyDTO, Company.class);
		return companyRepository.save(company);
	}

	@Override
	public Company0DTO getCompanyById(Long id) {
		Optional<Company> company = companyRepository.findById(id);
		if (company.isPresent()) {
			return convertToDTO(company.get());
		}
		return null;
	}

	@Override
	public CompanyDetailDTO getCompanyDetailById(Long id) {
		Company company = companyRepository.findById(id).orElse(null);
		if (company == null)
			throw new EntityNotFoundException("Không tìm thấy công ty này");
		return modelMapper.map(company, CompanyDetailDTO.class);
	}

	@Override
	public List<Company> getCompanies() {
		return companyRepository.findAll();
	}

	private Company0DTO convertToDTO(Company company) {
		Company0DTO dto = new Company0DTO();
		dto.setImageBase64(company.getImageBase64());
		return dto;
	}

	@Override
	public Company updateCompany(Long id, Company0DTO companyDTO) {
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

	public CompanyDetailDTO getAllCompaniesWithReviewsSortedByRateDesc(Long id) {
		TypedQuery<Company> query = entityManager.createQuery(
			"select c from Company c left join fetch c.reviews r where c.id = :id order by case when r.user.id = 1 then 1 else 2 end, r.overallRate desc", 
			Company.class);
		query.setParameter("id", id);
		Company company = query.getSingleResult();
		return modelMapper.map(company, CompanyDetailDTO.class);

		// CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		// CriteriaQuery<Company> query = cb.createQuery(Company.class);
		// Root<Company> companyRoot = query.from(Company.class);
		// Join<Company, Review> reviews = companyRoot.join("reviews", JoinType.LEFT);

		// query.select(companyRoot);

		// // Order by review's rate in descending order
		// query.orderBy(cb.desc(reviews.get("rate")));

		// TypedQuery<Company> typedQuery = entityManager.createQuery(query);

		// return typedQuery.getResultList();
	}

}
