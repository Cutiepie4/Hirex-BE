package com.ptit.Hirex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.ptit.Hirex.request.DeviceTokenRequest;
import com.ptit.Hirex.request.PnsRequest;
import com.ptit.Hirex.service.FCMService;

@RequestMapping("${api.prefix}")
@RestController
public class FCMController {

    @Autowired
    FCMService fcmService;

    @PostMapping("/notification")
    public ResponseEntity<String> sendNotification(@RequestBody PnsRequest pnsRequest) {
        try {
            fcmService.pushNotification(pnsRequest);
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error occured when sending nofitication.");
        }
        return ResponseEntity.ok("Nofification sent");
    }

    @PostMapping("/save-device-token")
    public ResponseEntity<String> saveDeviceToken(@RequestBody DeviceTokenRequest deviceTokenRequest) {
        boolean ok = fcmService.saveDeviceToken(deviceTokenRequest);
        if (ok) {
            return ResponseEntity.ok("Device token saved!");
        }
        return ResponseEntity.badRequest().body("Error occured when saving device token");
    }
}
