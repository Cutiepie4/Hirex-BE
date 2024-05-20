package com.ptit.Hirex.service;

import java.util.*;

import com.ptit.Hirex.entity.Work;


public interface WorkService {

	List<Work> getWorks(String companyId);

	Optional<Work> getWorkById(int id);
	
	Work validateAndGetWorkById(int id);
}
