package com.ptit.Hirex.repository;

import com.ptit.Hirex.entity.*;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Optional<Review> findByUserIdAndCompanyId(Long userId, Long companyId);
}
