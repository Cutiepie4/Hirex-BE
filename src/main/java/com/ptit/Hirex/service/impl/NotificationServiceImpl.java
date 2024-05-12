package com.ptit.Hirex.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.Hirex.entity.Notification;
import com.ptit.Hirex.entity.NotificationReceiver;
import com.ptit.Hirex.repository.NotificationReceiverRepository;
import com.ptit.Hirex.repository.NotificationRepository;
import com.ptit.Hirex.service.NotificationService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;
    private final NotificationReceiverRepository notificationReceiverRepository;

    @Override
    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public List<NotificationReceiver> getMyNotifications(Long userId) {
        return notificationReceiverRepository.findAllByReceiverId(userId);
    }

}
