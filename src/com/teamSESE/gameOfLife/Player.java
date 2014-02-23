package com.teamSESE.gameOfLife;
import java.awt.Color;
import java.math.BigDecimal;

public class Player {
	

	String playerName;			//holds player name for each player
	Color playerColor;			//holds player colour for each player 	- note it is of type Color 
	BigDecimal playerMoney;		//holds player money for each player 	- note it is of type BigDecimal

	Player(String playerName, Color playerColor){		//Constructor -- Each player must have a name and colour
		this.playerColor = playerColor;
		this.playerName = playerName;
		this.playerMoney = BigDecimal.ZERO;
	}
	
	void setMoney(BigDecimal newAmount){		//resets the players money to amount passed in
		this.playerMoney = newAmount;
	}
	
	BigDecimal getMoney(){						//returns the players money as a BigDecimal
		return this.playerMoney;
	}
	
	String getMoneyString(){								//returns the players money as a String
		return this.playerMoney.toPlainString();
	}
	
	
	void addMoney(BigDecimal amount){							//Adds the amount passed in to the 
		this.playerMoney = this.playerMoney.add(amount);		//players current money
	}
	
	void takeMoney(BigDecimal amount){							//Subtracts the amount passed in from the 
		this.playerMoney = this.playerMoney.subtract(amount);	//players current money
	}

}
