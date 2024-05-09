package com.ptit.Hirex.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ptit.Hirex.dtos.ApplicationWorkRequest;
import com.ptit.Hirex.entity.ApplicationWork;
import com.ptit.Hirex.service.ApplicationWorkService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("${api.prefix}/applications")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ApplicationController {

    private final ApplicationWorkService applicationWorkService;
		
    @PostMapping("")
    ResponseEntity<?> applyWork(@Valid @RequestBody ApplicationWorkRequest applicationRequest) throws URISyntaxException {
    	ApplicationWork result = applicationWorkService.applyWork(applicationRequest);
    	return ResponseEntity.created(new URI("/api/applications/" + result.getId()))
                .body("vcl");
    }
}
