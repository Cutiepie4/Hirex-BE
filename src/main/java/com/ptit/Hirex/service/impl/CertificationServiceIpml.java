package com.ptit.Hirex.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ptit.Hirex.dtos.CertificationDTO;
import com.ptit.Hirex.entity.Certification;
import com.ptit.Hirex.entity.Employee;
import com.ptit.Hirex.repository.CertificationRepository;
import com.ptit.Hirex.repository.EmployeeRepository;
import com.ptit.Hirex.service.CertificationService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CertificationServiceIpml implements CertificationService{

	private final CertificationRepository certificationRepostitory ;
	private final EmployeeRepository employeeRepository;
	private final ModelMapper modelMapper;

	@Override
	public void saveCertification(CertificationDTO certificationDTO) {
		Employee employee = employeeRepository.findById(certificationDTO.getEmployeeId())
				.orElseThrow(() -> new RuntimeException("Employee not found for id: " + certificationDTO.getEmployeeId()));

		Certification certification = modelMapper.map(certificationDTO, Certification.class);
		certification.setEmployee(employee);
		certificationRepostitory.save(certification);
	}

	@Override
	public void updateCertification(Long certificationId, CertificationDTO certificationDTO) {

		Certification certification = certificationRepostitory.findById(certificationId)
				.orElseThrow(() -> new RuntimeException("Educaton not found for id: " + certificationId));

		Employee employee = employeeRepository.findById(certificationDTO.getEmployeeId())
				.orElseThrow(() -> new RuntimeException("Employee not found for id: " + certificationDTO.getEmployeeId()));

		certification = Certification.builder()
				.id(certificationDTO.getId())
				.name(certificationDTO.getName())
				.description(certificationDTO.getDescription())
				.startDate(certificationDTO.getStartDate())
				.endDate(certificationDTO.getEndDate())
				.build();
		certification.setEmployee(employee);

		certificationRepostitory.save(certification);
	}

	@Override
	public void deleteCertification(Long certificationId) {
		if (!certificationRepostitory.existsById(certificationId)) {
			throw new RuntimeException("Experience not found for id: " + certificationId);
		}
		certificationRepostitory.deleteById(certificationId);

	}

}
