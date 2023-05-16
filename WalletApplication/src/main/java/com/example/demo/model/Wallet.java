package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;


@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Wallet {
  
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer walletId;
	
	private double balance;
	
	@OneToOne(mappedBy="wallet")
	private User user;
	
	
	
	
	
   
	
}
