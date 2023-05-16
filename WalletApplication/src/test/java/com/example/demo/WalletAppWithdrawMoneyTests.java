package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Repository.UserRepo;
import com.example.demo.exceptions.UserException;
import com.example.demo.model.User;

import jakarta.transaction.Transactional;


@SpringBootTest
@Transactional
public class WalletAppWithdrawMoneyTests {

	 @Autowired
	    private UserRepo uRepo;

	 @Test
	 void testWithdrawMoney_UserWithId1001() throws UserException {
	    	int userid=1001;
	    	double amount=500.0;
	    	Optional<User>opt=uRepo.findById(userid);
	    	if(opt.isPresent()) {
	    		User user=opt.get();
	    		double curr=user.getWallet().getBalance();
	    		user.getWallet().setBalance(curr-amount);
	    		uRepo.save(user);
	    		double am=user.getWallet().getBalance();
	    		assertEquals(500.0, curr-am);
	    	}else {
	    		throw new UserException("User doesn't exist !");
	    	}
	     }
	
	@Test
	 void testWithdrawMoney_UserWithId1004() throws UserException {
	    	int userid=1004;
	    	double amount=1000.0;
	    	Optional<User>opt=uRepo.findById(userid);
	    	if(opt.isPresent()) {
	    		User user=opt.get();
	    		double curr=user.getWallet().getBalance();
	    		user.getWallet().setBalance(curr-amount);
	    		uRepo.save(user);
	    		double am=user.getWallet().getBalance();
	    		assertEquals(1000.0, curr-am);
	    	}else {
	    		throw new UserException("User doesn't exist !");
	    	}
	     }
	 
	 
	
}
