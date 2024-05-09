package com.ptit.Hirex.repository;

import com.ptit.Hirex.entity.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppreciationRepository extends JpaRepository<Appreciation, Long> {
}
