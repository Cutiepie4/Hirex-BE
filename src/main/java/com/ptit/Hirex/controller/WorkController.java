package com.ptit.Hirex.controller;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ptit.Hirex.dtos.WorkDTO;
import com.ptit.Hirex.entity.Company;
import com.ptit.Hirex.entity.Work;
import com.ptit.Hirex.repository.CompanyRepository;
import com.ptit.Hirex.repository.EmployerRepository;
import com.ptit.Hirex.repository.SaveWorkRepository;
import com.ptit.Hirex.repository.WorkRepository;

@RestController
@RequestMapping("${api.prefix}/companies")
@CrossOrigin(origins = "*")
public class WorkController {
	
	@Autowired
	WorkRepository workRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private EmployerRepository employerRepository;
	
	@Autowired
	private SaveWorkRepository saveWorkRepository;
	
	@GetMapping("/all-work")
    public List<Work> allWork() {
        // Lấy ngày hiện tại
        LocalDate currentDate = LocalDate.now();
        
        // Lấy danh sách công việc chưa quá hạn
        List<Work> unexpiredWorks = workRepository.findByEndTimeAfter(currentDate);
        
        return unexpiredWorks;
    }
	
	@PostMapping("/creatework")
	public ResponseEntity<Work> createJob(@RequestBody WorkDTO workDTO) {
	    Work savedJob = workRepository.save(convert(workDTO));
	    
	    return ResponseEntity.status(HttpStatus.CREATED).body(savedJob);
	}

	public Work convert(WorkDTO workDTO) {
		java.util.Date utilDate = java.util.Calendar.getInstance().getTime();
		Date sqlDate = new Date(utilDate.getTime());
		System.out.println(workDTO.getCompanyId() + " " + workDTO.getEmployerId() + " " + workDTO.getEndTime());
		Date endTime = convertToSqlDate(workDTO.getEndTime());
		
	    return Work.builder()
	    		.specialize(workDTO.getSpecialize())
	            .jobPosition(workDTO.getJobPosition())
	            .wage(workDTO.getWage())
	            .typeWork(workDTO.getTypeWork())
	            .jobLocation(workDTO.getJobLocation())
	            .typeJob(workDTO.getTypeJob())
	            .description(workDTO.getDescription())
	            .company(companyRepository.findById(Long.valueOf(workDTO.getCompanyId()))
	                    .orElseThrow(() -> new IllegalArgumentException("Company not found"))) // Kiểm tra và ném ngoại lệ nếu không tìm thấy công ty
	            .startTime(sqlDate)
	            .endTime(endTime)
	            .employer(employerRepository.findById(Long.valueOf(workDTO.getEmployerId()))
                		.orElseThrow(() -> new IllegalArgumentException("Employer not found")))
	            .build();
	}
	
	public static Date convertToSqlDate(java.util.Date utilDate) {
        if (utilDate == null) {
            return null;
        }
        return new Date(utilDate.getTime());
	}
	
	
	@GetMapping("/search-work")
	public List<Work> searchWork(@RequestParam(required = false) String jobPosition,
	                             @RequestParam(required = false) String typeWork,
	                             @RequestParam(required = false) String jobLocation,
	                             @RequestParam(required = false) String typeJob,
	                             @RequestParam(required = false) String specialize,
	                             @RequestParam(required = false) Long minWage,
	                             @RequestParam(required = false) Long maxWage){
		
		System.out.println(jobPosition + "a" + typeWork + "b" + jobLocation
				+ "f" + typeJob + "e" + specialize + "d" + minWage + "c" + maxWage
		);
	    
	    if (jobPosition == null && typeWork == null && specialize == null && jobLocation == null && typeJob == null && minWage == null && maxWage == null) {
	        return workRepository.findAll();
	    } else {
	    	return workRepository.findByJobPositionContainingAndSpecializeContainingAndTypeWorkContainingAndJobLocationContainingAndTypeJobContainingAndWageBetween(
	                jobPosition, specialize, typeWork, jobLocation, typeJob, minWage, maxWage);
	    }
	}

	@GetMapping("/type-specialize")
	public List<String> typeWork(){
		return workRepository.findBySpecializeDistinct();
	}
	
	@GetMapping("/quantity-specialize")
	public int quantity(@RequestParam(required = false) String specialize){
		return workRepository.countBySpecialize(specialize);
	}
	
	@GetMapping("/top3saved")
	public List<Work> top3saved(){
		List<Integer> workId = saveWorkRepository.findTop3MostFrequentWorkIds();
		System.out.println(workId);
		
		List<Work> works = new ArrayList<Work>();
		for(Integer x : workId) {
			Work ans = workRepository.findById(x).orElse(null);
			works.add(ans);
		}
		return works;
	}
}
