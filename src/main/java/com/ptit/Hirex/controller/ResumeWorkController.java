package com.ptit.Hirex.controller;

import java.util.*;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ptit.Hirex.dtos.*;
import com.ptit.Hirex.entity.ResumeWork;
import com.ptit.Hirex.service.ResumeWorkService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("${api.prefix}/resume_works")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ResumeWorkController {

    private final ResumeWorkService resumeWorkService;
    private final ModelMapper modelMapper;

    @GetMapping("")
    ResponseEntity<?> getResumeWorks(@RequestParam String workId) {
        int workIdReq = Integer.valueOf(workId);
        List<ResumeWork> resumeWorks = resumeWorkService.getResumeWorksByWorkId(workIdReq);
        List<ResumeWorkDTO> resumeDTOs = resumeWorks
                .stream()
                .map(resumeWork -> modelMapper.map(resumeWork, ResumeWorkDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(resumeDTOs);
    }

    @PostMapping("")
    ResponseEntity<?> applyWork(@Valid @RequestBody ResumeWorkRequest resumeWorkRequest) {
        ResumeWork result = resumeWorkService.applyWork(resumeWorkRequest);
        return ResponseEntity.ok("Tao thanh cong");
    }

    @PostMapping("/hire")
    ResponseEntity<?> decideStatusResumeWork(@Valid @RequestBody ResumeWorkStatusRequest resumeWorkRequest) {
        try {
            
            ResumeWork result = resumeWorkService.decideStatus(resumeWorkRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("Thanh cong");
    }
}
