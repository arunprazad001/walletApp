package com.example.demo;

import com.example.demo.Repository.*;
import com.example.demo.Service.UserService;
import com.example.demo.exceptions.CurrentUserSessionException;
import com.example.demo.exceptions.UserException;
import com.example.demo.model.*;

import jakarta.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

@SpringBootTest
@Transactional
public class WalletApplicationAddMoneyTests {

	 @Autowired
	    private UserRepo uRepo;

	 @Test
	 void testAddMoney_UserWithId1001() throws UserException {
	    	int userid=1001;
	    	double amount=500.0;
	    	Optional<User>opt=uRepo.findById(userid);
	    	if(opt.isPresent()) {
	    		User user=opt.get();
	    		double curr=user.getWallet().getBalance();
	    		user.getWallet().setBalance(curr+amount);
	    		uRepo.save(user);
	    		double am=user.getWallet().getBalance();
	    		assertEquals(500.0, am-curr);
	    	}else {
	    		throw new UserException("User doesn't exist !");
	    	}
	    	
	    }
	
	 @Test
	 void testAddMoney_UserWithId1002() throws UserException {
	    	int userid=1002;
	    	double amount=600.0;
	    	Optional<User>opt=uRepo.findById(userid);
	    	if(opt.isPresent()) {
	    		User user=opt.get();
	    		double curr=user.getWallet().getBalance();
	    		user.getWallet().setBalance(curr+amount);
	    		uRepo.save(user);
	    		double am=user.getWallet().getBalance();
	    		assertEquals(600.0, am-curr);
	    	}else {
	    		throw new UserException("User doesn't exist !");
	    	}
	    	
	    }
	 
	
	
	
	
}
