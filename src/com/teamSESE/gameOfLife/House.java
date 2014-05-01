package com.teamSESE.gameOfLife;
import java.math.BigDecimal;

public class House {
	
	String name;
	Boolean available;
	BigDecimal rentPrice;

	public House(String name, Boolean available, BigDecimal rentPrice){
		this.name = name;
		this.available = available;
		this.rentPrice = rentPrice;
	}
}
