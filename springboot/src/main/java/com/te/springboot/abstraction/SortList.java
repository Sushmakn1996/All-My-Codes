package com.te.springboot.abstraction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class SortList {
	public static void main(String[] args) {
		ArrayList<String> al=new ArrayList<>();  
		al.add("Viru");  
		al.add("Saurav");  
		al.add("Mukesh");  
		al.add("Tahir");  
		  
		Collections.sort(al, Comparator.reverseOrder());
		System.err.println(al);
		Iterator<String> itr=al.iterator();  
		while(itr.hasNext()){  
		System.out.println(itr.next());  
		 }  
	}

}
