package com.ptit.Hirex.controller;

import java.util.*;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ptit.Hirex.dtos.*;
import com.ptit.Hirex.entity.Appreciation;
import com.ptit.Hirex.service.AppreciationService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("${api.prefix}/appreciations")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AppreciationController {

    private final AppreciationService appreciationService;
    private final ModelMapper modelMapper;

    @GetMapping("")
    ResponseEntity<?> getAppreciations(@RequestParam String id) {
        try {
            Long appreciationId = Long.valueOf(id);
            Appreciation appreciation = appreciationService.validateAndGetAppreciationById(appreciationId);
            AppreciationDTO appreciationDTO = modelMapper.map(appreciation, AppreciationDTO.class);
            return ResponseEntity.ok(appreciationDTO);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Lỗi server");
        }
    }

    @PostMapping("")
    ResponseEntity<?> applyWork(@Valid @RequestBody AppreciationRequest appreciationRequest) {
        try {
            Appreciation result = appreciationService.saveAppreciation(appreciationRequest);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Lỗi server");
        }
    }

}
