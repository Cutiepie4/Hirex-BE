package com.ptit.Hirex.service;

import java.time.LocalDate;
import java.util.List;

import com.ptit.Hirex.dtos.LeaveReasonDTO;
import com.ptit.Hirex.entity.LeaveReason;
import com.ptit.Hirex.entity.User;

public interface LeaveReasonService {
    LeaveReason createLeaveReason(LeaveReasonDTO leaveReasonDTO,User currentUser) throws Exception;
    List<LeaveReason> getLeaveReasonsByItem(int id, LocalDate date) throws Exception;
    
    boolean checkExistReason(int work_id, LocalDate date, User currentUser) throws Exception;
    LeaveReason acceptReason(int reasonId) throws Exception;
    LeaveReason rejectReason(int reasonId) throws Exception;
    
    int countReason(int work_id, LocalDate date) throws Exception;
}
