package com.ptit.Hirex.controller;

import java.util.*;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ptit.Hirex.dtos.*;
import com.ptit.Hirex.entity.Work;
import com.ptit.Hirex.repository.WorkRepository;
import com.ptit.Hirex.service.WorkService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("${api.prefix}/works")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class WorkController {

    private final WorkService workService;
    private final ModelMapper modelMapper;

	@GetMapping("")
    ResponseEntity<?> getWorks(@RequestParam(required = false) String companyId) {
        try {
            List<Work> works = workService.getWorks(companyId);
            List<WorkEmployeeDTO> workDTOs = works
                    .stream()
                    .map(work -> modelMapper.map(work, WorkEmployeeDTO.class))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(workDTOs);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Lỗi server");
        }
    }

	@GetMapping("/{id}")
    ResponseEntity<?>  getWork(@PathVariable String id, @RequestParam(required = false) String employer) {
        try {
            Work work = workService.validateAndGetWorkById(Integer.valueOf(id));
            if (employer == null) {
                try {
                    
                    ExpertDTO expertDTO = new ExpertDTO(work.getExpert().getName());
                    EmployerDTO employerDTO = modelMapper.map(work.getCompany().getEmployer(), EmployerDTO.class);
                    CompanyDTO companyDTO = modelMapper.map(work.getCompany(), CompanyDTO.class);
                    companyDTO.setEmployer(employerDTO);
            
                    WorkDescriptionDTO workDTO = new WorkDescriptionDTO(
                        work.getId(),
                        work.getName(),
                        work.getAddress(),
                        work.getDescription(),
                        work.getStartTime(),
                        work.getEndTime(),
                        work.getStartDate(),
                        work.getEndDate(),
                        work.getJobPosition(),
                        work.getTypeWork(),
                        work.getTypeJob(),
                        work.getWage(),
                        expertDTO,
                        companyDTO,
                        work.getCreateOn()
                    );
                    return ResponseEntity.ok(workDTO);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return ResponseEntity.ok("vcl");
            } else {
                WorkEmployerDTO workEmployerDTO = modelMapper.map(work, WorkEmployerDTO.class);
                return ResponseEntity.ok(workEmployerDTO);
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Lỗi server");
        }
    }
		
}
