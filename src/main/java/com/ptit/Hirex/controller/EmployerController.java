package com.ptit.Hirex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ptit.Hirex.entity.Employee;
import com.ptit.Hirex.entity.Employer;
import com.ptit.Hirex.service.impl.EmployeeServiceImpl;
import com.ptit.Hirex.service.impl.EmployerServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("${api.prefix}/employer")
@RequiredArgsConstructor
public class EmployerController {
	
		
    @Autowired
    private EmployerServiceImpl employerServiceImpl;

    @GetMapping("/{userId}")
    public ResponseEntity<Employer> getEmployee(@PathVariable long userId) {
        try {
            Employer employer = employerServiceImpl.getEmployer(userId);
            return ResponseEntity.ok(employer);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
