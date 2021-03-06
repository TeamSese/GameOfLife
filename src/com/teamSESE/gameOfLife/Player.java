package com.teamSESE.gameOfLife;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.imageio.ImageIO;

public class Player{
	
	String name;			//holds player name for each player
	Color color;			//holds player colour for each player 	- note it is of type Color 
	BigDecimal money;		//holds player money for each player 	- note it is of type BigDecimal
	BigDecimal loan;
	BigDecimal finalMoney;
	BigDecimal loanIncreased;
	BigDecimal finalTotal, numLife;;
	Course course;
	House house;
	int boardPosition, targetBoardPos, XPos, YPos, missTurn;
	boolean reachedPosition;
	boolean finished;
	public Image playerIcon;

	Player(String playerName, Color playerColor){		//Constructor -- Each player must have a name and colour
		this.color = playerColor;
		this.name = playerName;
		this.money = BigDecimal.ZERO;
		this.loan = BigDecimal.ZERO;
		this.course = null;
		this.house = GameMechanics.houseList.get(0);	//Sets beginner house to ELMS
		this.boardPosition = 0;
		this.missTurn = 0;
		this.finished = false;
		this.numLife = BigDecimal.ZERO;
		
		this.XPos = 400;
		this.YPos = 300;
		

		
		try {
		if(this.color == color.red){
				playerIcon = ImageIO.read(new File("RedIcon.png"));
		}
		if(this.color == color.blue){
			playerIcon = ImageIO.read(new File("BlueIcon.png"));
		}
		if(this.color == color.green){
			playerIcon = ImageIO.read(new File("GreenIcon.png"));
		}
		if(this.color == color.orange){
			playerIcon = ImageIO.read(new File("OrangeIcon.png"));
		}
		if(this.color == color.yellow){
			playerIcon = ImageIO.read(new File("YellowIcon.png"));
		}
		if(this.color == color.pink){
			playerIcon = ImageIO.read(new File("PinkIcon.png"));
		}
		if(this.color == color.cyan){
			playerIcon = ImageIO.read(new File("CyanIcon.png"));
		}
		if(this.color == color.magenta){
			playerIcon = ImageIO.read(new File("MagentaIcon.png"));
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	
	public String toString(){			//Needed for select player dialogue to show player
		return this.name;
	}
	
	int getMissTurn()
	{
		return this.missTurn;
	}
		
	BigDecimal finalMoney()
	{
		BigDecimal loanIncreased = (this.loan).multiply(new BigDecimal(1.2));
		loanIncreased = loanIncreased.setScale(0, RoundingMode.HALF_UP);
		return this.money.subtract(loanIncreased);
	}
	
	BigDecimal numLife()
	{
		return numLife;
	}
	
	BigDecimal finalTotal()
	{
		BigDecimal cashLife = (numLife()).multiply(new BigDecimal(100));
		cashLife = cashLife.setScale(0, RoundingMode.HALF_UP);
		finalTotal = cashLife.add(finalMoney());
		return finalTotal;
	}
	
	boolean isFinished()
	{
		return this.finished;
	}
	
}


