package com.ptit.Hirex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.Hirex.entity.Employer;
import com.ptit.Hirex.entity.User;
import com.ptit.Hirex.repository.EmployerRepository;
import com.ptit.Hirex.repository.UserRepository;
import com.ptit.Hirex.service.EmployerService;

@Service
public class EmployerServiceImpl implements EmployerService {

	@Autowired
	EmployerRepository employerRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public Employer getEmployer(Long idUser) {
		return employerRepository.findByUserId(idUser).orElseGet(() -> save(idUser));
	}

	@Override
	public Employer save(Long userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("User  not found with ID: " + userId));

		Employer employer = new Employer();
		employer.setUser(user);
		return employerRepository.save(employer);
	}

}
