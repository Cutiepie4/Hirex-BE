package com.ptit.Hirex.service;

import com.ptit.Hirex.dtos.UserDTO;
import com.ptit.Hirex.entity.User;
import com.ptit.Hirex.responses.LoginResponse;

public interface UserService {

	User createUser(UserDTO userDTO) throws Exception;
	
	User updatePassword(String phoneNumber, String oldPassword, String newPassword) throws Exception;

	LoginResponse login(String phoneNumber, String password) throws Exception;

	User findByPhoneNumber(String phoneNumber);

	boolean addDeviceToken(User user, String newDeviceTokenString);

	
}

