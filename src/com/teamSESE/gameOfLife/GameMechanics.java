package com.teamSESE.gameOfLife;

import java.awt.Point;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class GameMechanics {
	
	static ArrayList<Player> playerList = new ArrayList<Player>();
	static ArrayList<Course> courseList = new ArrayList<Course>();
	static ArrayList<House> houseList = new ArrayList<House>();
	static ArrayList<Tile> tileList = new ArrayList<Tile>();
	public static boolean gameOver =false;
	public static DebugGUI g1;
	public static int j;
	static int lastTile = 7;
	
	static int tileProperties[] = {		//What each tile should do goes in here - in order!
								//Tile Number
		Tile.SELECT_COURSE,3,4,		//0
		Tile.GAIN_200,2,4,			//1
		Tile.PAY_DAY,1,4,				//2
		Tile.MISS_TURN,0,4,				//3
		Tile.MISS_TURN,0,3,				//4
		Tile.MISS_TURN,0,2,				//5
		Tile.MISS_TURN,1,2,				//6
		Tile.FINISH,1,1,		//7
		Tile.GAIN_200,1,0,				//8
		Tile.GAIN_200,2,0,				//9
		Tile.PAY_DAY,3,0,				//10
		Tile.GAIN_200,4,0,				//11
		Tile.GAIN_200,4,1,				//12
		Tile.GAIN_200,3,1,				//13
		Tile.GAIN_200,3,2,				//14
		Tile.SELECT_HOUSE,4,2,	//Tile.SELECT_HOUSE,		//15
		Tile.GAIN_200,5,2,				//16
		Tile.SUE_PLAYER_100,5,1,		//17
		Tile.GAIN_200,6,1,	//Tile.SELECT_HOUSE,		//18
		Tile.PAY_DAY,6,2,				//19
		Tile.GAIN_200,6,3,				//20
		Tile.SUE_PLAYER_100,5,3,		//21
		Tile.GAIN_200,4,3,				//22
		Tile.GAIN_200,4,4,				//23
		Tile.GAIN_200,5,4,				//24
		Tile.PAY_DAY,5,5,				//25
		Tile.SUE_PLAYER_100,6,5,		//26
		Tile.GAIN_200,6,6,				//27
		Tile.GAIN_200,5,6,				//28
		Tile.GAIN_200,4,6,				//29
		Tile.SUE_PLAYER_100,3,6,		//30
		Tile.PAY_DAY,3,7,				//31
		Tile.GAIN_200,4,7,	//Tile.SELECT_HOUSE,		//32
		Tile.GAIN_200,4,8,				//33
		Tile.GAIN_200,5,8,				//34
		Tile.GAIN_200,5,7,				//35
		Tile.GAIN_200,6,7,				//36
		Tile.GAIN_200,6,8,				//37
		Tile.GAIN_200,6,9,				//38
		Tile.PAY_DAY,5,9,				//39
		Tile.SUE_PLAYER_100,4,9,		//40
		Tile.GAIN_200,3,9,				//41
		Tile.GAIN_200,3,8,				//42
		Tile.GAIN_200,2,8,				//43
		Tile.GAIN_200,2,9,				//44
		Tile.SUE_PLAYER_100,1,9,		//45
		Tile.GAIN_200,0,9,				//46
		Tile.PAY_DAY,0,8,				//47
		Tile.GAIN_200,0,7,				//Tile.SELECT_HOUSE,		//48
		Tile.GAIN_200,0,6,				//49
		Tile.SUE_PLAYER_100,1,6,		//50
		Tile.GAIN_200,1,5,				//51
		Tile.GAIN_200,2,5,				//52
		Tile.GAIN_200,3,5,				//53
		Tile.FINISH,4,5,					//54
		
		};
	
	
	public static void setUpCourses(){
								//	Name		Available	BaseSalary				MaxSalary				CurrentSalary
		
		courseList.add(new Course("SESE","Job",		true, 		new BigDecimal(60000), 	new BigDecimal(100000),	new BigDecimal(60000)));
		courseList.add(new Course("Medicine","Job",	true, 		new BigDecimal(40000), 	new BigDecimal(70000),	new BigDecimal(40000)));
		courseList.add(new Course("Law","Job",		true, 		new BigDecimal(40000), 	new BigDecimal(70000),	new BigDecimal(40000)));
		courseList.add(new Course("Languages","Job",	true, 		new BigDecimal(40000), 	new BigDecimal(70000),	new BigDecimal(40000)));
		courseList.add(new Course("History","Job",	true, 		new BigDecimal(40000), 	new BigDecimal(70000),	new BigDecimal(40000)));
		courseList.add(new Course("Engineering","Job",true,		new BigDecimal(40000), 	new BigDecimal(70000),	new BigDecimal(40000)));
		courseList.add(new Course("Nursing","Job",	true, 		new BigDecimal(40000), 	new BigDecimal(70000),	new BigDecimal(40000)));
		courseList.add(new Course("Geography","Job",	true, 		new BigDecimal(40000), 	new BigDecimal(70000),	new BigDecimal(40000)));
	}
	
	public static void setUpHouses(){
						//		Name		Available		Rent
		houseList.add(new House("Elms",			false,		new BigDecimal(40)));
		houseList.add(new House("Holylands",	true,		new BigDecimal(20)));
		houseList.add(new House("Malone Road",	true,		new BigDecimal(40)));
		houseList.add(new House("Lisburn Road",	true,		new BigDecimal(40)));
		houseList.add(new House("Tates Avenue",	true,		new BigDecimal(40)));
		houseList.add(new House("Stran",		true,		new BigDecimal(40)));
		houseList.add(new House("Botanic",		true,		new BigDecimal(40)));
		
	}
	
	public static void setUpBoard(){
		int j = 0;
		for(int i = 0; i < tileProperties.length; i=i+3){			//This will create the new tiles as they are in the tileProperties array
			System.out.println(i);
			tileList.add(new Tile(tileProperties[i],tileProperties[i+1],tileProperties[i+2])); 			//and add them to the tileList ArrayList (the board)
			System.out.println("Tile: " + j + " X: "+tileList.get(j).gridXPos +" Y: "+ tileList.get(j).gridYPos);
			j++;
		}
	}
	
	public static int dice(){
		return 1 + (int)(6 * Math.random());
	}
	
	public static int randomNumber(int low, int high){
		return low + (int)(high * Math.random());
	}

	public static void movePlayer(int playerID) {
		
		//JOptionPane chooseRoll = new JOptionPane(GameMechanics.playerList.get(i).name + ", your turn to roll");
		//rollMessage.setBounds((int)(GameGUI.scorePanel).getLocation().getX(), ((int)(GameGUI.rollPanel).getLocation().getY() + (GameGUI.rollPanel.getHeight() / 4)) , GameGUI.rollPanel.getWidth(), GameGUI.rollPanel.getHeight());
		//rollMessage.setLocation((int)(GameGUI.scorePanel).getLocation().getX(), ((int)(GameGUI.rollPanel).getLocation().getY()));
//		JOptionPane.showMessageDialog(null, "Welcome to the Game of Life");
//		JDialog rollMessage = chooseRoll.createDialog("Follow the Instructions");
//		rollMessage.setBounds((int)(GameGUI.scorePanel).getLocation().getX(), ((int)(GameGUI.rollPanel).getLocation().getY() + (GameGUI.rollPanel.getHeight() / 4)) , GameGUI.rollPanel.getWidth(), GameGUI.rollPanel.getHeight());
//		rollMessage.setVisible(true);
		
		//GameMechanics.playerList.get(0).reachedPosition = false;
		GameGUI.rollDice.setEnabled(false);
		
		j = dice();
		
		if (gameOver == false)
		{
			if ((playerList.get(playerID).targetBoardPos  + j >= 15) && (playerList.get(playerID).house.equals(houseList.get(0))))
			{
				playerList.get(playerID).targetBoardPos = 15;
				playerList.get(playerID).house = houseList.get(1);
			} 
			else if (playerList.get(playerID).targetBoardPos  + j >= lastTile)
			{
				playerList.get(playerID).targetBoardPos = lastTile;
			}
			else
			{
				playerList.get(playerID).targetBoardPos = playerList.get(playerID).boardPosition + j;
			}
			
			if(playerList.get(playerID).targetBoardPos< tileList.size())
			{
				tileList.get(playerList.get(playerID).targetBoardPos).execute(playerID);
			}
		}
		else 
		{
			System.out.println("The Game has finished");
			gameOver = true;
		}
		updateDebug();
	}

	public static void startGame() {

		for(int i = 0; i < playerList.size(); i++){
			GameMechanics.tileList.get(0).execute(i);		//This will execute tile 0 on each player - they will select a course on this tile 
		}

		new GameGUI(GameMechanics.playerList);			//If all players have been added open the GameGUI and pass
		g1 = new DebugGUI();

	}
	
	public static void updateDebug(){
		g1.updateDebugGUI();
	}
}
