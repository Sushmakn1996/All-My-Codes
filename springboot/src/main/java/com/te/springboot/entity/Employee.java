package com.te.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "emp_info")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	private String empId;
	private String userName;
	private String password;
	private String firstName;
	private String laastName;
	private String mobNo;

}
