package com.ptit.Hirex.service.impl;


import java.util.*;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ptit.Hirex.dtos.*;
import com.ptit.Hirex.entity.*;
import com.ptit.Hirex.exceptions.*;
import com.ptit.Hirex.repository.*;
import com.ptit.Hirex.service.*;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AppreciationServiceImpl implements AppreciationService {

    private final AppreciationRepository appreciationRepository;
    private final WorkRepository workRepository;
    private final EmployeeService employeeService;
    private final ResumeService resumeService;
    private final ModelMapper modelMapper;

    @Override
    public Appreciation saveAppreciation(AppreciationRequest appreciationRequest) {
        Appreciation appreciation = modelMapper.map(appreciationRequest, Appreciation.class);
        return appreciation;
        // return appreciationRepository.save(appreciation);
    }

    @Override
    public Optional<Appreciation> getAppreciationById(Long id) {
        return appreciationRepository.findById(id);
    }

    @Override
    public Appreciation validateAndGetAppreciationById(Long id) {
        return getAppreciationById(id)
                .orElseThrow(() -> new EntityNotFoundException("khong tim thay"));
    }

}
