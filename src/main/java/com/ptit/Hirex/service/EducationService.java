package com.ptit.Hirex.service;

import com.ptit.Hirex.dtos.EducationDTO;

public interface EducationService {
	
    void saveEducation(EducationDTO educationDTO);
    
    void updateEducation(Long educationId, EducationDTO educationDTO);
    
    void deleteEducation(Long educationId);
    
}
