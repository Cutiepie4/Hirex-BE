package com.ptit.Hirex.controller;

import java.util.*;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ptit.Hirex.dtos.*;
import com.ptit.Hirex.entity.Appreciation;
import com.ptit.Hirex.entity.Employee;
import com.ptit.Hirex.entity.Work;
import com.ptit.Hirex.service.AppreciationService;
import com.ptit.Hirex.service.EmployeeService;
import com.ptit.Hirex.service.WorkService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("${api.prefix}/appreciations")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AppreciationController {

    private final AppreciationService appreciationService;
    private final EmployeeService employeeService;
    private final WorkService workService;
    private final ModelMapper modelMapper;

    @GetMapping("")
    ResponseEntity<?> getAppreciations(@RequestParam String employeeId, @RequestParam String workId) {
        try {
            Employee employee = employeeService.getEmployeeById(Long.valueOf(employeeId));
            Work work = workService.validateAndGetWorkById(Integer.valueOf(workId));
            Appreciation appreciation = appreciationService.getAppreciationByEmployeeAndWork(employee, work);
            AppreciationDTO appreciationDTO = modelMapper.map(appreciation, AppreciationDTO.class);
            return ResponseEntity.ok(appreciationDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Lỗi server");
        }
    }

    @PostMapping("")
    ResponseEntity<?> saveAppreciation(@Valid @RequestBody AppreciationRequest appreciationRequest) {
        try {
            Appreciation appreciation = appreciationService.saveAppreciation(appreciationRequest);
            AppreciationDTO appreciationDTO = modelMapper.map(appreciation, AppreciationDTO.class);
            return ResponseEntity.ok(appreciationDTO);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Lỗi server");
        }
    }

}
