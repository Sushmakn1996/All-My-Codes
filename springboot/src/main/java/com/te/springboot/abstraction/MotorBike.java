package com.te.springboot.abstraction;

public class MotorBike extends Bike {
	
	Bike bike=new MotorBike();
	
	Car car= (Car) new MotorBike();
	
	
	

}
