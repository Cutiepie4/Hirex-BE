package com.ptit.Hirex.service.impl;


import org.springframework.stereotype.Service;

import com.ptit.Hirex.dtos.ApplicationWorkRequest;
import com.ptit.Hirex.entity.*;
import com.ptit.Hirex.exceptions.DuplicatedEntityException;
import com.ptit.Hirex.repository.ApplicationWorkRepository;
import com.ptit.Hirex.service.ApplicationWorkService;
import com.ptit.Hirex.service.ApplicationService;
import com.ptit.Hirex.service.WorkService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ApplicationWorkServiceImpl implements ApplicationWorkService {

    private final ApplicationWorkRepository applicationWorkRepository;
    private final WorkService workService;
    private final ApplicationService applicationService;

    @Override
    public boolean hasDuplicateApplication(ApplicationWork applicationWork) {
        return false;
        // return applicationWorkRepository.existsByUserAndWorkAndStatus(application.getUser(), application.getWork(), "new")
        //     || applicationWorkRepository.existsByUserAndWorkAndStatus(application.getUser(), application.getWork(), "applied");
    }

    @Override
    public ApplicationWork applyWork(ApplicationWorkRequest applicationWorkRequest) {
        Application application = applicationService.validateAndGetApplicationById(applicationWorkRequest.getApplicationId());
        Work work = workService.validateAndGetWorkById(applicationWorkRequest.getWorkId());
        ApplicationWork applicationWork = new ApplicationWork(application, work, applicationWorkRequest.getInformation());
        if (hasDuplicateApplication(applicationWork)) {
            throw new DuplicatedEntityException("trùng cmm rồi");
        }
        return applicationWorkRepository.save(applicationWork);
    }

}
