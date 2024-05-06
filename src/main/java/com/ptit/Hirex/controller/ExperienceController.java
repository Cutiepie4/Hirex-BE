package com.ptit.Hirex.controller;

import com.ptit.Hirex.dtos.ExperienceDTO;
import com.ptit.Hirex.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}/experiences")
@CrossOrigin(origins = "*")
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;

    @PostMapping("/create")
    public ResponseEntity<String> saveExperience(@RequestBody ExperienceDTO experienceDTO) {
        experienceService.saveExperience(experienceDTO);
        return new ResponseEntity<>("Experience saved successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateExperience(@PathVariable Long id, @RequestBody ExperienceDTO experienceDTO) {

        experienceService.updateExperience(id, experienceDTO);
        return new ResponseEntity<>("Experience updated successfully", HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExperience(@PathVariable Long id) {
        experienceService.deleteExperience(id);
        return new ResponseEntity<>("Experience deleted successfully", HttpStatus.OK);
    }
}
