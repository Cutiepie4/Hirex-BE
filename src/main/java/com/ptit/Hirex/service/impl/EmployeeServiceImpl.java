package com.ptit.Hirex.service.impl;


import com.ptit.Hirex.entity.Employee;
import com.ptit.Hirex.service.EmployeeService;
import com.ptit.Hirex.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }
}
