package com.ptit.Hirex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ptit.Hirex.entity.Employee;
import com.ptit.Hirex.entity.Employer;
import com.ptit.Hirex.entity.Items;
import com.ptit.Hirex.entity.LeaveReason;
import com.ptit.Hirex.entity.Work;

import java.time.LocalDate;
import java.util.List;


public interface LeaveReasonRepository extends JpaRepository<LeaveReason, Integer> {
    List<LeaveReason> findByEmployerAndWorkAndDateReason(Employer employer, Work work, LocalDate date);
    @Query("SELECT count(l) FROM LeaveReason l WHERE l.work.id = :work_id AND l.employer.id = :employerId AND l.dateReason = :date AND l.isAccept IS NULL")
    int countByItemIdAndIsAcceptIsNull(@Param("work_id") int work_id, @Param("employerId") long employerId, @Param("date") LocalDate date);
    boolean existsByEmployeeAndDateReasonAndWork(Employee employee, LocalDate date, Work work);
}
