package com.ptit.Hirex.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ptit.Hirex.entity.Application;
import com.ptit.Hirex.exceptions.EntityNotFoundException;
import com.ptit.Hirex.repository.ApplicationRepository;
import com.ptit.Hirex.service.ApplicationService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Override
    public Optional<Application> getApplicationById(long id) {
        return applicationRepository.findById(id);
    }

    @Override
    public Application validateAndGetApplicationById(long id) {
        return getApplicationById(id)
                .orElseThrow(() -> new EntityNotFoundException("vcl"));
    }

}
