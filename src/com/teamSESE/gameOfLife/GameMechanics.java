package com.teamSESE.gameOfLife;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class GameMechanics {
	
	static ArrayList<Player> playerList = new ArrayList<Player>();
	static ArrayList<Course> courseList = new ArrayList<Course>();
	static ArrayList<House> houseList = new ArrayList<House>();
	static ArrayList<Tile> tileList = new ArrayList<Tile>();
	public static boolean gameOver =false;
	
	static int tileProperties[] = {		//What each tile should do goes in here - in order!
								//Tile Number
		Tile.SELECT_COURSE,		//0
		Tile.GAIN_200,				//1
		Tile.PAY_DAY,					//2
		Tile.GAIN_200,				//3
		Tile.GAIN_200,				//4
		Tile.GAIN_200,				//5
		Tile.GAIN_200,				//6
		Tile.SUE_PLAYER_100,	//7
		Tile.GAIN_200,				//8
		Tile.GAIN_200,				//9
		Tile.PAY_DAY,					//10
		Tile.GAIN_200,				//11
		Tile.GAIN_200,				//12
		Tile.GAIN_200,				//13
		Tile.GAIN_200,				//14
		Tile.GAIN_200,	//Tile.SELECT_HOUSE,		//15
		Tile.GAIN_200,				//16
		Tile.SUE_PLAYER_100,					//17
		Tile.GAIN_200,	//Tile.SELECT_HOUSE,		//18
		Tile.PAY_DAY,				//19
		Tile.GAIN_200,				//20
		Tile.SUE_PLAYER_100,				//21
		Tile.GAIN_200,				//22
		Tile.GAIN_200,				//23
		Tile.GAIN_200,				//24
		Tile.PAY_DAY,					//25
		Tile.SUE_PLAYER_100,				//26
		Tile.GAIN_200,				//27
		Tile.GAIN_200,				//28
		Tile.GAIN_200,				//29
		Tile.SUE_PLAYER_100,				//30
		Tile.PAY_DAY,				//31
		Tile.GAIN_200,	//Tile.SELECT_HOUSE,		//32
		Tile.GAIN_200,				//33
		Tile.GAIN_200,				//34
		Tile.GAIN_200,					//35
		Tile.GAIN_200,				//36
		Tile.GAIN_200,				//37
		Tile.GAIN_200,				//38
		Tile.PAY_DAY,				//39
		Tile.SUE_PLAYER_100,				//40
		Tile.GAIN_200,				//41
		Tile.GAIN_200,			//42
		Tile.GAIN_200,				//43
		Tile.GAIN_200,				//44
		Tile.SUE_PLAYER_100,					//45
		Tile.GAIN_200,				//46
		Tile.PAY_DAY,				//47
		Tile.GAIN_200,	//Tile.SELECT_HOUSE,		//48
		Tile.GAIN_200,				//49
		Tile.SUE_PLAYER_100,				//50
		Tile.GAIN_200,				//51
		Tile.GAIN_200,			//52
		Tile.GAIN_200,				//53
		
		};
	
	
	public static void setUpCourses(){
								//	Name		Available	BaseSalary				MaxSalary				CurrentSalary
		
		courseList.add(new Course("SESE",		false, 		new BigDecimal(60000), 	new BigDecimal(100000),	new BigDecimal(60000)));
		courseList.add(new Course("Medicine",	true, 		new BigDecimal(40000), 	new BigDecimal(70000),	new BigDecimal(40000)));
		courseList.add(new Course("Law",		true, 		new BigDecimal(40000), 	new BigDecimal(70000),	new BigDecimal(40000)));
		courseList.add(new Course("Languages",	true, 		new BigDecimal(40000), 	new BigDecimal(70000),	new BigDecimal(40000)));
		courseList.add(new Course("History",	true, 		new BigDecimal(40000), 	new BigDecimal(70000),	new BigDecimal(40000)));
		courseList.add(new Course("Engineering",true,		new BigDecimal(40000), 	new BigDecimal(70000),	new BigDecimal(40000)));
		courseList.add(new Course("Nursing",	true, 		new BigDecimal(40000), 	new BigDecimal(70000),	new BigDecimal(40000)));

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
		for(int i = 0; i < tileProperties.length; i++){			//This will create the new tiles as they are in the tileProperties array
			tileList.add(new Tile(tileProperties[i])); 			//and add them to the tileList ArrayList (the board)
		}
	}
	
	public static int dice(){
		return 1 + (int)(6 * Math.random());
	}
	
	public static int randomNumber(int low, int high){
		return low + (int)(high * Math.random());
	}

	public static void movePlayer(int i) {
		JOptionPane.showMessageDialog(null, GameMechanics.playerList.get(i).name + ", your turn to roll");
		int j = dice();
		JOptionPane.showMessageDialog(null, GameMechanics.playerList.get(i).name + ", you rolled a " + j);
		System.out.print("Player " +i+ " rolled the dice and got a " +j+ ".. \n Moved from position " + playerList.get(i).boardPosition+ " to ");
		
		if ((playerList.get(i).boardPosition  + j >= 15) && (playerList.get(i).house.equals(houseList.get(0))))
		{
			playerList.get(i).boardPosition = 15;
			JOptionPane.showMessageDialog(null, GameMechanics.playerList.get(i).name + ", you must choose a house ");
			playerList.get(i).house = houseList.get(1);
		}
		else
		{
			playerList.get(i).boardPosition = playerList.get(i).boardPosition + j;
			System.out.println("position " + playerList.get(i).boardPosition);
		}
	}

	public static void startGame() {
		for(int i = 0; i < playerList.size(); i++){
			GameMechanics.tileList.get(0).execute(i);				//This will execute tile 0 on each player - they will select a course on this tile 
		}
		
		DebugGUI g1 = new DebugGUI();
		/*
		int i = randomNumber(0, playerList.size()-1);	//This just gets a random number for i to see who takes first go
		
		do{
			movePlayer(i);											//This will change player i s boardPosition
			tileList.get(playerList.get(i).boardPosition).execute(i);
			i++;
		}
		while(i != playerList.size());
		*/
		while(gameOver == false){
			for(int i = 0; i < playerList.size(); i++){
				movePlayer(i);
				if(playerList.get(i).boardPosition < tileList.size()){
					tileList.get(playerList.get(i).boardPosition).execute(i);
				}
				else{
					System.out.println(playerList.get(i).name + " has finished the game");
					gameOver = true;
				}
				g1.updateDebugGUI();
			}
		}
	}
}
