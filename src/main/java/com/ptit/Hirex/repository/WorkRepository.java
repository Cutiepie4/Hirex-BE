package com.ptit.Hirex.repository;

import com.ptit.Hirex.entity.Company;
import com.ptit.Hirex.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface WorkRepository extends JpaRepository<Work, Integer> {
    List<Work> findAllByCompany(Company company);
}
