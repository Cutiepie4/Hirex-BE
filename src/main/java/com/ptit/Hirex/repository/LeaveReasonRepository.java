package com.ptit.Hirex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ptit.Hirex.entity.Items;
import com.ptit.Hirex.entity.LeaveReason;
import java.util.List;


public interface LeaveReasonRepository extends JpaRepository<LeaveReason, Integer> {
    List<LeaveReason> findByItems(Items items);
    @Query("SELECT count(l) FROM LeaveReason l WHERE l.items.id = :itemId AND l.isAccept IS NULL")
    int countByItemIdAndIsAcceptIsNull(@Param("itemId") int itemId);

}
