package com.ptit.Hirex.controller;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ptit.Hirex.dtos.LeaveReasonDTO;
import com.ptit.Hirex.entity.Items;
import com.ptit.Hirex.entity.LeaveReason;
import com.ptit.Hirex.entity.User;
import com.ptit.Hirex.service.impl.LeaveReasonServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("${api.prefix}")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class LeaveReasonController {
    private final LeaveReasonServiceImpl leaveReasonServiceImpl;
    @PostMapping("/leave")
    public ResponseEntity<LeaveReason> createReasonLeave(@RequestBody LeaveReasonDTO leaveReasonDTO, @AuthenticationPrincipal User currentUser) {
        try {
            LeaveReason newReason = leaveReasonServiceImpl.createLeaveReason(leaveReasonDTO, currentUser);
            return ResponseEntity.ok(newReason);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
    
    @GetMapping("/leave/{work_id}/{date}")
    public List<LeaveReason> getLeaveReasonsByItem(@PathVariable int work_id, @PathVariable LocalDate date) {
        try {
            return leaveReasonServiceImpl.getLeaveReasonsByItem(work_id, date);
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
    
    @GetMapping("/leave/checkItemExist/{work_id}/{date}")
    public ResponseEntity<Boolean> checkExistReason(@PathVariable int work_id, 
            @PathVariable LocalDate date, @AuthenticationPrincipal User currentUser) {
        try {
            boolean itemExists = leaveReasonServiceImpl.checkExistReason(work_id, date, currentUser);
            return new ResponseEntity<>(itemExists, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/leave/acceptReason/{reasonId}")
    public ResponseEntity<LeaveReason> acceptReason(@PathVariable int reasonId){
        try {
            LeaveReason leaveReason = leaveReasonServiceImpl.acceptReason(reasonId);
            return new ResponseEntity<>(leaveReason, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
    }

    @PutMapping("/leave/rejectReason/{reasonId}")
    public ResponseEntity<LeaveReason> rejectReason(@PathVariable int reasonId){
        try {
            LeaveReason leaveReason = leaveReasonServiceImpl.rejectReason(reasonId);
            return new ResponseEntity<>(leaveReason, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/leave/countReason/{work_id}/{date}")
    public ResponseEntity<Integer> countReason(@PathVariable int work_id, @PathVariable LocalDate date) {
        try {
            int noReason  = leaveReasonServiceImpl.countReason(work_id, date);
            return new ResponseEntity<>(noReason, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
