package com.teamSESE.gameOfLife;

import java.awt.Point;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class GameMechanics {
	
	static ArrayList<Player> playerList = new ArrayList<Player>();
	static ArrayList<Course> courseList = new ArrayList<Course>();
	static ArrayList<House> houseList = new ArrayList<House>();
	static ArrayList<Tile> tileList = new ArrayList<Tile>();
	public static boolean gameOver =false;
	public static DebugGUI g1;
	public static int j;
	static int lastTile = 54;
	static String tileString[] = {
		"Select Course",					//0
		"Defered start - miss a turn!",		//1
		"Student loan day! Receive £1000.",				//2		GREEN
		"Switch courses - miss a turn, pay £3000.",		//3
		"Get lost on a night out - miss a turn.",	//4
		"Win scholarship - receive £500",			//5	
		"Buy a bike - pay £200.",					//6
		"'Borrow' money from another player...",			//7			BLUE
		"Fail an exam - miss a turn",					//8
		"Find some money! Receive £200",						//9
		"Student Loan day! Receive £1000.",							//10	GREEN
		"House gets broken into - lose £200.",							//11
		"Receive student bursary - receive £500",						//12
		"Become addicted to something - miss a turn",					//13
		"Pass exams! Receive £200",									//14
		"STOP - move out of elms",										//15  RED
		"Leave Game of Life coursework to last minute - miss a turn!!",//16
		"'Borrow' money from another player...",								//17  BLUE
		"Get mugged! Lose £100",											//18
		"Student Loan day! Receive £1000.",				//19  GREEN
		"Big night out! Pay £500.",						//20
		"Meet your future partner - lose £500",				//21
		"Buy gym membership you will never use! Pay £100.",										//22
		"Forget to return book! Pay £30",				//23
		"Win £100 on a scratchcard!",								//24
		"Student Loan day! Receive £1000",								//25		GREEN
		"'Borrow' money from another player...",						//26		BLUE
		"Complete Dynamite Chicken Challenge! Lose £5, gain respect.",			//27
		"Become human guinea pig! Receive £500",								//28
		"Too hungover to go to class! Miss a turn.",							//29
		"'Borrow' money from another player...",				//30		BLUE
		"Student Loan day! Receive £1000",						//31		GREEN
		"Break your laptop! Pay £500",							//32
		"Buy a car! Pay £1000.",								//33
		"'Borrow' money from another player...",							//34  BLUE
		"Win AppCamp! Receive £1000",						//35
		"Lose wallet! Lose £100.",					//36
		"Throw house party! Pay £200 for damages.",									//37
		"Go to IET Formal! Pay £200",								//38
		"Go on placement year - receive salary!",	//39	GREEN
		"'Borrow' money from another player...",								//40	BLUE
		"Get a haircut! Pay £5",											//41
		"Noise complaint! Fined £1000.",				//42
		"Buy tickets for a gig! Pay £30",						//43
		"Spend night in a cell. Miss a turn!",				//44
		"'Borrow' money from another player...",										//45  BLUE
		"Lose phone! Pay £200.",				//46
		"Student Loan day! Receive £1000.",								//47   GREEN
		"Buy a Boojum. Pay £5.",				//48
		"Buy birthday present for friend! Pay £100.",		//49
		"'Borrow' money from another player...",	//50    BLUE
		"Pay for resit exams! Pay £500",			//51
		"Invest in Bitcoin! Lose £200",				//52
		"Grad party! Pay £200.",		//53
		"Game OVER!",						//54
		
	};
	static int tileProperties[] = {		//What each tile should do goes in here - in order!
								//Tile Number
		Tile.SELECT_COURSE,3,4,			//0
		Tile.MISS_TURN,2,4,				//1
		Tile.GAIN_LOOSE_1000,1,4,		//2 	Green
		Tile.MISS_TURN_LOOSE_3000,0,4,	//3
		Tile.MISS_TURN,0,3,				//4
		Tile.GAIN_500,0,2,				//5	
		Tile.LOOSE_200,1,2,				//6	
		Tile.BORROW_100,1,1,			//7		Blue
		Tile.MISS_TURN,1,0,				//8
		Tile.GAIN_200,2,0,				//9
		Tile.GAIN_LOOSE_1000,3,0,		//10	Green
		Tile.LOOSE_200,4,0,				//11
		Tile.GAIN_500,4,1,				//12
		Tile.MISS_TURN,3,1,				//13
		Tile.GAIN_200,3,2,				//14
		Tile.SELECT_HOUSE,4,2,				//15	Red
		Tile.MISS_TURN,5,2,				//16
		Tile.BORROW_100,5,1,			//17	Blue
		Tile.LOOSE_100,6,1,				//18
		Tile.GAIN_LOOSE_1000,6,2,		//19	Green
		Tile.LOOSE_500,6,3,				//20
		Tile.LOOSE_500,5,3,				//21
		Tile.LOOSE_100,4,3,				//22
		Tile.LOOSE_30,4,4,				//23
		Tile.GAIN_100,5,4,				//24
		Tile.GAIN_LOOSE_1000,5,5,		//25	Green
		Tile.BORROW_100,6,5,			//26	Blue
		Tile.LOOSE_5,6,6,				//27
		Tile.GAIN_500,5,6,				//28
		Tile.MISS_TURN,4,6,				//29
		Tile.BORROW_100,3,6,			//30	Blue
		Tile.GAIN_LOOSE_1000,3,7,		//31	Green
		Tile.LOOSE_500,4,7,				//32
		Tile.LOOSE_1000,4,8,				//33
		Tile.BORROW_100,5,8,				//34	Blue
		Tile.GAIN_1000,5,7,				//35
		Tile.LOOSE_100,6,7,				//36
		Tile.LOOSE_200,6,8,				//37
		Tile.LOOSE_200,6,9,				//38
		Tile.PAY_DAY,5,9,				//39	Green
		Tile.BORROW_100,4,9,			//40	Blue
		Tile.LOOSE_5,3,9,				//41
		Tile.LOOSE_1000,3,8,			//42
		Tile.LOOSE_30,2,8,				//43
		Tile.MISS_TURN,2,9,				//44
		Tile.BORROW_100,1,9,			//45	Blue
		Tile.LOOSE_200,0,9,				//46
		Tile.GAIN_LOOSE_1000,0,8,		//47	Green
		Tile.LOOSE_5,0,7,				//48
		Tile.LOOSE_100,0,6,				//49
		Tile.BORROW_100,1,6,			//50	Blue
		Tile.LOOSE_500,1,5,				//51
		Tile.LOOSE_200,2,5,				//52
		Tile.LOOSE_200,3,5,				//53
		Tile.FINISH,4,5,					//54
		
		};
	
	
	public static void setUpCourses(){
								//	Name			Available	Salary
		
		courseList.add(new Course("SESE",	true, 		new BigDecimal(12000)));
		courseList.add(new Course("Medicine",	true, 		new BigDecimal(10000)));
		courseList.add(new Course("Law", 	true, 		new BigDecimal(8000)));
		courseList.add(new Course("Languages",	true, 		new BigDecimal(6000)));
		courseList.add(new Course("History",	true, 		new BigDecimal(5000)));
		courseList.add(new Course("Engineering",	true,		new BigDecimal(11000)));
		courseList.add(new Course("Nursing",		true, 		new BigDecimal(7000)));
		courseList.add(new Course("Geography",	true, 		new BigDecimal(8000)));
	}
	
	public static void setUpHouses(){
						//		Name		Available		Rent
		houseList.add(new House("Elms",			false,		new BigDecimal(60)));
		houseList.add(new House("Holylands",	true,		new BigDecimal(40)));
		houseList.add(new House("Malone Road",	true,		new BigDecimal(120)));
		houseList.add(new House("Lisburn Road",	true,		new BigDecimal(80)));
		houseList.add(new House("Tates Avenue",	true,		new BigDecimal(70)));
		houseList.add(new House("Stranmillis",	true,		new BigDecimal(90)));
		houseList.add(new House("Botanic",		true,		new BigDecimal(100)));
		houseList.add(new House("Donegal Road", true,       new BigDecimal(75)));
		
	}
	
	public static void setUpBoard(){
		int j = 0;
		for(int i = 0; i < tileProperties.length; i=i+3){			//This will create the new tiles as they are in the tileProperties array
			System.out.println(i);
			tileList.add(new Tile(tileProperties[i],tileProperties[i+1],tileProperties[i+2],tileString[j])); 			//and add them to the tileList ArrayList (the board)
			System.out.println("Tile: " + j + " X: "+tileList.get(j).gridXPos +" Y: " + tileList.get(j).gridYPos);
			System.out.println(tileString[j]);
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
			playerList.get(playerID).loan = playerList.get(playerID).loan.add(playerList.get(playerID).house.rentPrice);
			
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
				GameGUI.tileInfo.setText(tileList.get(playerList.get(playerID).targetBoardPos).tileText);
			}
		}
		else 
		{
			System.out.println("The Game has finished");
			gameOver = true;
		}
		updatePlayerStats();
	}

	public static void startGame() {

		for(int i = 0; i < playerList.size(); i++){
			GameMechanics.tileList.get(0).execute(i);		//This will execute tile 0 on each player - they will select a course on this tile 
		}

		new GameGUI(GameMechanics.playerList);			//If all players have been added open the GameGUI and pass
		g1 = new DebugGUI();
		JOptionPane.showMessageDialog(null, "Welcome to Queens! You have moved into Elms\nand rent will be paid on every turn! Good Luck!");


	}
	
	public static void updatePlayerStats(){
		g1.updateDebugGUI();
		GameGUI.updateScorePanel();
	}
}
