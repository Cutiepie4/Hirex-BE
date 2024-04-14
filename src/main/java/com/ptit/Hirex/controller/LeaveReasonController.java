package com.ptit.Hirex.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ptit.Hirex.dtos.LeaveReasonDTO;
import com.ptit.Hirex.entity.Items;
import com.ptit.Hirex.entity.LeaveReason;
import com.ptit.Hirex.service.impl.LeaveReasonServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("${api.prefix}")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class LeaveReasonController {
    private final LeaveReasonServiceImpl leaveReasonServiceImpl;
    @PostMapping("/leave")
    public ResponseEntity<LeaveReason> createReasonLeave(@RequestBody LeaveReasonDTO leaveReasonDTO) {
        try {
            LeaveReason newReason = leaveReasonServiceImpl.createLeaveReason(leaveReasonDTO);
            return ResponseEntity.ok(newReason);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
    
    @GetMapping("/leave")
    public List<LeaveReason> getLeaveReasonsByItem(@RequestParam int id) {
        try {
            System.out.println(id);
            return leaveReasonServiceImpl.getLeaveReasonsByItem(id);
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
