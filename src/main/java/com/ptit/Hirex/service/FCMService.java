package com.ptit.Hirex.service;

import org.springframework.stereotype.Service;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.ptit.Hirex.request.DeviceTokenRequest;
import com.ptit.Hirex.request.PnsRequest;

@Service
public interface FCMService {

    void pushNotification(PnsRequest pnsRequest) throws FirebaseMessagingException;

    boolean saveDeviceToken(DeviceTokenRequest deviceTokenRequest);
}