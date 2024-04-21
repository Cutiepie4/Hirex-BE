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
import com.ptit.Hirex.responses.RegisterResponse;
import com.ptit.Hirex.service.impl.UserServiceImpl;
import com.ptit.Hirex.utils.MessageKeys;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("${api.prefix}/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {

	private final UserServiceImpl userServiceImpl;

	@PostMapping("/register")
	public ResponseEntity<RegisterResponse> createUser(@Validated @RequestBody UserDTO userDTO, BindingResult result) {

		RegisterResponse registerResponse = new RegisterResponse();

		if (result.hasErrors()) {
			List<String> errorMessages = result.getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
			registerResponse.setMessage(errorMessages.toString());
			return ResponseEntity.badRequest().body(registerResponse);
		}

		if (!userDTO.getPassword().equals(userDTO.getRetypePassword())) {
			registerResponse.setMessage(MessageKeys.PASSWORD_NOT_MATCH);
			return ResponseEntity.badRequest().body(registerResponse);
		}
		try {
			User user = userServiceImpl.createUser(userDTO);
			registerResponse.setMessage(MessageKeys.REGISTER_SUCCESSFULLY);
			registerResponse.setUser(user);
			return ResponseEntity.ok(registerResponse);
		} catch (Exception e) {
			registerResponse.setMessage(e.getMessage());
			return ResponseEntity.badRequest().body(registerResponse);
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
