package com.ptit.Hirex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ptit.Hirex.entity.Education;

@Repository
public interface EducationRepostitory extends JpaRepository<Education, Long> {
	
}
