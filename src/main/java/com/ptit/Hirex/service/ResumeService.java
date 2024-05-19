package com.ptit.Hirex.service;

import java.util.*;

import com.ptit.Hirex.entity.Resume;

public interface ResumeService {
    Resume uploadResume(String fileName, String base64Data, long fileSize, Long employerId);

    List<Resume> getMyResumes(Long employeeId);

    Optional<Resume> getResumeById(long id);
	
	Resume validateAndGetResumeById(long id);

}
