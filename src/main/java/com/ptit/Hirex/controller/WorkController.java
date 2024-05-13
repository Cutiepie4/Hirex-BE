package com.ptit.Hirex.controller;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ptit.Hirex.dtos.*;
import com.ptit.Hirex.entity.Work;
import com.ptit.Hirex.service.WorkService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("${api.prefix}/works")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class WorkController {

    private final WorkService workService;
    private final ModelMapper modelMapper;

	@GetMapping("/{id}")
    ResponseEntity<?>  getWork(@PathVariable String id, @RequestParam(required = false) String employer) {
        Work work = workService.validateAndGetWorkById(Integer.valueOf(id));
        if (employer == null) {
            try {
                
                ExpertDTO expertDTO = new ExpertDTO(work.getExpert().getName());
                EmployerDTO employerDTO = modelMapper.map(work.getCompany().getEmployer(), EmployerDTO.class);
                CompanyDTO companyDTO = modelMapper.map(work.getCompany(), CompanyDTO.class);
                companyDTO.setEmployer(employerDTO);
        
                WorkDTO workDTO = new WorkDTO(
                    work.getId(),
                    work.getName(),
                    work.getAddress(),
                    work.getDescription(),
                    work.getStartTime(),
                    work.getEndTime(),
                    work.getStartDate(),
                    work.getEndDate(),
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
    }
		
}
