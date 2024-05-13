package com.ptit.Hirex.controller;

import java.io.IOException;
import java.util.*;

import com.ptit.Hirex.dtos.*;
import com.ptit.Hirex.entity.*;
import com.ptit.Hirex.service.*;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.ptit.Hirex.dtos.ResumeDTO;
import com.ptit.Hirex.service.impl.ResumeServiceImpl;
import java.util.stream.Collectors;

@RestController
@RequestMapping("${api.prefix}/resumes")
@CrossOrigin(origins = "*")
public class ResumeController {

    @Autowired
    private UserService userService;

    @Autowired
    private ResumeServiceImpl resumeServiceImpl;

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("")
    public ResponseEntity<?> getMyResumes(@AuthenticationPrincipal User currentUser) {
        try {            
            User user = userService.findByPhoneNumber(currentUser.getPhoneNumber());
            Employee employee = employeeService.getEmployee(user.getId());
            List<Resume> resumes = resumeService.getMyResumes(employee.getId());
            List<ResumeDTO> resumeDTOs = resumes
                                            .stream()
                                            .map(resume -> modelMapper.map(resume, ResumeDTO.class))
                                            .collect(Collectors.toList());
            return ResponseEntity.ok(resumeDTOs);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Lỗi server");
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadResume(@ModelAttribute ResumeDTO resumeDTO, @RequestParam(value = "file", required = false) MultipartFile file) {
        if (file != null && !file.isEmpty()) {
            try {
                String fileName = file.getOriginalFilename();
                // Convert file to base64
                String base64Data = Base64.getEncoder().encodeToString(file.getBytes());
                
                long fileSize = file.getSize(); 

                resumeServiceImpl.uploadResume(fileName, base64Data, fileSize, resumeDTO.getEmployerId());
                return ResponseEntity.ok("Resume uploaded successfully");
            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload resume");
            }
        } else {
            return ResponseEntity.badRequest().body("No file uploaded");
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteResume(@PathVariable("id") Long resumeId) {
        try {
            boolean deleted = resumeServiceImpl.deleteResume(resumeId);
            if (deleted) {
                return ResponseEntity.ok("Resume deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resume not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete resume");
        }
    }
}
