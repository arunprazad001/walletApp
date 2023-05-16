package com.example.demo.model;

import lombok.Data;

@Data
public class UserDTO {

	private Integer userId;
	private String userName;
    private String password;
   
	private String address;
	
}
