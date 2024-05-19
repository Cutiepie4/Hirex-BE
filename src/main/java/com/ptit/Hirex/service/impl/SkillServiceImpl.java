package com.ptit.Hirex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.Hirex.dtos.SkillDTO;
import com.ptit.Hirex.entity.Employee;
import com.ptit.Hirex.entity.Skill;
import com.ptit.Hirex.repository.EmployeeRepository;
import com.ptit.Hirex.repository.SkillRepository;
import com.ptit.Hirex.service.SkillService;

@Service
public class SkillServiceImpl implements SkillService{
    
    @Autowired
    private SkillRepository skillRepository;
    
    @Autowired
	private EmployeeRepository employeeRepository;


    @Override
    public Skill addSkill(SkillDTO skillDTO) {
    	
        Employee employee = employeeRepository.findById(skillDTO.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found for id: " + skillDTO.getEmployeeId()));
        
        Skill skill = new Skill();
        skill.setName(skillDTO.getName());
        skill.setNote(skillDTO.getNote());
        
        skill.setEmployee(employee);
        return skillRepository.save(skill);
    }
    
    @Override
    public Skill updateSkill(Long id, SkillDTO skillDTO) {
        Skill skill = skillRepository.findById(id).orElseThrow(() -> new RuntimeException("Skill not found"));
        
        Employee employee = employeeRepository.findById(skillDTO.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found for id: " + skillDTO.getEmployeeId()));
        
        skill.setName(skillDTO.getName());
        skill.setNote(skillDTO.getNote());
        skill.setEmployee(employee);

        return skillRepository.save(skill);
    }

    @Override
    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }
}
