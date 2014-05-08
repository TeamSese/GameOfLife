package com.teamSESE.gameOfLife;

import java.math.BigDecimal;

public class Course {
	
	String name;
	Boolean available;
	BigDecimal salary;
	
	Course(String name, Boolean available, BigDecimal salary){
		
		this.name = name;
		this.available = available;
		this.salary = salary;
	}

}