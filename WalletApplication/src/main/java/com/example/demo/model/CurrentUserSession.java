package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CurrentUserSession {

	
	@Id
	private Integer userId;

	private String uuid;

	private String username;

	private LocalDateTime localDateTime;
	
}
