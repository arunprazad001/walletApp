package com.example.demo.Service;

import com.example.demo.exceptions.*;
import com.example.demo.model.User;
import com.example.demo.model.UserDTO;


public interface UserService {

	public User CreateAccount(UserDTO Userdto) throws UserDTOException;
	public String DeleteAccount(Integer id)throws UserException;
	public String viewWalletDetails(String key)throws CurrentUserSessionException;
	public double viewWalletBalance(String key)throws UserException;
	public String addMoney(String key,double amount)throws CurrentUserSessionException ;
	public String withdrawMoney(String key,double amount)throws CurrentUserSessionException,WalletException ;
	
}
