package com.ptit.Hirex.service;

import org.springframework.stereotype.Service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.MulticastMessage;
import com.google.firebase.messaging.Notification;
import com.ptit.Hirex.request.PnsRequest;

@Service
public class FCMService {

    public void pushNotification(PnsRequest pnsRequest) {
        try {
            FirebaseMessaging.getInstance()
                    .sendMulticast(
                            MulticastMessage.builder()
                                    .setNotification(Notification.builder()
                                            .setBody(pnsRequest.getContent())
                                            .setTitle("Test FCM")
                                            .build())
                                    .addToken(pnsRequest.getFcmToken())
                                    .build());
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
        }
    }
}
