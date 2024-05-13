package com.ptit.Hirex.service;

import java.util.List;
import java.util.Optional;

import com.ptit.Hirex.dtos.NotificationRequest;
import com.ptit.Hirex.entity.Notification;
import com.ptit.Hirex.entity.NotificationReceiver;

public interface NotificationService {

    Notification createNotification(Notification notification);

    Notification saveNotification(NotificationRequest notificationReq);

    List<NotificationReceiver> getMyNotifications(Long userId);

    Optional<NotificationReceiver> getNotificationReceiverById(Long id);
    NotificationReceiver validateAndGetNotificationReceiverById(Long id);

    NotificationReceiver markRead(Long id);

}
