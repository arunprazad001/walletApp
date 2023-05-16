package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.LogInService;
import com.example.demo.Service.UserService;
import com.example.demo.exceptions.CurrentUserSessionException;
import com.example.demo.exceptions.UserDTOException;
import com.example.demo.exceptions.UserException;
import com.example.demo.exceptions.WalletException;
import com.example.demo.model.User;
import com.example.demo.model.UserDTO;

@RestController
public class UserController {
  
	@Autowired
	LogInService l;
	
	
	@Autowired
	UserService u;
	
	@PostMapping("/adduser")
	public ResponseEntity<String> createUserHandler(@RequestBody UserDTO userdto) throws UserDTOException{
		User newuser=u.CreateAccount(userdto);
		String str="User added successfully !";
		return new ResponseEntity<String>(str,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/deleteuser/{id}")
	public ResponseEntity<String> deleteUserHandler(@PathVariable Integer id) throws UserException{
	      String str=u.DeleteAccount(id);
		return new ResponseEntity<String>(str,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/viewwallet/{key}")
	public ResponseEntity<String> viewWalletHandler(@PathVariable String key) throws CurrentUserSessionException{
	      String str=u.viewWalletDetails(key);
		return new ResponseEntity<String>(str,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/viewwalletbal/{key}")
	public ResponseEntity<String> viewWalletBalanceHandler(@PathVariable String key) throws UserException{
	     double bal=u.viewWalletBalance(key);
	     String res="The balance is"+bal;
		return new ResponseEntity<String>(res,HttpStatus.OK);
	}
	
	@GetMapping("/addmoney/{key}/{amount}")
	public ResponseEntity<String> addMoneyHandler(@PathVariable String key,@PathVariable double amount) throws CurrentUserSessionException{
	     String res=u.addMoney(key, amount);
	    
		return new ResponseEntity<String>(res,HttpStatus.OK);
	}
	
	@GetMapping("/withdrawmoney/{key}/{amount}")
	public ResponseEntity<String> withdrawMoneyHandler(@PathVariable String key,@PathVariable double amount) throws CurrentUserSessionException, WalletException{
	     String res=u.withdrawMoney(key, amount);
	    
		return new ResponseEntity<String>(res,HttpStatus.OK);
	}
}
