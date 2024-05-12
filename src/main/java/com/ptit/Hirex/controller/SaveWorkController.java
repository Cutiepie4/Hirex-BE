package com.ptit.Hirex.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ptit.Hirex.entity.SaveWork;
import com.ptit.Hirex.entity.User;
import com.ptit.Hirex.entity.Work;
import com.ptit.Hirex.repository.SaveWorkRepository;
import com.ptit.Hirex.repository.UserRepository;
import com.ptit.Hirex.repository.WorkRepository;
import com.ptit.Hirex.service.SaveWorkService;


@RestController
@RequestMapping("${api.prefix}")
@CrossOrigin(origins = "*")
public class SaveWorkController {
	@Autowired
	private SaveWorkRepository saveWorkRepository;

	@Autowired
	private SaveWorkService saveWorkService;

	@Autowired
	private WorkRepository workRepository;
	
	@Autowired
	private UserRepository userRepository;

	@PostMapping("/favorite/{userId}/{workId}")
	public String toggleSave(@PathVariable String userId, @PathVariable String workId) {
		User user = userRepository.findById(Long.valueOf(userId)).orElse(null);
		if (user == null) {
			return "Người dùng không tồn tại.";
		}

		Work work = workRepository.findById(Integer.valueOf(workId)).orElse(null);
		if (work == null) {
			return "Công việc không tồn tại.";
		}

		SaveWork existingSave = saveWorkRepository.findByUserAndWork(user, work);
		if (existingSave != null) {
			saveWorkService.removeFavorite(user, work);
			return "Công việc đã được huỷ bỏ.";
		} else {
			saveWorkService.addFavorite(user, work);
			return "Công việc đã được lưu vào.";
		}
	}
	
	@GetMapping("/save-works/{userId}")
	public List<Work> getFavoriteWorkByUserId(@PathVariable Long userId) {
	    
	    User user = userRepository.findById(userId).orElse(null);

	    if (user == null) {
	        return Collections.emptyList(); 
	    }

	    List<SaveWork> saveWorks = saveWorkRepository.findByUser(user);
	    
	    List<Work> works = new ArrayList<>();
	    for (SaveWork saveWork : saveWorks) {
	        works.add(saveWork.getWork());
	    }
	    
	    return works;
	}
	
	@GetMapping("/is-save/{userId}/{workId}")
	public boolean isFavoriteStore(@PathVariable Long userId, @PathVariable Integer workId) {
	    User user = userRepository.findById(userId).orElse(null);
	    Work work = workRepository.findById(workId).orElse(null);

	    if (user == null || work == null) {
	        return false;
	    }

	    SaveWork existingSave = saveWorkRepository.findByUserAndWork(user, work);
	    
	    return existingSave != null;
	}
}

