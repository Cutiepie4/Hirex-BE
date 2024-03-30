package com.ptit.Hirex.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ptit.Hirex.dtos.UserDTO;
import com.ptit.Hirex.dtos.UserLoginDTO;
import com.ptit.Hirex.entity.User;
import com.ptit.Hirex.responses.LoginResponse;
import com.ptit.Hirex.service.impl.UserServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("${api.prefix}/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {

	private final UserServiceImpl userServiceImpl;

	@PostMapping("/register")
	public ResponseEntity<?> createUser(@Validated @RequestBody UserDTO userDTO, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<String> errorMessages = result.getFieldErrors().stream().map(FieldError::getDefaultMessage)
						.toList();
				return ResponseEntity.badRequest().body(errorMessages);
			}
			if (!userDTO.getPassword().equals(userDTO.getRetypePassword())) {
				return ResponseEntity.badRequest().body("Password does not match");
			}

			User user = userServiceImpl.createUser(userDTO);
//            return ResponseEntity.ok("Register successfully");
			return ResponseEntity.ok(user);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@Validated @RequestBody UserLoginDTO userLoginDTO) {
		try {
			LoginResponse loginResponse = userServiceImpl.login(userLoginDTO.getPhoneNumber(),
					userLoginDTO.getPassword());
			return ResponseEntity.ok(loginResponse);

		} catch (Exception e) {
			// It's usually a good idea to log the exception as well.
			// LOG.error("Login failed", e);
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
