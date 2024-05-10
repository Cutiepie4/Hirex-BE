package com.ptit.Hirex.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.Hirex.entity.Employee;
import com.ptit.Hirex.entity.Resume;
import com.ptit.Hirex.exceptions.EntityNotFoundException;
import com.ptit.Hirex.repository.EmployeeRepository;
import com.ptit.Hirex.repository.ResumeRepository;
import com.ptit.Hirex.service.ResumeService;

@Service
public class ResumeServiceImpl implements ResumeService {

	@Autowired
	private ResumeRepository resumeRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Resume uploadResume(String fileName, String base64Data, Long employerId) {

		Employee employee = employeeRepository.findById(employerId)
				.orElseThrow(() -> new RuntimeException("Employee not found for id: "));

		Resume resume = new Resume();
		resume.setNameFile(fileName);
		resume.setFileBase64(base64Data);
		resume.setEmployee(employee);

		return resumeRepository.save(resume);
	}

	@Override
    public Optional<Resume> getResumeById(long id) {
        return resumeRepository.findById(id);
    }

    @Override
    public Resume validateAndGetResumeById(long id) {
        return getResumeById(id)
                .orElseThrow(() -> new EntityNotFoundException("vcl"));
    }
}
