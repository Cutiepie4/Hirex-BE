package com.ptit.Hirex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ptit.Hirex.service.NotificationService;

@RestController
public class NotificationController {
    @Autowired
    NotificationService notificationService;

    public void createNotification() {

    }
}
