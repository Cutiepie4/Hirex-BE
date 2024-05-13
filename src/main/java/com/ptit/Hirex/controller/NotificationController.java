package com.ptit.Hirex.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import com.ptit.Hirex.dtos.*;
import com.ptit.Hirex.entity.*;
import com.ptit.Hirex.service.*;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("${api.prefix}/notifications")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class NotificationController {
    private final NotificationService notificationService;
    private final ModelMapper modelMapper;

    @GetMapping("")
    ResponseEntity<?> getNotifications(@AuthenticationPrincipal User currentUser) {
        try {
            List<NotificationReceiver> notifications = notificationService.getMyNotifications(currentUser.getId());
            List<NotificationReceiverDTO> notificationDTOs = notifications.stream()
                    .map(notification -> modelMapper.map(notification.getNotification(), NotificationReceiverDTO.class))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(notificationDTOs);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Lỗi server");
        }
    }

    @PostMapping("{id}/read")
    ResponseEntity<?> markRead(@PathVariable String id) {
        try {
            NotificationReceiver notification = notificationService.markRead(Long.valueOf(id));
            NotificationReceiverDTO notificationDTO = modelMapper.map(notification, NotificationReceiverDTO.class);
            return ResponseEntity.ok(notificationDTO);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Lỗi server");
        }
    }

    @PostMapping("{id}/readall")
    ResponseEntity<?> markReadAll(@AuthenticationPrincipal User currentUser) {
        try {
            List<NotificationReceiver> notification = notificationService.markReadAll(Long.valueOf(currentUser.getId()));
            
            return ResponseEntity.ok("Thành công");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Lỗi server");
        }
    }

}
