package com.ptit.Hirex.controller;

import java.util.Base64;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ptit.Hirex.dtos.CompanyDTO;
import com.ptit.Hirex.entity.Company;
import com.ptit.Hirex.repository.CompanyRepository;
import com.ptit.Hirex.service.CompanyService;

@RestController
@RequestMapping("${api.prefix}/companies")
@CrossOrigin(origins = "*")
public class CompanyController {
	
	@Autowired
	private CompanyRepository companyRepository;

    @Autowired
    private CompanyService companyService;

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createCompany(@ModelAttribute CompanyDTO companyDTO, @RequestPart(value = "image", required = false) MultipartFile image) throws Exception {
        if (image != null && !image.isEmpty()) {
            byte[] imageBytes = image.getBytes();
            String imageBase64 = Base64.getEncoder().encodeToString(imageBytes);
            companyDTO.setImageBase64(imageBase64);
        };
        companyService.saveCompany(companyDTO);
        return new ResponseEntity<>("Company saved successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody CompanyDTO companyDTO) throws Exception {
    	MultipartFile image = companyDTO.getFile();
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
    
    @GetMapping("/all-company")
    public List<Company> allCompany(){
    	try {
    		return companyRepository.findAll();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
}
