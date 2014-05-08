package com.teamSESE.gameOfLife;

import java.math.BigDecimal;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Tile {
	String tileText;
	int gridXPos;
	int gridYPos;
	
	//tileType - 
	//holds an in which corresponds to which function 
	//will be carried out. The switch/case statement below determines
	//which function will be carried out for which tileType	ints
	int tileType;
	
	protected static final int SELECT_COURSE = 1;
	protected static final int PAY_DAY = 2;
	
	protected static final int LOOSE_5 = 3;
	protected static final int LOOSE_30 = 4;
	protected static final int LOOSE_100 = 5;
	protected static final int LOOSE_200 = 6;
	protected static final int LOOSE_500 = 7;
	protected static final int LOOSE_1000 = 8;
	
	protected static final int GAIN_100 = 9;
	protected static final int GAIN_200 = 10;
	protected static final int GAIN_500 = 11;
	protected static final int GAIN_1000 = 12;
	
	protected static final int BORROW_100 = 13;	
	protected static final int SELECT_HOUSE = 14;		//Player is selected from GUI when tile is landed on
	protected static final int MISS_TURN = 15;
	
	protected static final int MISS_TURN_LOOSE_3000 = 16;
	protected static final int GAIN_LOOSE_1000 = 17;
	
	protected static final int FINISH = 18;
	
		
	
	public Tile(int tType,int gridXPos, int gridYPos,String tileText){
		this.tileType = tType;		//Basically tells the tile what to execute when it is landed on
		this.gridXPos = gridXPos;
		this.gridYPos = gridYPos;
		this.tileText = tileText;
	}
	
	public void execute(int playerID){		//Player ID is their position in the GameMechanics.playerList array - so each method knows which player stats to change
		switch (tileType) {
        	
			case SELECT_COURSE:	{
        		new SelectCourseGUI(playerID);
				System.out.println("Player " + playerID + " course selected...");
				break;
        	}
			
        	case PAY_DAY:{
        		paySalary(playerID);
        		//GameGUI.tileInfo.setText(GameMechanics.playerList.get(playerID).name + " has landed on a pay day");
        		break;
        	}
        	
        	case LOOSE_5:{
        		loanPlayer(playerID,new BigDecimal(5));
        		System.out.println("Player " + playerID + " lost £5!");
        		break;
        	}
        	case LOOSE_30:{
        		loanPlayer(playerID,new BigDecimal(30));
        		System.out.println("Player " + playerID + " lost £30!");
        		break;
        	}
        	case LOOSE_100:{
        		loanPlayer(playerID,new BigDecimal(100));
        		System.out.println("Player " + playerID + " lost £100!");
        		break;
        	}
        	case LOOSE_200:{
        		loanPlayer(playerID,new BigDecimal(200));
        		System.out.println("Player " + playerID + " lost £200!");
        		break;
        	}
        	case LOOSE_500:{
        		loanPlayer(playerID,new BigDecimal(500));
        		System.out.println("Player " + playerID + " lost £500!");
        		break;
        	}
        	
        	case LOOSE_1000:{
        		loanPlayer(playerID,new BigDecimal(1000));
        		System.out.println("Player " + playerID + " lost £1000!");
        		break;
        	}
        	
           	case GAIN_100:{
        		payPlayer(playerID,new BigDecimal(100));
        		//GameGUI.tileInfo.setText(GameMechanics.playerList.get(playerID).name + " has landed on a gain 200 tile");
        		System.out.println("Player " + playerID + " gained £100!");
        		break;
        	}
        	case GAIN_200:{
        		payPlayer(playerID,new BigDecimal(200));
        		//GameGUI.tileInfo.setText(GameMechanics.playerList.get(playerID).name + " has landed on a gain 200 tile");
        		System.out.println("Player " + playerID + " gained £200!");
        		break;
        	}
        	
        	case GAIN_500:{
        		payPlayer(playerID,new BigDecimal(500));
        		//GameGUI.tileInfo.setText(GameMechanics.playerList.get(playerID).name + " has landed on a gain 500 tile");
        		System.out.println("Player " + playerID + " gained £500!");
        		break;
        	}
           	case GAIN_1000:{
        		payPlayer(playerID,new BigDecimal(1000));
        		//GameGUI.tileInfo.setText(GameMechanics.playerList.get(playerID).name + " has landed on a gain 200 tile");
        		System.out.println("Player " + playerID + " gained £1000!");
        		break;
        	}
        	
        	case BORROW_100:{
        		payPlayer(playerID,new BigDecimal(100)); 		//Adds to suing player
        		Player p = selectPlayerDialogueBox(playerID,"'Borrow' £100 from which player?");
        		p.loan = p.loan.add(new BigDecimal(100));	//Adds to loan of sued player
        		//GameGUI.tileInfo.setText(GameMechanics.playerList.get(playerID).name + " has landed on a sue player tile");
        		break;
        	}
        	
        	case SELECT_HOUSE:{
        		new SelectHouseGUI(playerID);
        		//GameGUI.tileInfo.setText(GameMechanics.playerList.get(playerID).name + " has landed on a new house tile");
				System.out.println("Player " + playerID + " house selected...");
				break;
        	}
        	
        	case MISS_TURN:{
        		GameMechanics.playerList.get(playerID).missTurn = GameMechanics.playerList.get(playerID).missTurn + 1;
        		//GameGUI.tileInfo.setText(GameMechanics.playerList.get(playerID).name + " has landed on miss a turn");
        		System.out.println("Player " + playerID + " has to miss a turn");
        		break;
        	}
        	
        	case MISS_TURN_LOOSE_3000:{
        		GameMechanics.playerList.get(playerID).missTurn = GameMechanics.playerList.get(playerID).missTurn + 1;
        		loanPlayer(playerID,new BigDecimal(3000));
        		break;
        	}
        	case GAIN_LOOSE_1000:{
        		payPlayer(playerID,new BigDecimal(1000));
        		loanPlayer(playerID,new BigDecimal(1000));
        		break;
        	}
        	
        	case FINISH:{
        		GameMechanics.playerList.get(playerID).finished = true;
        		//GameGUI.tileInfo.setText(GameMechanics.playerList.get(playerID).name + " has finished the game");
        		System.out.println("Player " + playerID + " has completed the game");
        		break;
        	}
        	
		}
	}
	
	private Player selectPlayerDialogueBox(int pID, String st) {
		
		Player[] possibilities = new Player[GameMechanics.playerList.size()-1];
		
		for(int i = 0, j=0; i < GameMechanics.playerList.size(); i++){	//For to add players to the sue list
			if (i != pID){											//If to prevent player suing themselves!
				possibilities[j] = GameMechanics.playerList.get(i);
				j++;
			}
		}
		return (Player)JOptionPane.showInputDialog( null,st,"Select a player:",JOptionPane.QUESTION_MESSAGE,null, possibilities,"Select player...");
	}

	//	These could also go in GameMechanics class if need be!
	private void paySalary(int playerID) {
		GameMechanics.playerList.get(playerID).money = GameMechanics.playerList.get(playerID).money.add(GameMechanics.playerList.get(playerID).course.currentSalary);
	}
	
	private void payPlayer(int playerID, BigDecimal amount){
		GameMechanics.playerList.get(playerID).money = GameMechanics.playerList.get(playerID).money.add(amount);
	}
	
	private void loanPlayer(int playerID, BigDecimal amount){
		GameMechanics.playerList.get(playerID).loan = GameMechanics.playerList.get(playerID).loan.add(amount);
	}
	
	
}
