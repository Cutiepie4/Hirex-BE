package com.ptit.Hirex.service;

import java.util.Optional;

import com.ptit.Hirex.entity.Work;


public interface WorkService {

	Optional<Work> getWorkById(int id);
	
	Work validateAndGetWorkById(int id);
}
