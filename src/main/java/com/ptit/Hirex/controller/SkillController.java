package com.ptit.Hirex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ptit.Hirex.dtos.SkillDTO;
import com.ptit.Hirex.service.impl.SkillServiceImpl;
import com.ptit.Hirex.entity.Skill;

@RestController
@RequestMapping("${api.prefix}/skills")
@CrossOrigin(origins = "*")
public class SkillController {
    @Autowired
    private SkillServiceImpl skillServiceImpl;

    @PostMapping("/create")
    public ResponseEntity<?> addSkill(@RequestBody SkillDTO skillDTO) {
        Skill skill = skillServiceImpl.addSkill(skillDTO);
        return ResponseEntity.ok(skill);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSkill(@PathVariable Long id, @RequestBody SkillDTO skillDTO) {
        Skill skill = skillServiceImpl.updateSkill(id, skillDTO);
        return ResponseEntity.ok(skill);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSkill(@PathVariable Long id) {
        skillServiceImpl.deleteSkill(id);
        return ResponseEntity.ok().build();
    }
}
