package com.ptit.Hirex.service;

import com.ptit.Hirex.dtos.ResumeWorkRequest;
import com.ptit.Hirex.entity.ResumeWork;


public interface ResumeWorkService {

	boolean hasDuplicateResume(ResumeWork resumeWork); 

	ResumeWork applyWork(ResumeWorkRequest resumeWorkRequest);
}
