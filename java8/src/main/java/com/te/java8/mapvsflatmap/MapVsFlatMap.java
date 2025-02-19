package com.te.java8.mapvsflatmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapVsFlatMap {
	
	public static void main(String[] args) {
		
		List<Employee> list=new ArrayList<>();
		list.add(new Employee(1, "Sushma", "Female", Arrays.asList("9066904431","8217590767")));
		list.add(new Employee(2, "Sush", "Female", Arrays.asList("9066904431","8217590767")));
		list.add(new Employee(3, "Sushma Nayaka", "Female", Arrays.asList("9066904431","8217590767")));
		list.add(new Employee(4, "Suzie", "Female", Arrays.asList("9066904431","8217590767")));
		list.add(new Employee(5, "Sush2", "Female", Arrays.asList("9066904431","8217590767")));
		
		//map -> one to one mapping
		list.stream().map(e-> e.getName()).toList().forEach(System.err::println);
		
		//flatmap -> one to many mapping
		list.stream().flatMap(e-> e.getPhoneNumbers().stream()).toList().forEach(System.out::println);
	}
	
	

}
