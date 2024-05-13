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
        try {
            int workIdReq = Integer.valueOf(workId);
            List<ResumeWork> resumeWorks = resumeWorkService.getResumeWorksByWorkId(workIdReq);
            List<ResumeWorkDTO> resumeDTOs = resumeWorks
                    .stream()
                    .map(resumeWork -> modelMapper.map(resumeWork, ResumeWorkDTO.class))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(resumeDTOs);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Lỗi server");
        }
    }

    @PostMapping("")
    ResponseEntity<?> applyWork(@Valid @RequestBody ResumeWorkRequest resumeWorkRequest) {
        try {            
            ResumeWork result = resumeWorkService.applyWork(resumeWorkRequest);
            return ResponseEntity.ok("Tạo thành công");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Lỗi server");
        }
    }

    @PostMapping("/hire")
    ResponseEntity<?> decideStatusResumeWork(@Valid @RequestBody ResumeWorkStatusRequest resumeWorkRequest) {
        try {
            ResumeWork result = resumeWorkService.decideStatus(resumeWorkRequest);
            return ResponseEntity.ok("Thành công");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Lỗi server");
        }
    }
}
