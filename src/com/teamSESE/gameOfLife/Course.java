package com.teamSESE.gameOfLife;

import java.math.BigDecimal;

public class Career {
	
	String name;
	Boolean available;
	Boolean degreeRequired;
	BigDecimal baseSalary;
	BigDecimal maxSalary;
	BigDecimal currentSalary;
	
	Career(String name, Boolean available, Boolean degreeRequired, BigDecimal baseSalary, BigDecimal maxSalary, BigDecimal currentSalary){
		
		this.name = name;
		this.available = available;
		this.degreeRequired = degreeRequired;
		this.baseSalary = baseSalary;
		this.maxSalary = maxSalary;
		this.currentSalary = currentSalary;
	}

}