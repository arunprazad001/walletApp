package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.Repository.CurrentUserSessionRepo;
import com.example.demo.Repository.UserRepo;
import com.example.demo.Repository.WalletRepo;
import com.example.demo.exceptions.CurrentUserSessionException;
import com.example.demo.exceptions.UserDTOException;
import com.example.demo.exceptions.UserException;
import com.example.demo.exceptions.WalletException;
import com.example.demo.model.CurrentUserSession;
import com.example.demo.model.User;
import com.example.demo.model.UserDTO;
import com.example.demo.model.Wallet;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo uRepo;
	
	@Autowired
	CurrentUserSessionRepo cRepo;
	
	@Autowired
	WalletRepo wRepo;
	
	
	
	@Override
	public User CreateAccount(UserDTO Userdto) throws UserDTOException {
		  User user=new User(Userdto.getUserId(),Userdto.getUserName(),Userdto.getPassword(),Userdto.getAddress(),null);
		 
		  uRepo.save(user);
		  Wallet wall=new Wallet();
		 
		  wall.setBalance(0);
		  wall.setUser(user);
		  Wallet w=wRepo.save(wall);
		  user.setWallet(w);
		
		
		
		return uRepo.save(user);
		
		
	}

	@Override
	public String DeleteAccount(Integer id)throws UserException {
		Optional<User>opt=uRepo.findById(id);
		if(opt.isPresent()) {
			uRepo.delete(opt.get());
			return "Account Deleted";
		}else {
			throw new UserException( "Enter valid credentials");
		}
	}

	@Override
	public String viewWalletDetails( String key)throws CurrentUserSessionException{
		
		CurrentUserSession c=cRepo.findByUuid(key);
		if(c==null) {
			throw new CurrentUserSessionException( "Please login first");
		}else {
			String name=c.getUsername();
			User u=uRepo.findByUserName(name);
			Wallet w=u.getWallet(); 
			return "The Wallet Id :"+ w.getWalletId()+" "+"Wallet Balance :"+w.getBalance();

		}

	}

	@Override
	public double viewWalletBalance( String key)throws UserException {
		CurrentUserSession c=cRepo.findByUuid(key);
		if(c!=null) {
			String name=c.getUsername();
			User u=uRepo.findByUserName(name);
			if(u==null) {
				throw new UserException("User doesn't exist !");
			}
			Wallet w=u.getWallet();
			return w.getBalance();
		}
		return -1;
	}

	@Override
	public String addMoney( String key, double amount)throws CurrentUserSessionException {
		CurrentUserSession c=cRepo.findByUuid(key);
		if(c!=null) {
			String name=c.getUsername();
			User u=uRepo.findByUserName(name);
			Wallet w=u.getWallet();
			w.setBalance(w.getBalance()+amount);
			wRepo.save(w);
			return "Amount deposited successfully";
		}
		throw new CurrentUserSessionException( "Please login first");
	}

	@Override
	public String withdrawMoney( String key, double amount)throws CurrentUserSessionException,WalletException  {
		CurrentUserSession c=cRepo.findByUuid(key);
		if(c!=null) {
			String name=c.getUsername();
			User u=uRepo.findByUserName(name);
			Wallet w=u.getWallet();
			if(w.getBalance()>=amount) {
				w.setBalance(w.getBalance()-amount);
				wRepo.save(w);
				return " Amount Withdrawn :"+amount+"     Balance amount "+w.getBalance();
			}else {
				throw new WalletException("Insufficient Balance");
			}
		}
		throw new CurrentUserSessionException( "Please login first");
	}
}
