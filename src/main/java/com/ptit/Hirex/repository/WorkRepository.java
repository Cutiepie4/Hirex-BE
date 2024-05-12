package com.ptit.Hirex.repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ptit.Hirex.entity.Work;

@Repository
public interface WorkRepository extends JpaRepository<Work, Integer>{

	List<Work> findByEndTimeAfter(LocalDate currentDate);
	
	List<Work> findByJobPositionContainingIgnoreCaseAndTypeWorkContainingIgnoreCaseAndJobLocationContainingIgnoreCaseAndTypeJobContainingIgnoreCaseAndDescriptionContainingIgnoreCaseAndWageLessThanEqual(
	    String jobPosition, 
	    String typeWork, 
	    String jobLocation, 
	    String typeJob, 
	    String description, 
	    Long wage
	);

	List<Work> findByJobPositionContainingAndTypeWorkContainingAndJobLocationContainingAndTypeJobContainingAndWageBetween(
		    String jobPosition, String typeWork, String jobLocation, String typeJob, Long minWage, Long maxWage);

}
