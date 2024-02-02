package com.ptit.Hirex.service;


import com.ptit.Hirex.entity.Message;
import org.springframework.stereotype.Service;

@Service
public interface MessageService {
    void save(Message message);
}
