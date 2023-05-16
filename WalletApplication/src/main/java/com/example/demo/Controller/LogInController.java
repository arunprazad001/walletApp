package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.LogInService;
import com.example.demo.Service.UserService;
import com.example.demo.exceptions.CurrentUserSessionException;
import com.example.demo.exceptions.LogInDTOException;
import com.example.demo.model.LogInDTO;

@RestController
public class LogInController {
   
	@Autowired
	LogInService l;
	
	
	@Autowired
	UserService u;
	
	@PostMapping("/logIn")
	public ResponseEntity<String> LogInHandler(@RequestBody LogInDTO log) throws CurrentUserSessionException, LogInDTOException {
		String str=l.LogInToAccount(log);
		return new ResponseEntity<String>(str,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/logout/{key}")
	public ResponseEntity<String> LogOutHandler(@PathVariable String key) throws CurrentUserSessionException {
		String str=l.LogOut(key);
		return new ResponseEntity<String>(str,HttpStatus.ACCEPTED);
	}
	
	
}
