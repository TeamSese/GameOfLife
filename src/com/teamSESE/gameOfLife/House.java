package com.teamSESE.gameOfLife;
import java.math.BigDecimal;

public class House {
	
	String name;
	Boolean available;
	BigDecimal buyPrice;
	BigDecimal sellPrice;

	public House(String name, Boolean available, BigDecimal buyPrice, BigDecimal sellPrice){
		this.name = name;
		this.available = available;
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
	}
}
