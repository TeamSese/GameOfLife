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
	protected static final int LOOSE_200 = 3;
	protected static final int LOOSE_500 = 4;
	protected static final int GAIN_200 = 5;
	protected static final int GAIN_500 = 6;
	protected static final int SUE_PLAYER_100 = 7;		//Player is selected from GUI when tile is landed on
	protected static final int GAIN_LIFE_TILE = 8;
	protected static final int SELECT_HOUSE = 9;
	protected static final int MISS_TURN = 10;
	protected static final int FINISH = 11;
	
	
	//private static final int BLUE = 5;
	//private static final int RED = 5;
	
	
	public Tile(int tType,int gridXPos, int gridYPos){
		this.tileType = tType;		//Basically tells the tile what to execute when it is landed on
		this.gridXPos = gridXPos;
		this.gridYPos = gridYPos;
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
        		GameGUI.tileInfo.setText(GameMechanics.playerList.get(playerID).name + " has landed on a pay day");
        		break;
        	}
        	
        	case LOOSE_200:{
        		loanPlayer(playerID,new BigDecimal(200));
        		GameGUI.tileInfo.setText(GameMechanics.playerList.get(playerID).name + " has landed on a a lose 200 tile");
        		System.out.println("Player " + playerID + " lost £200!");
        		break;
        	}
        	
        	case LOOSE_500:{
        		loanPlayer(playerID,new BigDecimal(500));
        		GameGUI.tileInfo.setText(GameMechanics.playerList.get(playerID).name + " has landed on a lose 500 tile");
        		System.out.println("Player " + playerID + " lost £500!");
        		break;
        	}
        	
        	case GAIN_200:{
        		payPlayer(playerID,new BigDecimal(200));
        		GameGUI.tileInfo.setText(GameMechanics.playerList.get(playerID).name + " has landed on a gain 200 tile");
        		System.out.println("Player " + playerID + " gained £200!");
        		break;
        	}
        	
        	case GAIN_500:{
        		payPlayer(playerID,new BigDecimal(500));
        		GameGUI.tileInfo.setText(GameMechanics.playerList.get(playerID).name + " has landed on a gain 500 tile");
        		System.out.println("Player " + playerID + " gained £500!");
        		break;
        	}
        	
        	case SUE_PLAYER_100:{
        		payPlayer(playerID,new BigDecimal(100)); 		//Adds to suing player
        		Player p = selectPlayerDialogueBox(playerID,"Sue which player?");
        		p.loan = p.loan.add(new BigDecimal(100));	//Adds to loan of sued player
        		GameGUI.tileInfo.setText(GameMechanics.playerList.get(playerID).name + " has landed on a sue player tile");
        		break;
        	}
        	
        	case SELECT_HOUSE:{
        		new SelectHouseGUI(playerID);
        		GameGUI.tileInfo.setText(GameMechanics.playerList.get(playerID).name + " has landed on a new house tile");
				System.out.println("Player " + playerID + " house selected...");
				break;
        	}
        	
        	case MISS_TURN:{
        		GameMechanics.playerList.get(playerID).missTurn = GameMechanics.playerList.get(playerID).missTurn + 1;
        		GameGUI.tileInfo.setText(GameMechanics.playerList.get(playerID).name + " has landed on miss a turn");
        		System.out.println("Player " + playerID + " has to miss a turn");
        		break;
        	}
        	
        	case FINISH:{
        		GameMechanics.playerList.get(playerID).finished = true;
        		GameGUI.tileInfo.setText(GameMechanics.playerList.get(playerID).name + " has finished the game");
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
