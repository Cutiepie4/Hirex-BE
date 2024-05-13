package com.ptit.Hirex.service;

import java.util.List;
import java.util.Optional;

import com.ptit.Hirex.dtos.NotificationRequest;
import com.ptit.Hirex.entity.Notification;
import com.ptit.Hirex.entity.NotificationReceiver;

public interface NotificationReceiverService {


    List<NotificationReceiver> saveNotifications(NotificationRequest notificationReq);

}
