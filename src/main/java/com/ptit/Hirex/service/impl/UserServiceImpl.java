package com.ptit.Hirex.service.impl;

import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ptit.Hirex.components.JwtTokenUtil;
import com.ptit.Hirex.dtos.UserDTO;
import com.ptit.Hirex.entity.Employee;
import com.ptit.Hirex.entity.Employer;
import com.ptit.Hirex.entity.Role;
import com.ptit.Hirex.entity.User;
import com.ptit.Hirex.exceptions.DataNotFoundException;
import com.ptit.Hirex.exceptions.PermissionDenyException;
import com.ptit.Hirex.repository.RoleRepository;
import com.ptit.Hirex.repository.UserRepository;
import com.ptit.Hirex.responses.LoginResponse;
import com.ptit.Hirex.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtTokenUtil jwtTokenUtil;
	private final AuthenticationManager authenticationManager;
	private final EmployeeServiceImpl employeeServiceImpl;
	private final EmployerServiceImpl employerServiceImpl;

	@Override
	public User createUser(UserDTO userDTO) throws Exception {
		String phoneNumber = userDTO.getPhoneNumber();
		// Kiểm tra xem số điện thoại đã tồn tại hay chưa
		if (userRepository.existsByPhoneNumber(phoneNumber)) {
			throw new DataIntegrityViolationException("Phone number already exists");
		}

		Role role = roleRepository.findById(userDTO.getRoleId())
				.orElseThrow(() -> new DataNotFoundException("Role not found"));
		if (role.getName().toUpperCase().equals(Role.ADMIN)) {
			throw new PermissionDenyException("You cannot register an admin account");
		}

		// convert from userDTO => user
		User newUser = User.builder().fullName(userDTO.getFullName()).phoneNumber(userDTO.getPhoneNumber())
				.password(userDTO.getPassword()).address(userDTO.getAddress()).dateOfBirth(userDTO.getDateOfBirth())
				.facebookAccountId(userDTO.getFacebookAccountId()).googleAccountId(userDTO.getGoogleAccountId())
				.build();
		newUser.setRole(role);

		// Kiểm tra nếu có accountId, không yêu cầu password
		if (userDTO.getFacebookAccountId() == 0 && userDTO.getGoogleAccountId() == 0) {
			String password = userDTO.getPassword();
			String encodedPassword = passwordEncoder.encode(password);
			newUser.setPassword(encodedPassword);
		}
		return userRepository.save(newUser);
	}

	@Override
	public LoginResponse login(String phoneNumber, String password) throws Exception {
		Optional<User> optionalUser = userRepository.findByPhoneNumber(phoneNumber);
		if (optionalUser.isEmpty()) {
			throw new DataNotFoundException("Invalid phone number / password");
		}
		// return optionalUser.get();//muốn trả JWT token ?
		User existingUser = optionalUser.get();
		// check password
		if (existingUser.getFacebookAccountId() == 0 && existingUser.getGoogleAccountId() == 0) {
			if (!passwordEncoder.matches(password, existingUser.getPassword())) {
				throw new BadCredentialsException("Wrong phone number or password");
			}
		}
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(phoneNumber,
				password, existingUser.getAuthorities());

		// authenticate with Java Spring security
		authenticationManager.authenticate(authenticationToken);

		String token = jwtTokenUtil.generateToken(existingUser);
		String role = existingUser.getRole().getName();
		Long id = existingUser.getId();
		String name = existingUser.getFullName();

		if (role.toUpperCase().equals("USER")) {
			Employee employee = employeeServiceImpl.getEmployee(optionalUser.get().getId());
		} else {
			Employer employer = employerServiceImpl.getEmployer(optionalUser.get().getId());
		}

		return new LoginResponse(token, role, id, name);
	}

}
