package com.ptit.Hirex.service;

import com.ptit.Hirex.dtos.ExperienceDTO;

public interface ExperienceService {
	
    void saveExperience(ExperienceDTO experienceDTO);
    
    void updateExperience(Long experienceId, ExperienceDTO experienceDTO);
    
    void deleteExperience(Long experienceId);
    
}
