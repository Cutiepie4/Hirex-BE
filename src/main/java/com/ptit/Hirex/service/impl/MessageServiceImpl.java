package com.ptit.Hirex.service.impl;

import com.ptit.Hirex.entity.Message;
import com.ptit.Hirex.service.MessageService;
import com.ptit.Hirex.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageRepository messageRepository;

    @Override
    public void save(Message message) {
        messageRepository.save(message);
    }
}
