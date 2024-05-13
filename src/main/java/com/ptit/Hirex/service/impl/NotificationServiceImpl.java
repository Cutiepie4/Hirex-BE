package com.ptit.Hirex.service.impl;

import java.util.*;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.Hirex.dtos.NotificationRequest;
import com.ptit.Hirex.entity.*;
import com.ptit.Hirex.exceptions.EntityNotFoundException;
import com.ptit.Hirex.repository.NotificationReceiverRepository;
import com.ptit.Hirex.repository.NotificationRepository;
import com.ptit.Hirex.service.NotificationService;
import com.ptit.Hirex.service.UserService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;
    private final NotificationReceiverRepository notificationReceiverRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Override
    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public Notification saveNotification(NotificationRequest notificationReq) {
        Notification notification = modelMapper.map(notificationReq, Notification.class);
        return notificationRepository.save(notification);
    }

    @Override
    public List<NotificationReceiver> getMyNotifications(Long userId) {
        return notificationReceiverRepository.findAllByReceiverId(userId);
    }

    @Override
    public Optional<NotificationReceiver> getNotificationReceiverById(Long id) {
        return notificationReceiverRepository.findById(id);
    }

    @Override
    public NotificationReceiver validateAndGetNotificationReceiverById(Long id) {
        return getNotificationReceiverById(id)
                .orElseThrow(() -> new EntityNotFoundException("khong tim thay"));
    }

    @Override
    public NotificationReceiver markRead(Long id) {
        NotificationReceiver notificationReceiver = validateAndGetNotificationReceiverById(id);
        notificationReceiver.setRead(true);
        return notificationReceiverRepository.save(notificationReceiver);
    }

    @Override
    public List<NotificationReceiver> markReadAll(Long userId) {
        List<NotificationReceiver> notificationReceivers = getMyNotifications(userId);
        for (NotificationReceiver notificationReceiver : notificationReceivers)
            notificationReceiver.setRead(true);
        return notificationReceiverRepository.saveAll(notificationReceivers);
    }

}
