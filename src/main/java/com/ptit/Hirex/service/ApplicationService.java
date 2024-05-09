package com.ptit.Hirex.service;

import java.util.Optional;

import com.ptit.Hirex.entity.Application;


public interface ApplicationService {

	Optional<Application> getApplicationById(long id);
	
	Application validateAndGetApplicationById(long id);
}
