package com.teamSESE.gameOfLife;

import java.math.BigDecimal;

public class Course {
	
	String name;
	String placement;
	Boolean available;
	BigDecimal baseSalary;
	BigDecimal maxSalary;
	BigDecimal currentSalary;
	
	Course(String name,String placement, Boolean available, BigDecimal baseSalary, BigDecimal maxSalary, BigDecimal currentSalary){
		
		this.name = name;
		this.placement = placement;
		this.available = available;
		this.baseSalary = baseSalary;
		this.maxSalary = maxSalary;
		this.currentSalary = currentSalary;
	}

}