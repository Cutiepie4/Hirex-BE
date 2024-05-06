package com.ptit.Hirex.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ptit.Hirex.entity.Employer;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long> {
	Optional<Employer> findByUserId(Long userId);

}
