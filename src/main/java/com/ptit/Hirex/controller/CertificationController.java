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

import com.ptit.Hirex.dtos.CertificationDTO;
import com.ptit.Hirex.service.impl.CertificationServiceIpml;

@RestController
@RequestMapping("${api.prefix}/certifications")
@CrossOrigin(origins = "*")
public class CertificationController {
	@Autowired
    private CertificationServiceIpml certificationServiceIpml;


    @PostMapping("/create")
    public ResponseEntity<String> saveEducation(@RequestBody CertificationDTO certificationDTO) {
    	certificationServiceIpml.saveCertification(certificationDTO);
        return new ResponseEntity<>("Certification saved successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEducation(@PathVariable Long id, @RequestBody CertificationDTO certificationDTO) {

    	certificationServiceIpml.updateCertification(id, certificationDTO);
        return new ResponseEntity<>("Certification updated successfully", HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExperience(@PathVariable Long id) {
    	certificationServiceIpml.deleteCertification(id);
        return new ResponseEntity<>("Certification deleted successfully", HttpStatus.OK);
    }
}
