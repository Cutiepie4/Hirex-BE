package com.ptit.Hirex.controller;

import java.util.*;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import com.ptit.Hirex.dtos.*;
import com.ptit.Hirex.entity.*;
import com.ptit.Hirex.exceptions.EntityNotFoundException;
import com.ptit.Hirex.service.*;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("${api.prefix}/reviews")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ReviewController {

    private final ReviewService reviewService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @GetMapping("")
    ResponseEntity<?> getMyReview(@AuthenticationPrincipal User currentUser, @RequestParam String companyId) {
        try {
            User user = userService.findByPhoneNumber(currentUser.getPhoneNumber());
            return ResponseEntity.ok(reviewService.getMyReview(user, Long.valueOf(companyId)));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Lỗi server");
        }
    }

    @PostMapping("")
    ResponseEntity<?> postReview(@AuthenticationPrincipal User currentUser, @Valid @RequestBody ReviewRequest reviewRequest, BindingResult result) {
        try {
            if (result.hasErrors()) {
                List<String> errorMessages = result.getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
                return ResponseEntity.badRequest().body(errorMessages.toString());
            }
            User user = userService.findByPhoneNumber(currentUser.getPhoneNumber());
            reviewService.createReview(reviewRequest, user);
            return ResponseEntity.ok("Tạo thành công");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Lỗi server");
        }
    }

}
