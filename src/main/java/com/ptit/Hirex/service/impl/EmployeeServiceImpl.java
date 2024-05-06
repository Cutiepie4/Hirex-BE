package com.ptit.Hirex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.Hirex.entity.Employee;
import com.ptit.Hirex.entity.User;
import com.ptit.Hirex.repository.EmployeeRepository;
import com.ptit.Hirex.repository.UserRepository;
import com.ptit.Hirex.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
	public Employee getEmployee(Long userId) {
		return employeeRepository.findByUserId(userId).orElseGet(() -> save(userId));
	}
	
    @Override
    public Employee save(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User  not found with ID: " + userId));
        
        Employee employee = new Employee();
        employee.setUser(user);
        return employeeRepository.save(employee);
    }

    @Override
    public void updateAbout(Long id, String about) {
        Employee employee = employeeRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Employee not found with id: " + id));
        employee.setAbout(about);
        employeeRepository.save(employee);
    }

    @Override
    public void delete(Long id) {
        if (!employeeRepository.existsById((long) id)) {
            throw new RuntimeException("Attempted to delete a non-existing employee with ID: " + id);
        }
        employeeRepository.deleteById(id);
    }
}
