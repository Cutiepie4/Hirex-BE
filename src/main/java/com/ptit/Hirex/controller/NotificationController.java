package com.ptit.Hirex.controller;

import java.util.Arrays;
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

    public NotificationReceiverDTO toNotificationReceiverDTO(NotificationReceiver notificationReceiver) {
        if (notificationReceiver == null) {
            return null;
        }

        NotificationReceiverDTO dto = new NotificationReceiverDTO();
        dto.setId(notificationReceiver.getId());
        dto.setRead(notificationReceiver.isRead());

        Notification notification = notificationReceiver.getNotification();
        if (notification != null) {
            dto.setNotificationTitle(notification.getTitle());
            dto.setNotificationContent(notification.getContent());
            dto.setNotificationCompanyDetail(notification.getCompanyDetail());
            dto.setNotificationJobDetail(notification.getJobDetail());
        }
        dto.setCreatedAt(notificationReceiver.getNotification().getCreatedAt());
        return dto;
    }

    @GetMapping("")
    ResponseEntity<?> getNotifications(@AuthenticationPrincipal User currentUser) {
        try {
            List<NotificationReceiver> notifications = notificationService.getMyNotifications(currentUser.getId());
            List<NotificationReceiverDTO> notificationDTOs = notifications.stream()
                    .map(this::toNotificationReceiverDTO)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(notificationDTOs);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Lỗi server");
        }
    }

    @GetMapping("/read/{id}")
    ResponseEntity<?> markRead(@PathVariable String id) {
        try {
            NotificationReceiver notification = notificationService.markRead(Long.valueOf(id));
            NotificationReceiverDTO notificationDTO = modelMapper.map(notification, NotificationReceiverDTO.class);
            return ResponseEntity.ok(notificationDTO);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Lỗi server");
        }
    }

    @GetMapping("/read-all")
    ResponseEntity<?> markReadAll(@AuthenticationPrincipal User currentUser) {
        try {
            List<NotificationReceiver> notification = notificationService
                    .markReadAll(Long.valueOf(currentUser.getId()));
            return ResponseEntity.ok(notification);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("loi roi");
        }
    }

}
