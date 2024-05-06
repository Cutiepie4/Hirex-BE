package com.ptit.Hirex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ptit.Hirex.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository <Company, Long> {

}
