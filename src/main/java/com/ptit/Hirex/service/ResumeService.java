package com.ptit.Hirex.service;

import java.util.Optional;

import com.ptit.Hirex.entity.Resume;

public interface ResumeService {
    Resume uploadResume(String fileName, String base64Data, Long employerId);

    Optional<Resume> getResumeById(long id);
	
	Resume validateAndGetResumeById(long id);

}
