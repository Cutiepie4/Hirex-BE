package com.ptit.Hirex.service;

import com.ptit.Hirex.entity.Employer;
import org.springframework.stereotype.Service;

@Service
public interface EmployerService {
    void save(Employer employer);
}
