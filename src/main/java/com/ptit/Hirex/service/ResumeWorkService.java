package com.ptit.Hirex.service;

import java.util.*;

import com.ptit.Hirex.dtos.*;
import com.ptit.Hirex.entity.ResumeWork;


public interface ResumeWorkService {

	boolean hasDuplicateResume(ResumeWork resumeWork); 

	ResumeWork applyWork(ResumeWorkRequest resumeWorkRequest);

	ResumeWork decideStatus(ResumeWorkStatusRequest resumeWorkRequest);

	Optional<ResumeWork> getResumeWorkById(Long id);
	
	ResumeWork validateAndGetResumeWorkById(Long id);
	
	List<ResumeWork> getResumeWorksByWorkId(int workId);


}
