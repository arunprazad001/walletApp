package com.example.demo.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.Repository.CurrentUserSessionRepo;
import com.example.demo.Repository.UserRepo;
import com.example.demo.exceptions.CurrentUserSessionException;
import com.example.demo.exceptions.LogInDTOException;
import com.example.demo.model.CurrentUserSession;
import com.example.demo.model.LogInDTO;
import com.example.demo.model.RandomStringGenerator;
import com.example.demo.model.User;

@Service
public class LogInServiceImpl implements LogInService {

	@Autowired
	UserRepo uRepo;
	
	@Autowired
	CurrentUserSessionRepo cRepo;
	
	@Override
	public String LogInToAccount(LogInDTO log) throws CurrentUserSessionException,LogInDTOException {
		        User existingUser=uRepo.findByUserName(log.getUserName());
		        if(existingUser==null) {
		        	throw new LogInDTOException( "Enter valid user name");
		        }
		        	Optional<CurrentUserSession>opt=cRepo.findById(existingUser.getUserId());
		        	if(opt.isPresent()) {
		        		
		        		 throw new CurrentUserSessionException("Customer already logged in") ;
		        	}
		        	
		        	if(log.getPassword().equals(existingUser.getPassword())) {
		        		String key=RandomStringGenerator.StringGenerator();
		        		CurrentUserSession csession=new CurrentUserSession(existingUser.getUserId(),key,existingUser.getUserName(),LocalDateTime.now());
		        		cRepo.save(csession);
		        		return csession.toString();
		        	}else {
		        		throw new LogInDTOException("enter valid password");
		        	}
		        
	}

	@Override
	public String LogOut(String key) throws CurrentUserSessionException {
		   CurrentUserSession c=cRepo.findByUuid(key);
		   if(c!=null) {
			   cRepo.delete(c);
			   return "Logged Out";
		   }else {
			   throw new CurrentUserSessionException("Please LogIn first!") ;
		   }
	}

}
