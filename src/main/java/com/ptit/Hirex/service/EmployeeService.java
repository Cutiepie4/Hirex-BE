package com.ptit.Hirex.service;

import com.ptit.Hirex.entity.Employee;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    void save(Employee employee);
}
