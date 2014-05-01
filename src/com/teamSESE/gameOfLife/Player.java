package com.teamSESE.gameOfLife;
import java.awt.Color;
import java.math.BigDecimal;

public class Player {
	

	String name;			//holds player name for each player
	Color color;			//holds player colour for each player 	- note it is of type Color 
	BigDecimal money;		//holds player money for each player 	- note it is of type BigDecimal
	BigDecimal loan;
	Course course;
	House house;
	int boardPosition;

	Player(String playerName, Color playerColor){		//Constructor -- Each player must have a name and colour
		this.color = playerColor;
		this.name = playerName;
		this.money = BigDecimal.ZERO;
		this.loan = BigDecimal.ZERO;
		this.course = null;
		this.house = GameMechanics.houseList.get(0);	//Sets beginner house to ELMS
		this.boardPosition = 0;
		
		
	}
	
	void setMoney(BigDecimal newAmount){		//resets the players money to amount passed in
		this.money = newAmount;
	}
	
	BigDecimal getMoney(){						//returns the players money as a BigDecimal
		return this.money;
	}
	
	String getMoneyString(){								//returns the players money as a String
		return this.money.toPlainString();
	}
	
	
	void addMoney(BigDecimal amount){							//Adds the amount passed in to the 
		this.money = this.money.add(amount);		//players current money
	}
	
	void takeMoney(BigDecimal amount){							//Subtracts the amount passed in from the 
		this.money = this.money.subtract(amount);	//players current money
	}

}
