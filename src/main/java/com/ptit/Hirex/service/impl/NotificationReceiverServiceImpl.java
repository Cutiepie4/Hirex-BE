package com.ptit.Hirex.service.impl;

import java.util.*;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ptit.Hirex.dtos.NotificationRequest;
import com.ptit.Hirex.entity.*;
import com.ptit.Hirex.exceptions.EntityNotFoundException;
import com.ptit.Hirex.repository.NotificationReceiverRepository;
import com.ptit.Hirex.repository.NotificationRepository;
import com.ptit.Hirex.service.NotificationReceiverService;
import com.ptit.Hirex.service.NotificationService;
import com.ptit.Hirex.service.UserService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NotificationReceiverServiceImpl implements NotificationReceiverService {
    private final NotificationReceiverRepository notificationReceiverRepository;
    private final NotificationService notificationService;
    private final UserService userService;

    @Override
    public List<NotificationReceiver> saveNotifications(NotificationRequest notificationReq) {
        Notification notification = notificationService.saveNotification(notificationReq);
        List<NotificationReceiver> notificationReceivers = new ArrayList<NotificationReceiver>();
        System.out.println(notificationReq.getReceiverPhoneNumbers());
        for (int i = 0; i < notificationReq.getReceiverPhoneNumbers().size(); i++) {
            System.out.println(i);
            notificationReceivers.add(new NotificationReceiver(userService.findByPhoneNumber(notificationReq.getReceiverPhoneNumbers().get(i)), notification));
        }
        return notificationReceiverRepository.saveAll(notificationReceivers);
    }

}
