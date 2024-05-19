package com.ptit.Hirex.controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ptit.Hirex.dtos.Company0DTO;
import com.ptit.Hirex.dtos.CompanyDTO;
import com.ptit.Hirex.entity.Company;
import com.ptit.Hirex.service.CompanyService;

@RestController
@RequestMapping("${api.prefix}/companies")
@CrossOrigin(origins = "*")
public class CompanyController {

    @Autowired
    private CompanyService companyService;
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getCompany(@PathVariable Long id) {
        try {
            Company0DTO companyDTO = companyService.getCompanyById(id);
            if (companyDTO != null) {
                return new ResponseEntity<>(companyDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Company not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error fetching company", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createCompany(@ModelAttribute Company0DTO companyDTO, @RequestPart(value = "image", required = false) MultipartFile image) throws Exception {
     
    	System.out.print(companyDTO.getEmployeeSize());
    	if (image != null && !image.isEmpty()) {
            byte[] imageBytes = image.getBytes();
            String imageBase64 = Base64.getEncoder().encodeToString(imageBytes);
            companyDTO.setImageBase64(imageBase64);
        };
        companyService.saveCompany(companyDTO);
        return new ResponseEntity<>("Company saved successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long id, @ModelAttribute Company0DTO companyDTO, @RequestPart(value = "image", required = false) MultipartFile image) throws Exception {
        if (image != null && !image.isEmpty()) {
            byte[] imageBytes = image.getBytes();
            String imageBase64 = Base64.getEncoder().encodeToString(imageBytes);
            companyDTO.setImageBase64(imageBase64);
        }
        return  ResponseEntity.ok(companyService.updateCompany(id, companyDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
        return ResponseEntity.ok().build();
    }
}