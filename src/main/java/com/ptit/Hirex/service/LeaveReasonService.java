package com.ptit.Hirex.service;

import java.util.List;

import com.ptit.Hirex.dtos.LeaveReasonDTO;
import com.ptit.Hirex.entity.LeaveReason;

public interface LeaveReasonService {
    LeaveReason createLeaveReason(LeaveReasonDTO leaveReasonDTO) throws Exception;
    List<LeaveReason> getLeaveReasonsByItem(int id) throws Exception;
    
    boolean checkExistReason(int itemId) throws Exception;
    LeaveReason acceptReason(int reasonId) throws Exception;
    LeaveReason rejectReason(int reasonId) throws Exception;
    
    int countReason(int itemId) throws Exception;
}
