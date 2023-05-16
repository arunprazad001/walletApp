package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
	
	@Id
	private Integer userId;
	private String userName;
    private String password;
   
	private String address;
	
	@OneToOne
	private Wallet wallet;
}
