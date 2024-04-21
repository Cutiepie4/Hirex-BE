package com.ptit.Hirex.service;

import com.ptit.Hirex.entity.Employee;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    
    void update(Employee employee);
    
    void delete(Long id);

	Employee save(Long idUser);

    Employee getEmployee(Long userId);
}