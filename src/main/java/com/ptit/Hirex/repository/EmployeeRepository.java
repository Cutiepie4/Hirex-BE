package com.ptit.Hirex.repository;

import com.ptit.Hirex.entity.Employee;
import com.ptit.Hirex.entity.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	Optional<Employee> findByUserId(Long userId);
}
