package tiktok.duong.tiktok_duong.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tiktok.duong.tiktok_duong.service.JwtService;

@RestController
public class LoginController {
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtService jwtService;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(
			@RequestParam("username")String username,
			@RequestParam("password")String password) {
		
		//authen
		authenticationManager
		.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		
		// login success, jwt -gen token (String) else throw exception
		
		return ResponseEntity.ok(jwtService.createToken(username));
	}

}
