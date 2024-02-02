package com.ptit.Hirex.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ptit.Hirex.entity.Message;

@Controller
public class MessageController {
    @PostMapping("/send-message")
    public ResponseEntity<String> sendMessage(@RequestBody Message message) {
        if(message.getEmployer() != null && message.getEmployee() != null) {
            return ResponseEntity.status(404).body("Sender or receiver not found.");
        }
        return ResponseEntity.ok("Message sent");
    }
}
