package com.ptit.Hirex.service;

import com.ptit.Hirex.dtos.ApplicationWorkRequest;
import com.ptit.Hirex.entity.ApplicationWork;


public interface ApplicationWorkService {

	boolean hasDuplicateApplication(ApplicationWork applicationWork); 

	ApplicationWork applyWork(ApplicationWorkRequest applicationWorkRequest);
}
