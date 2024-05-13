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
    private final ModelMapper modelMapper;

    @Override
    public Appreciation saveAppreciation(AppreciationRequest appreciationRequest) {
        Appreciation appreciation = modelMapper.map(appreciationRequest, Appreciation.class);
        return appreciationRepository.save(appreciation);
    }

    @Override
	public Appreciation getAppreciationByEmployeeAndWork(Employee employee, Work work) {
        return appreciationRepository.findOneByEmployeeAndWork(employee, work);
    }

}
