package com.ptit.Hirex.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ptit.Hirex.dtos.LeaveReasonDTO;
import com.ptit.Hirex.entity.Items;
import com.ptit.Hirex.entity.LeaveReason;
import com.ptit.Hirex.entity.User;
import com.ptit.Hirex.repository.ItemsRepository;
import com.ptit.Hirex.repository.LeaveReasonRepository;
import com.ptit.Hirex.repository.WorkRepository;
import com.ptit.Hirex.service.EmployeeService;
import com.ptit.Hirex.service.LeaveReasonService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LeaveReasonServiceImpl implements LeaveReasonService {
    private final LeaveReasonRepository leaveReasonRepository;
    private final ItemsRepository itemsRepository;
    private final EmployeeService employeeService;
    private final WorkRepository workRepository;

    @Override
    public LeaveReason createLeaveReason(LeaveReasonDTO leaveReasonDTO, User currentUser) throws Exception {
        LeaveReason leaveReason = new LeaveReason();
        leaveReason.setDateReason(leaveReasonDTO.getDateReason());
        leaveReason.setReason(leaveReasonDTO.getLeaveReason());
        leaveReason.setEmployee(employeeService.getEmployee(currentUser.getId()));
        leaveReason.setEmployer(workRepository.findById(leaveReasonDTO.getWork_id()).get().getCompany().getEmployer());
        leaveReason.setWork(workRepository.findById(leaveReasonDTO.getWork_id()).get());
        return leaveReasonRepository.save(leaveReason);
    }

    @Override
    public List<LeaveReason> getLeaveReasonsByItem(int work_id, LocalDate date) throws Exception {
        return leaveReasonRepository.findByEmployerAndWorkAndDateReason(workRepository.findById(work_id).get().getCompany().getEmployer(), workRepository.findById(work_id).get(), date);
    }

    @Override
    public boolean checkExistReason(int work_id, LocalDate date, User currentUser) throws Exception {
        return leaveReasonRepository.existsByEmployeeAndDateReasonAndWork(employeeService.getEmployee(currentUser.getId()), date, workRepository.findById(work_id).get());

    }
    @Override
    public LeaveReason acceptReason(int reasonId) throws Exception {
        LeaveReason leaveReason = leaveReasonRepository.findById(reasonId).orElseThrow(
                () -> new Exception("Lỗi:" + reasonId));

        leaveReason.setIsAccept(true);
        return leaveReasonRepository.save(leaveReason);
    }

    @Override
    public LeaveReason rejectReason(int reasonId) throws Exception {
        System.out.println("hihihihi");
        LeaveReason leaveReason = leaveReasonRepository.findById(reasonId).orElseThrow(
                () -> new Exception("Lỗi: "+reasonId));
        leaveReason.setIsAccept(false);
        return leaveReasonRepository.save(leaveReason);
    }

    @Override
    public int countReason(int work_id, LocalDate date) {
        long employerId = workRepository.findById(work_id).get().getCompany().getEmployer().getId();
        return leaveReasonRepository.countByItemIdAndIsAcceptIsNull(work_id, employerId, date);
    }
}
