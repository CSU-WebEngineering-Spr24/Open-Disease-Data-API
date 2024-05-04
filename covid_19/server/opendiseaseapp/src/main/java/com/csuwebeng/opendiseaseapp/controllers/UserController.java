package com.csuwebeng.opendiseaseapp.controllers;

import com.csuwebeng.opendiseaseapp.dao.impl.UserRepository;
import com.csuwebeng.opendiseaseapp.entities.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@RequestMapping("/user")
	public String getUserName(@RequestParam(required = false) String action,
			@RequestParam(required = false) String user, @RequestParam(required = false) String pass,
			HttpServletRequest request) {
		if (action != null && "create".equals(action)) {
			String encodedPassword = passwordEncoder.encode(pass);
			User u = new User();
			u.setUsername(user);
			u.setPassword(encodedPassword);
			u.setEnabled(true);
			userRepository.save(u);
			return "success";
		}
		if (action != null && "login".equals(action)) {

			User u = userRepository.findByUsername(user);

			if (u != null) {

				if (passwordEncoder.matches(pass, u.getPassword())) {
					return user;
				} else {
					return "failed";
				}

			} else {
				return "failed";
			}

		}

		HttpSession session = request.getSession(false);
		if (session != null) {
			String sessionId = session.getId();
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (auth != null && auth.isAuthenticated()) {
				String username = auth.getName();
				return username;
			}
		}
		return "Unknown";
	}
}