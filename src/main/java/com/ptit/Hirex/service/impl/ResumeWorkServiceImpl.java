package com.ptit.Hirex.service.impl;


import java.util.*;

import org.springframework.stereotype.Service;

import com.ptit.Hirex.dtos.*;
import com.ptit.Hirex.entity.*;
import com.ptit.Hirex.exceptions.*;
import com.ptit.Hirex.repository.*;
import com.ptit.Hirex.service.*;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ResumeWorkServiceImpl implements ResumeWorkService {

    private final ResumeWorkRepository resumeWorkRepository;
    private final WorkRepository workRepository;
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

    @Override
    public ResumeWork decideStatus(ResumeWorkStatusRequest resumeWorkRequest) {
        ResumeWork resumeWork = validateAndGetResumeWorkById(resumeWorkRequest.getId());
        if (resumeWork.getStatus().equals(ResumeStatus.PENDING)) {
            resumeWork.setStatus(resumeWorkRequest.getStatus());
            ResumeWork result = resumeWorkRepository.save(resumeWork);
            if (result.getStatus().equals(ResumeStatus.ACCEPTED)) {
                Work work = resumeWork.getWork();
                work.getEmployees().add(resumeWork.getResume().getEmployee());
                workRepository.save(work);
            } else if (result.getStatus().equals(ResumeStatus.REJECTED)) {
                // NOTHING TO DO
            } else {
                // HANDLE ERROR
            }
        }
        return null;
    }

    @Override
    public Optional<ResumeWork> getResumeWorkById(Long id) {
        return resumeWorkRepository.findById(id);
    }

    @Override
    public ResumeWork validateAndGetResumeWorkById(Long id) {
        return getResumeWorkById(id)
                .orElseThrow(() -> new EntityNotFoundException("khong tim thay"));
    }

    @Override
    public List<ResumeWork> getResumeWorksByWorkId(int workId) {
        return resumeWorkRepository.findAllByWorkIdOrderByCreatedAtDesc(workId);
    }

}
