package com.te.springboot.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="login_details")
@AllArgsConstructor
@NoArgsConstructor
public class LoginDetails {
	
	private String empId;
	private String userName;
	private String password;
	private LocalDateTime localDateTime=LocalDateTime.now();

}
