package com.ptit.Hirex.controller;

import org.springframework.web.bind.annotation.*;

import com.ptit.Hirex.dtos.ExpertDTO;
import com.ptit.Hirex.dtos.WorkDTO;
import com.ptit.Hirex.entity.Work;
import com.ptit.Hirex.service.WorkService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("${api.prefix}/works")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class WorkController {

    private final WorkService workService;

	@GetMapping("/{id}")
    WorkDTO getWork(@PathVariable String id) {
        Work work = workService.validateAndGetWorkById(Integer.valueOf(id));
        ExpertDTO expertDTO = new ExpertDTO(work.getExpert().getName());
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
            work.getCreateOn()
        );
        return workDTO;
    }
		
}
