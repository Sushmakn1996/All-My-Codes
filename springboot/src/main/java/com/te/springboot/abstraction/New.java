package com.te.springboot.abstraction;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class New implements Car {

	String name = "Sushma";
	
	

	protected New(String name) {
	}

	public static void main(String[] args) {
//		Car c = new Car();
//		Car.m2();
//		New n = new New("sushma");
//		n.m1();
		
//		List<String> list = new ArrayList<>();
//		LinkedList<Object> list1 = new LinkedList<>();
//		list1.add("Null");
//		list.add("S");
//		list1.add("NAme");
//		list.add("U");
//		list1.add("NamE");
//		list.add("S");
//		list1.add("New");
//		list.add("H");
//		list1.stream().sorted().forEach(s -> System.out.println(s));
		
		
		
		Set<String> set = new HashSet<>();
		Set<String> treeSet = new TreeSet<>();
		Set<String> linkedHashSet = new LinkedHashSet<>();
		
		linkedHashSet.add("Sushma");
		linkedHashSet.add("Sushma");
		linkedHashSet.add("sushma");
		
		System.err.println(linkedHashSet);
		
		
		treeSet.add("A");
		treeSet.add("A");
		treeSet.add("B");
		treeSet.add("S");
		
		System.err.println(treeSet);
		
		set.add("Sushma");
		set.add("Sushma");
		set.add("sushma");
		
		System.err.println(set);
		
		
		

		/*
		 * LocalDate date=LocalDate.now(); LocalTime time=LocalTime.now();
		 * System.err.println("Current date is :"+date);
		 * System.err.println("Current time is :"+time);
		 * 
		 * Optional<String> optional = Optional.of("Sushma");
		 * System.err.println(optional.isPresent());
		 * 
		 * Random random=new Random(); random.ints(10).forEach(System.out::println);
		 * 
		 * List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		 * IntSummaryStatistics stats = integers.stream().mapToInt((x) −>
		 * x).summaryStatistics(); System.out.println("Lowest number in List : " +
		 * stats.getMin());
		 */
	}

}
