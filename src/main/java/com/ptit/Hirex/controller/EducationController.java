package com.ptit.Hirex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ptit.Hirex.dtos.EducationDTO;
import com.ptit.Hirex.service.impl.EducationServiceImpl;

@RestController
@RequestMapping("${api.prefix}/educations")
@CrossOrigin(origins = "*")
public class EducationController {
	
	@Autowired
    private EducationServiceImpl educationServiceImpl;


    @PostMapping("/create")
    public ResponseEntity<String> saveEducation(@RequestBody EducationDTO educationDTO) {
//    	System.out.print(educationDTO);
    	educationServiceImpl.saveEducation(educationDTO);
        return new ResponseEntity<>("Education saved successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEducation(@PathVariable Long id, @RequestBody EducationDTO educationDTO) {
    	System.out.print(educationDTO);

    	
    	educationServiceImpl.updateEducation (id, educationDTO);
        return new ResponseEntity<>("Experience updated successfully", HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExperience(@PathVariable Long id) {
    	educationServiceImpl.deleteEducation(id);
        return new ResponseEntity<>("Experience deleted successfully", HttpStatus.OK);
    }
}
