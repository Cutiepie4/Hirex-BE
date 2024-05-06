package com.ptit.Hirex.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ptit.Hirex.dtos.EducationDTO;
import com.ptit.Hirex.entity.Education;
import com.ptit.Hirex.entity.Employee;
import com.ptit.Hirex.repository.EducationRepostitory;
import com.ptit.Hirex.repository.EmployeeRepository;
import com.ptit.Hirex.service.EducationService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EducationServiceImpl implements EducationService {

	private final EducationRepostitory educationRepostitory;
	private final EmployeeRepository employeeRepository;
	private final ModelMapper modelMapper;

	@Override
	public void saveEducation(EducationDTO educationDTO) {
		Employee employee = employeeRepository.findById(educationDTO.getEmployeeId())
				.orElseThrow(() -> new RuntimeException("Employee not found for id: " + educationDTO.getEmployeeId()));

		Education education = modelMapper.map(educationDTO, Education.class);
		education.setEmployee(employee);
		educationRepostitory.save(education);
	}

	@Override
	public void updateEducation(Long educationId, EducationDTO educationDTO) {

		Education education = educationRepostitory.findById(educationId)
				.orElseThrow(() -> new RuntimeException("Educaton not found for id: " + educationId));

		Employee employee = employeeRepository.findById(educationDTO.getEmployeeId())
				.orElseThrow(() -> new RuntimeException("Employee not found for id: " + educationDTO.getEmployeeId()));

		education = Education.builder()
				.id(educationDTO.getId())
				.level(educationDTO.getLevel())
				.institution(educationDTO.getInstitution())
				.major(educationDTO.getMajor())
				.description(educationDTO.getDescription())
				.startDate(educationDTO
				.getStartDate())
				.endDate(educationDTO.getEndDate())
				.build();
		education.setEmployee(employee);

		educationRepostitory.save(education);
	}

	@Override
	public void deleteEducation(Long educationId) {
		if (!educationRepostitory.existsById(educationId)) {
			throw new RuntimeException("Experience not found for id: " + educationId);
		}
		educationRepostitory.deleteById(educationId);
	}

}
