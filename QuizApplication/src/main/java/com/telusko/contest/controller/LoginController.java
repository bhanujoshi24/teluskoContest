package com.telusko.contest.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.contest.entity.Users;
import com.telusko.contest.repository.UserRepository;
import com.telusko.contest.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {
	
	@Autowired
	private UserRepository userRepo;
	
	@PostMapping("/login")
	public String Login(@RequestBody Map<String, String> credential ) {
		System.out.println("In Login");
		String username = credential.get("username");
		String password = credential.get("password");
		List<Users> userByUname = userRepo.findByUsername(username);
		for(Users user: userByUname) {
			if(password.equals(user.getPassword())) {
				if(user.isAdmin() == true) {
					return "admin";
				}else {
					return "user";
				}
			}
		}
		
		return "invalid";
	}
}
