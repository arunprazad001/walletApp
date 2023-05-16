package com.example.demo.Service;

import com.example.demo.exceptions.*;
import com.example.demo.model.LogInDTO;

public interface LogInService {

	public String LogInToAccount(LogInDTO log)throws CurrentUserSessionException,LogInDTOException;
	
	public String LogOut(String key)throws CurrentUserSessionException;
}
