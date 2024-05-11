package com.ptit.Hirex.controller;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ptit.Hirex.dtos.ResumeDTO;
import com.ptit.Hirex.service.impl.ResumeServiceImpl;

@RestController
@RequestMapping("${api.prefix}/resumes")
@CrossOrigin(origins = "*")
public class ResumeController {

    @Autowired
    private ResumeServiceImpl resumeServiceImpl;

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
