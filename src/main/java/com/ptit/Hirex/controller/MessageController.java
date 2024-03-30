package com.ptit.Hirex.controller;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ptit.Hirex.entity.Message;

@RestController
public class MessageController {
    @PostMapping(value = "", consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> sendMessage(@RequestBody Message message) {
        if(message.getEmployer() != null && message.getEmployee() != null) {
            return ResponseEntity.status(404).body("Sender or receiver not found.");
        }
        return ResponseEntity.ok("Message sent");
    }

    @GetMapping("/test")
    public String ok() {
        return "quan dep trai";
    }
}
