package com.ptit.Hirex.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.Hirex.entity.Employee;
import com.ptit.Hirex.entity.Resume;
import com.ptit.Hirex.exceptions.EntityNotFoundException;
import com.ptit.Hirex.repository.EmployeeRepository;
import com.ptit.Hirex.repository.ResumeRepository;
import com.ptit.Hirex.service.ResumeService;

import ch.qos.logback.core.util.FileSize;

@Service
public class ResumeServiceImpl implements ResumeService {

	@Autowired
	private ResumeRepository resumeRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Resume uploadResume(String fileName, String base64Data, long FileSize, Long employerId) {

		Employee employee = employeeRepository.findById(employerId)
				.orElseThrow(() -> new RuntimeException("Employee not found for id: "));

		Resume resume = new Resume();
		resume.setNameFile(fileName);
		resume.setFileBase64(base64Data);
		resume.setSize(FileSize);
		resume.setEmployee(employee);

		return resumeRepository.save(resume);
	}

	@Override
	public List<Resume> getMyResumes(Long employeeId) {
		List<Resume> listResumes = resumeRepository.findAllByEmployeeId(employeeId);
		return listResumes;
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
	
	public boolean deleteResume(Long resumeId) {
	    Optional<Resume> resume = resumeRepository.findById(resumeId);
	    if (resume.isPresent()) {
	        resumeRepository.delete(resume.get());
	        return true;
	    } else {
	        return false;
	    }
	}

}
