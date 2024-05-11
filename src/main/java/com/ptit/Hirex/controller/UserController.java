package com.ptit.Hirex.controller;

import java.util.Base64;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ptit.Hirex.dtos.UpdatePasswordDTO;
import com.ptit.Hirex.dtos.UserDTO;
import com.ptit.Hirex.dtos.UserLoginDTO;
import com.ptit.Hirex.dtos.UserUpdateDTO;
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

	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Long id) {
	    try {
	        User user = userServiceImpl.findById(id);
	        if (user == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok(user);
	    } catch (Exception e) {
	        return ResponseEntity.badRequest().body("Error retrieving user: " + e.getMessage());
	    }
	}

	
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

	@PostMapping("/uploadImage")
	public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile image,
	        @RequestParam("phoneNumber") String phoneNumber) {
	    try {

	        User user = userServiceImpl.findByPhoneNumber(phoneNumber);

	        if (user == null) {
	            return ResponseEntity.badRequest().body("User not found");
	        }

	        System.out.println("User found: " + user.getFullName()); 

	        String imageBase64 = Base64.getEncoder().encodeToString(image.getBytes());

	        user.setImageBase64(imageBase64);

	        userServiceImpl.saveUser(user);

	        return ResponseEntity.ok("Image uploaded successfully for user: " + user.getFullName());
	    } catch (Exception e) {
	        return ResponseEntity.badRequest().body("Error uploading image: " + e.getMessage());
	    }
	}


	@PutMapping("/updatePassword")
	public ResponseEntity<?> updatePassword(@Validated @RequestBody UpdatePasswordDTO updatePasswordDTO) {
		try {
			User updatedUser = userServiceImpl.updatePassword(updatePasswordDTO.getPhoneNumber(),
					updatePasswordDTO.getOldPassword(), updatePasswordDTO.getNewPassword());
			// Gửi phản hồi về client với thông tin cập nhật thành công
			return ResponseEntity.ok("Password updated successfully for user: " + updatedUser.getFullName());
		} catch (Exception e) {
			// Xử lý lỗi nếu có
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("/updateUser")
	public ResponseEntity<?> updateUser(@Validated @RequestBody UserUpdateDTO userUpdateDTO) {
		try {
			User updatedUser = userServiceImpl.updateUser(userUpdateDTO);
			
			return ResponseEntity.ok("Password updated successfully for user: " + userUpdateDTO.getFullName());
		} catch (Exception e) {
			// Xử lý lỗi nếu có
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
