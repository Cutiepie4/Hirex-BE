package com.ptit.Hirex.service.impl;


import org.springframework.stereotype.Service;

import com.ptit.Hirex.dtos.ResumeWorkRequest;
import com.ptit.Hirex.entity.*;
import com.ptit.Hirex.exceptions.DuplicatedEntityException;
import com.ptit.Hirex.repository.ResumeWorkRepository;
import com.ptit.Hirex.service.ResumeWorkService;
import com.ptit.Hirex.service.ResumeService;
import com.ptit.Hirex.service.WorkService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ResumeWorkServiceImpl implements ResumeWorkService {

    private final ResumeWorkRepository resumeWorkRepository;
    private final WorkService workService;
    private final ResumeService resumeService;

    @Override
    public boolean hasDuplicateResume(ResumeWork resumeWork) {
        return false;
        // return resumeWorkRepository.existsByUserAndWorkAndStatus(resume.getUser(), resume.getWork(), "new")
        //     || resumeWorkRepository.existsByUserAndWorkAndStatus(resume.getUser(), resume.getWork(), "applied");
    }

    @Override
    public ResumeWork applyWork(ResumeWorkRequest resumeWorkRequest) {
        Resume resume = resumeService.validateAndGetResumeById(resumeWorkRequest.getResumeId());
        Work work = workService.validateAndGetWorkById(resumeWorkRequest.getWorkId());
        ResumeWork resumeWork = new ResumeWork(resume, work, resumeWorkRequest.getInformation());
        if (hasDuplicateResume(resumeWork)) {
            throw new DuplicatedEntityException("trùng cmm rồi");
        }
        return resumeWorkRepository.save(resumeWork);
    }

}
