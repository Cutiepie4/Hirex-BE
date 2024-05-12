package com.ptit.Hirex.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ptit.Hirex.entity.Work;
import com.ptit.Hirex.exceptions.EntityNotFoundException;
import com.ptit.Hirex.repository.WorkRepository;
import com.ptit.Hirex.service.WorkService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class WorkServiceImpl implements WorkService {

    private final WorkRepository workRepository;

    @Override
    public Optional<Work> getWorkById(int id) {
        return workRepository.findById(id);
    }

    @Override
    public Work validateAndGetWorkById(int id) {
        return getWorkById(id)
                .orElseThrow(() -> new EntityNotFoundException("khong tim thay"));
    }

}
