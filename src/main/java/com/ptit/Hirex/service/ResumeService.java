package com.ptit.Hirex.service;

import com.ptit.Hirex.entity.Resume;

public interface ResumeService {
    Resume uploadResume(String fileName, String base64Data, long fileSize, Long employerId);
}
