package com.te.mongodbproject.dto;

import lombok.Data;

@Data
public class StudentRequest {
	
	private int id;
	private String name;
	private String email;
	
	public StudentRequest(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

}
