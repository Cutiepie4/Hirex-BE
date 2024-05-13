package com.ptit.Hirex.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
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
      Notification notification = Notification
          .builder()
          .setTitle(pnsRequest.getTitle())
          .setBody(pnsRequest.getContent())
          .build();
      List<String> tokenList = user.getDeviceTokens()
                                  .stream()
                                  .map(DeviceToken::getDeviceToken)
                                  .collect(Collectors.toList());
      Map<String, String> data = new HashMap<>();
      switch (pnsRequest.getType()) {
        case VIDEO_CALL:
          data.put("notificationType", "videoCall");
          FirebaseMessaging
              .getInstance()
              .sendMulticast(
                  MulticastMessage.builder()
                      .setNotification(notification)
                      .addAllTokens(tokenList)
                      .putAllData(data)
                      .build());
          break;
        case SCHEDULE_NOTIFICATION:
          FirebaseMessaging.getInstance()
              .sendMulticast(MulticastMessage.builder()
                  .setNotification(notification)
                  .addAllTokens(tokenList)
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
  // @Scheduled(fixedDelay = 60000)
  // public void checkAndSendNotifications() {
  // LocalDateTime now = LocalDateTime.now();
  // List<Item> itemsToNotify = itemRepository.findItemsToNotify(now);
  // for (Item item : itemsToNotify) {
  // // Gửi thông báo cho mỗi item thõa mãn điều kiện
  // notificationService.sendNotification(item.getUserToken(), "Thông báo", "Sự
  // kiện của bạn sắp diễn ra!");
  // // Cập nhật trạng thái của item nếu cần
  // }
  // }
}
