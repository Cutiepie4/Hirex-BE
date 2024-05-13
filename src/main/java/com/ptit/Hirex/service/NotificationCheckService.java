package com.ptit.Hirex.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.MulticastMessage;
import com.google.firebase.messaging.Notification;
import com.ptit.Hirex.entity.DeviceToken;
import com.ptit.Hirex.entity.Items;
import com.ptit.Hirex.entity.User;
import com.ptit.Hirex.repository.ItemsRepository;
import com.ptit.Hirex.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class NotificationCheckService {
    private final ItemsRepository itemsRepository;
    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Scheduled(cron = "0 * * * * ?")
    public void checkNotifications() {
        LocalDateTime now = LocalDateTime.now().withSecond(0).withNano(0);
        LocalDateTime start = now;
        LocalDateTime end = now.plusMinutes(1).minusSeconds(1);
        System.out.println(start + " " + end);
        List<Items> itemsToNotify = itemsRepository.findByNotificationBetween(start, end);
        for (Items item : itemsToNotify) {
            try {
                User user = item.getSchedule().getUser();
                sendNotificationToUser(createNotificationFromItem(item), user);
            } catch (Exception e) {
                System.err.println(
                        "Failed to send notification for item: " + item.getId() + ", error: " + e.getMessage());
            }
        }
    }

    public Notification createNotificationFromItem(Items item) {
        
        return Notification.builder()
                .setTitle(item.getTitle())
                .setBody(item.getNotes())
                .build();
    }

    public void sendNotificationToUser(Notification notification, User user) {
        List<String> tokenList = user.getDeviceTokens().stream()
                .map(DeviceToken::getDeviceToken)
                .collect(Collectors.toList());
        Map<String, String> data = new HashMap<>();
        data.put("notificationType", "schedule");
        if (!tokenList.isEmpty()) {
            try {
                FirebaseMessaging.getInstance().sendMulticast(MulticastMessage.builder()
                        .setNotification(notification)
                        .addAllTokens(tokenList)
                        .putAllData(data)
                        .build());
                System.out.println("Notification sent successfully.");
            } catch (FirebaseMessagingException e) {
                System.err.println("Failed to send notification: " + e.getMessage());
            }
        }
    }
}
