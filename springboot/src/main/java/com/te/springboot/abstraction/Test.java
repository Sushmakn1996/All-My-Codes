package com.te.springboot.abstraction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {
	
	public static void main(String[] args) {
		
//		Random random = new Random();
//		random.ints().limit(20).forEach(System.out::println);
		
		List<Employee> list=new ArrayList<>();
		list.add(new Employee("Sushma", "Developer", 25000));
		list.add(new Employee("Nayaka", "Analyst", 10000));
		list.add(new Employee("Sush", "Developer", 30000));
		list.add(new Employee("Fayaz", "Trainee", 12000));
		list.add(new Employee("Summet", "Senior Developer", 50000));
		list.add(new Employee("Kishor", "dev", 5000));
		
//		list.stream().filter(s->s.getSal() >10000).toList().forEach(System.out::println);
		
		Map<String, List<Employee>> collect = list.stream().filter(s->s.getDesg().equals(list.get(0).getDesg())).collect(Collectors.groupingBy(Employee::getName));
//		System.err.println(collect);
		
		Set<Entry<String, List<Employee>>> entrySet = collect.entrySet();
		entrySet.stream().forEach(System.out::println);
		
		Collection<List<Employee>> values = collect.values();
		List<List<Employee>> list2 = values.stream().toList();
//		System.err.println(list2);
		
		int sum = list.stream().filter(i->i.getDesg()=="Developer").mapToInt(Employee::getSal).sum();
		System.err.println("Developers :"+sum);
	}

}
