package com.te.springboot.abstraction;

import java.util.ArrayList;

@SuppressWarnings("serial")
//custom arraylist which do not allow duplicate values
public class CustomArrayList extends ArrayList<Integer> {
	
	
	@Override
	public boolean add(Integer e) {
		if (this.contains(e)) {
			return true;
		}
		return super.add(e);
	}
	
	
	public static void main(String[] args) {
		ArrayList<Integer> list=new CustomArrayList();
		list.add(5);
		list.add(5);
		list.add(6);
		System.err.println(list);
		
	}
	
	
	


}
