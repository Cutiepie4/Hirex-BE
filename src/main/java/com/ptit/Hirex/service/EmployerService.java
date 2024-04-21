package com.ptit.Hirex.service;

import org.springframework.stereotype.Service;

import com.ptit.Hirex.entity.Employer;

@Service
public interface EmployerService {
	
	Employer save(Long idUser);

	Employer getEmployer(Long userId);
}
