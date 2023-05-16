package com.example.demo;

import com.example.demo.Repository.*;
import com.example.demo.exceptions.UserException;
import com.example.demo.model.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;



import java.util.Optional;

@SpringBootTest
class WalletApplicationTests {


    @Autowired
    private UserRepo uRepo;  
    
    @Test
    void testViewWalletBalance_UserWithId1001_ReturnsExpectedBalance() throws UserException  {
     int userid=1001;
     Optional<User>opt  =uRepo.findById(userid);
       if(opt.isPresent()) {
    	   User user=opt.get();
    	   double bal=user.getWallet().getBalance();
    	   assertEquals(1000, bal);
       }else {
   		throw new UserException("User doesn't exist !");
   	   }
    }
    
    @Test
    void testViewWalletBalance_UserWithId1004_ReturnsExpectedBalance()throws UserException {
         
    	 int userid=1004;
         Optional<User>opt  =uRepo.findById(userid);
           if(opt.isPresent()) {
        	   User user=opt.get();
        	   double bal=user.getWallet().getBalance();
        	   assertEquals(6000.0, bal);
           }else {
	    		throw new UserException("User doesn't exist !");
	    	}
     }
    
    
}