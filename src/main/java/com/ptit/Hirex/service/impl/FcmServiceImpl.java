package com.ptit.Hirex.service.impl;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.MulticastMessage;
import com.google.firebase.messaging.Notification;
import com.ptit.Hirex.entity.DeviceToken;
import com.ptit.Hirex.entity.User;
import com.ptit.Hirex.repository.UserRepository;
import com.ptit.Hirex.request.DeviceTokenRequest;
import com.ptit.Hirex.request.PnsRequest;
import com.ptit.Hirex.service.FCMService;
import com.ptit.Hirex.service.UserService;

@Service
public class FcmServiceImpl implements FCMService {
  @Autowired
  UserService userService;

  @Autowired
  UserRepository userRepository;

  public void pushNotification(PnsRequest pnsRequest) throws FirebaseMessagingException {
    User user = userService.findByPhoneNumber(pnsRequest.getPhoneNumber());
    if (user != null) {
      switch (pnsRequest.getType()) {
        case VIDEO_CALL:
          FirebaseMessaging
              .getInstance()
              .sendMulticast(
                  MulticastMessage.builder()
                      .setNotification(
                          Notification.builder()
                              .setBody(pnsRequest
                                  .getContent())
                              .setTitle(pnsRequest
                                  .getTitle())
                              .build())
                      .addAllTokens(
                          user.getDeviceTokens()
                              .stream()
                              .map(DeviceToken::getDeviceToken)
                              .collect(Collectors
                                  .toList()))
                      .build());
          break;

        default:
          break;
      }
    }
  }

  public boolean saveDeviceToken(DeviceTokenRequest deviceTokenRequest) {
    User user = userService.findByPhoneNumber(deviceTokenRequest.getPhoneNumber());
    if (user == null || deviceTokenRequest.getDeviceToken().isEmpty())
      return false;

    boolean deviceTokenExists = user.getDeviceTokens().stream()
        .anyMatch(deviceToken -> deviceToken.getDeviceToken()
            .equals(deviceTokenRequest.getDeviceToken()));
    if (!deviceTokenExists) {
      DeviceToken newDeviceToken = new DeviceToken();
      newDeviceToken.setDeviceToken(deviceTokenRequest.getDeviceToken());
      newDeviceToken.setUser(user);
      user.getDeviceTokens().add(newDeviceToken);
      userRepository.save(user);
    }
    return true;
  }
}
