package com.ptit.Hirex.service;

import java.util.List;

import com.ptit.Hirex.entity.Notification;
import com.ptit.Hirex.entity.NotificationReceiver;

public interface NotificationService {

    Notification createNotification(Notification notification);

    List<NotificationReceiver> getMyNotifications(Long userId);

}
