package com.ptit.Hirex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ptit.Hirex.entity.Items;
import com.ptit.Hirex.entity.LeaveReason;
import java.util.List;


public interface LeaveReasonRepository extends JpaRepository<LeaveReason, Integer> {
    List<LeaveReason> findByItems(Items items);
}
