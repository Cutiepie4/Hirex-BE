package com.ptit.Hirex.service.impl;

import com.ptit.Hirex.entity.Employer;
import com.ptit.Hirex.service.EmployerService;
import com.ptit.Hirex.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerServiceImpl implements EmployerService {
    @Autowired
    EmployerRepository employerRepository;

    @Override
    public void save(Employer employer) {
        employerRepository.save(employer);
    }
}
