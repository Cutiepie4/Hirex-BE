package com.ptit.Hirex.controller;

import com.ptit.Hirex.dtos.ResumeDTO;
import com.ptit.Hirex.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Base64;

@RestController
@RequestMapping("${api.prefix}/resumes")
@CrossOrigin(origins = "*")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadResume(@ModelAttribute ResumeDTO resumeDTO, @RequestParam(value = "file", required = false) MultipartFile file) {
        if (file != null && !file.isEmpty()) {
            try {
                String fileName = file.getOriginalFilename();
                // Convert file to base64
                String base64Data = Base64.getEncoder().encodeToString(file.getBytes());
                resumeService.uploadResume(fileName, base64Data, resumeDTO.getEmployerId());
                return ResponseEntity.ok("Resume uploaded successfully");
            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload resume");
            }
        } else {
            return ResponseEntity.badRequest().body("No file uploaded");
        }
    }
}
