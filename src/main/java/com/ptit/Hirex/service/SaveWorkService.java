package com.ptit.Hirex.service;

import org.springframework.stereotype.Service;

import com.ptit.Hirex.entity.User;
import com.ptit.Hirex.entity.Work;

@Service
public interface SaveWorkService {
    void addFavorite(User user, Work work);
    void removeFavorite(User user, Work work);
}