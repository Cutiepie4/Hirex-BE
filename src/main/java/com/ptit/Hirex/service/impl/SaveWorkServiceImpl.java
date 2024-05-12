package com.ptit.Hirex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.Hirex.entity.SaveWork;
import com.ptit.Hirex.entity.User;
import com.ptit.Hirex.entity.Work;
import com.ptit.Hirex.repository.SaveWorkRepository;
import com.ptit.Hirex.service.SaveWorkService;


@Service
public class SaveWorkServiceImpl implements SaveWorkService{

	@Autowired
    private SaveWorkRepository saveWorkRepository;

    @Override
    public void addFavorite(User user, Work work) {
        SaveWork saveWork = new SaveWork();
        saveWork.setUser(user);
        saveWork.setWork(work);
        saveWorkRepository.save(saveWork);
    }

    @Override
    public void removeFavorite(User user, Work work) {
    	SaveWork saveWork = saveWorkRepository.findByUserAndWork(user, work);
        if (saveWork != null) {
        	saveWorkRepository.delete(saveWork);
        }
    }
}
