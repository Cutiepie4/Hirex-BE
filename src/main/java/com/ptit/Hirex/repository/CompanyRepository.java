package com.ptit.Hirex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ptit.Hirex.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository <Company, Long> {
    @Query("select c from Company c left join fetch c.reviews r where c.id = :id order by r.overallRate desc")
    Company findAllWithReviewsSortedByRateDesc(Long id);
}
