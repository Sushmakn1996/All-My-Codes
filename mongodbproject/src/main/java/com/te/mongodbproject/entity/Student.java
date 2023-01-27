package com.te.mongodbproject.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Document(collection = "student")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Student {
	
	private int id;
	private String name;
	private String email;
	
	
	
	

}
