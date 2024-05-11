package com.ptit.Hirex.service;

import com.ptit.Hirex.dtos.SkillDTO;
import com.ptit.Hirex.entity.Skill;

public interface SkillService {
	   
    Skill addSkill(SkillDTO skillDTO);
    
    Skill updateSkill(Long id, SkillDTO skillDTO);
    
    void deleteSkill(Long id);
}
