package com.ptit.Hirex.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ptit.Hirex.dtos.ResumeWorkRequest;
import com.ptit.Hirex.entity.ResumeWork;
import com.ptit.Hirex.service.ResumeWorkService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("${api.prefix}/work_resumes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ResumeWorkController {

    private final ResumeWorkService resumeWorkService;
		
    @PostMapping("")
    ResponseEntity<?> applyWork(@Valid @RequestBody ResumeWorkRequest resumeRequest) throws URISyntaxException {
    	ResumeWork result = resumeWorkService.applyWork(resumeRequest);
    	return ResponseEntity.created(new URI("/api/work_resumes/" + result.getId()))
                .body("vcl");
    }
}
