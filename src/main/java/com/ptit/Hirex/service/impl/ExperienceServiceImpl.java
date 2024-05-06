package com.ptit.Hirex.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ptit.Hirex.dtos.ExperienceDTO;
import com.ptit.Hirex.entity.Employee;
import com.ptit.Hirex.entity.Experience;
import com.ptit.Hirex.repository.EmployeeRepository;
import com.ptit.Hirex.repository.ExperienceRepository;
import com.ptit.Hirex.service.ExperienceService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ExperienceServiceImpl implements ExperienceService {

    private final ExperienceRepository experienceRepository;
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;


    @Override
    public void saveExperience(ExperienceDTO experienceDTO) {
        Employee employee = employeeRepository.findById(experienceDTO.getEmployeeId())
            .orElseThrow(() -> new RuntimeException("Employee not found for id: " + experienceDTO.getEmployeeId()));

        Experience experience = modelMapper.map(experienceDTO, Experience.class);
        experience.setEmployee(employee);
        experienceRepository.save(experience);
    }

    @Override
    public void updateExperience(Long experienceId, ExperienceDTO experienceDTO) {
    	
        Experience experience = experienceRepository.findById(experienceId)
            .orElseThrow(() -> new RuntimeException("Experience not found for id: " + experienceId));
            
        Employee employee = employeeRepository.findById(experienceDTO.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found for id: " + experienceDTO.getEmployeeId()));
        
         experience = Experience.builder()
        		.id(experienceDTO.getId())
        		.jobTitle(experienceDTO.getJobTitle())
        		.description(experienceDTO.getDescription())
        		.startDate(experienceDTO.getStartDate())
        		.endDate(experienceDTO.getEndDate())
        		.company(experienceDTO.getCompany())
				.build();
        experience.setEmployee(employee);
        
        experienceRepository.save(experience);
    }

    @Override
    public void deleteExperience(Long experienceId) {
        if (!experienceRepository.existsById(experienceId)) {
            throw new RuntimeException("Experience not found for id: " + experienceId);
        }
        experienceRepository.deleteById(experienceId);
    }
}
																														