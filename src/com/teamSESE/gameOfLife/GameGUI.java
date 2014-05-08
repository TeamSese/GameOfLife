package com.teamSESE.gameOfLife;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.border.TitledBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GameGUI extends JFrame{
	
	static int sizeOfGridX = 7;
	static int sizeOfGridY = 10;
	int height, width, playerNumber, allPlayers;
	JPanel gamePanel, scorePanel, rollPanel;
	static JLabel [][] squares = new JLabel[sizeOfGridX][sizeOfGridY];
	static JButton rollDice;
	JLabel [][] secondSquares = new JLabel[sizeOfGridX][sizeOfGridY];
	JMenu options;
	JMenuItem intructions;
	instructionsFrame instructs = new instructionsFrame();
	JMenuBar bar;
	BufferedImage counter1;
	int sizeConstraint = 100;
	JTextField rollAmount;
	JTextField playerTurn;
	static JTextField tileInfo;
	boolean checkForPlayers;
	
	/*
	 * 
	 * The players are held in an ArrayList as I think this is the best way
	 * 
	 *  To access a players info type:
	 *  	playerList.get(player number).playerName		-- returns player name
	 *  or	playerList.get(i).getMoney();					-- returns player money
	 *  or	playerList.get(i).addMoney(amount);				-- adds passed in amount to current player money
	 *  or	playerList.get(i).takeMoney(amount);			-- takes passed in amount from player money
	 * 
	 * 
	 */

	protected static final ArrayList<Player> playerList = new ArrayList<Player>();	

	public GameGUI(ArrayList<Player> playerList){
		
		super();
		
		intructions = new JMenuItem("Instructions");
		options = new JMenu("Options");
		options.add(intructions);
		bar = new JMenuBar();
		bar.add(options);
		setJMenuBar(bar);
		rollPanel = new JPanel();
		rollPanel.setLayout(new GridLayout (4,1));
		rollDice = new JButton("Roll Dice");
		playerNumber = 0;

		
		JLayeredPane layerPane = getLayeredPane();
		
		JPanel gamePanel = new JPanel();
		gamePanel.setLayout(new GridLayout(7, 10));
		gamePanel.setSize(1000, 700); // Size is needed here, as there is no layout in lp

		GamePanel glassPane = new GamePanel();
		glassPane.setLayout(new GridLayout(7,10));
		glassPane.setOpaque(false); // Set to true to see it
		glassPane.setBackground(Color.GREEN);
		glassPane.setSize(gamePanel.getBounds().width, gamePanel.getBounds().height);
		glassPane.setLocation(0, 22);
    
		JPanel panelArray[] = new JPanel[playerList.size()];										//Creates an array of JPanels and 
		JLabel playerNameArray[] = new JLabel[playerList.size()];									//JLabels of size number of players 
		JLabel playerMoneyArray[] = new JLabel[playerList.size()];	
    
    // **************************** ICONS ARE SET UP IN HERE ****************************
    
		ImageIcon GreenCurvedPathLeftDown = new ImageIcon(new ImageIcon(getClass().getResource("GreenCurvedPathLeftDown.jpg")).getImage().getScaledInstance(sizeConstraint,sizeConstraint, java.awt.Image.SCALE_SMOOTH));
		ImageIcon GreenCurvedPathLeftUp = new ImageIcon(new ImageIcon(getClass().getResource("GreenCurvedPathLeftUp.jpg")).getImage().getScaledInstance(sizeConstraint,sizeConstraint, java.awt.Image.SCALE_SMOOTH));
		ImageIcon GreenCurvedPathRightDown = new ImageIcon(new ImageIcon(getClass().getResource("GreenCurvedPathRightDown.jpg")).getImage().getScaledInstance(sizeConstraint,sizeConstraint, java.awt.Image.SCALE_SMOOTH));
		ImageIcon GreenCurvedPathUpRight = new ImageIcon(new ImageIcon(getClass().getResource("GreenCurvedPathUpRight.jpg")).getImage().getScaledInstance(sizeConstraint,sizeConstraint, java.awt.Image.SCALE_SMOOTH));
		ImageIcon GreenHorizontalPath = new ImageIcon(new ImageIcon(getClass().getResource("GreenHorizontalPath.jpg")).getImage().getScaledInstance(sizeConstraint,sizeConstraint, java.awt.Image.SCALE_SMOOTH));
		ImageIcon GreenVerticalPath = new ImageIcon(new ImageIcon(getClass().getResource("GreenVerticalPath.jpg")).getImage().getScaledInstance(sizeConstraint,sizeConstraint, java.awt.Image.SCALE_SMOOTH));
		
		ImageIcon OrangeCurvedPathLeftDown = new ImageIcon(new ImageIcon(getClass().getResource("OrangeCurvedPathLeftDown.jpg")).getImage().getScaledInstance(sizeConstraint,sizeConstraint, java.awt.Image.SCALE_SMOOTH));
		ImageIcon OrangeCurvedPathLeftUp = new ImageIcon(new ImageIcon(getClass().getResource("OrangeCurvedPathLeftUp.jpg")).getImage().getScaledInstance(sizeConstraint,sizeConstraint, java.awt.Image.SCALE_SMOOTH));
		ImageIcon OrangeCurvedPathRightDown = new ImageIcon(new ImageIcon(getClass().getResource("OrangeCurvedPathRightDown.jpg")).getImage().getScaledInstance(sizeConstraint,sizeConstraint, java.awt.Image.SCALE_SMOOTH));
		ImageIcon OrangeCurvedPathUpRight = new ImageIcon(new ImageIcon(getClass().getResource("OrangeCurvedPathRightUp.jpg")).getImage().getScaledInstance(sizeConstraint,sizeConstraint, java.awt.Image.SCALE_SMOOTH));
		ImageIcon OrangeHorizontalPath = new ImageIcon(new ImageIcon(getClass().getResource("OrangeHorizontalPathOrange.jpg")).getImage().getScaledInstance(sizeConstraint,sizeConstraint, java.awt.Image.SCALE_SMOOTH));
		ImageIcon OrangeVerticalPath = new ImageIcon(new ImageIcon(getClass().getResource("OrangeVerticalPathOrange.jpg")).getImage().getScaledInstance(sizeConstraint,sizeConstraint, java.awt.Image.SCALE_SMOOTH));
		ImageIcon OrangeFinishPathDown = new ImageIcon(new ImageIcon(getClass().getResource("OrangeFinishPathDown.jpg")).getImage().getScaledInstance(sizeConstraint,sizeConstraint, java.awt.Image.SCALE_SMOOTH));
		ImageIcon OrangeFinishPathUp = new ImageIcon(new ImageIcon(getClass().getResource("OrangeFinishPathUp.jpg")).getImage().getScaledInstance(sizeConstraint,sizeConstraint, java.awt.Image.SCALE_SMOOTH));
		
		ImageIcon BlueCurvedPathLeftDown = new ImageIcon(new ImageIcon(getClass().getResource("BlueCurvedPathLeftDown.jpg")).getImage().getScaledInstance(sizeConstraint,sizeConstraint, java.awt.Image.SCALE_SMOOTH));
		ImageIcon BlueCurvedPathLeftUp = new ImageIcon(new ImageIcon(getClass().getResource("BlueCurvedPathLeftUp.jpg")).getImage().getScaledInstance(sizeConstraint,sizeConstraint, java.awt.Image.SCALE_SMOOTH));
		ImageIcon BlueCurvedPathRightDown = new ImageIcon(new ImageIcon(getClass().getResource("BlueCurvedPathRightDown.jpg")).getImage().getScaledInstance(sizeConstraint,sizeConstraint, java.awt.Image.SCALE_SMOOTH));
		ImageIcon BlueCurvedPathUpRight = new ImageIcon(new ImageIcon(getClass().getResource("BlueCurvedPathRightUp.jpg")).getImage().getScaledInstance(sizeConstraint,sizeConstraint, java.awt.Image.SCALE_SMOOTH));
		ImageIcon BlueHorizontalPath = new ImageIcon(new ImageIcon(getClass().getResource("BlueHorizontalPath.jpg")).getImage().getScaledInstance(sizeConstraint,sizeConstraint, java.awt.Image.SCALE_SMOOTH));
		ImageIcon BlueVerticalPath = new ImageIcon(new ImageIcon(getClass().getResource("BlueVerticalPath.jpg")).getImage().getScaledInstance(sizeConstraint,sizeConstraint, java.awt.Image.SCALE_SMOOTH));
		
		ImageIcon RedVerticalPath = new ImageIcon(new ImageIcon(getClass().getResource("RedVerticalPath.jpg")).getImage().getScaledInstance(sizeConstraint,sizeConstraint, java.awt.Image.SCALE_SMOOTH));
		
		//ImageIcon PurpleIcon = new ImageIcon(new ImageIcon(getClass().getResource("PurpleIcon.png")).getImage().getScaledInstance(25,25, java.awt.Image.SCALE_SMOOTH));
		ImageIcon GrassTile = new ImageIcon(new ImageIcon(getClass().getResource("GrassTile.jpg")).getImage().getScaledInstance(sizeConstraint,sizeConstraint, java.awt.Image.SCALE_SMOOTH));
     
		// ****************************************************************************************************************

		layerPane.add(gamePanel, Integer.valueOf(1));
		layerPane.add(glassPane, Integer.valueOf(2));
		
		Container c = getContentPane();
		c.setMinimumSize(new Dimension(1100, 700));
		
		setTitle("QUB Game of Life");
		setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH );		//Maximises GUI
		setLocationRelativeTo(null);

		c.setBackground(Color.lightGray);

		//  *************** this sets up the board, setting each icon the the appropiate position ***********
		for (int i= 0; i< sizeOfGridX; i++) {
			for (int j= 0; j< sizeOfGridY; j++) {
      	
				squares[i][j] = new JLabel();
				squares[i][j].setPreferredSize(new Dimension(sizeConstraint, sizeConstraint));

				//****************** ROW 1 ********************
				if (i == 0)
				{
					switch(j){
						case 2:{squares[i][j].setIcon(OrangeCurvedPathRightDown);break;}
						case 3:{squares[i][j].setIcon(OrangeHorizontalPath);break;}
						case 4:{squares[i][j].setIcon(OrangeCurvedPathLeftDown);break;}
						case 6:{squares[i][j].setIcon(OrangeCurvedPathRightDown);break;}
						case 7:{squares[i][j].setIcon(OrangeHorizontalPath);break;}
						case 8:{squares[i][j].setIcon(GreenHorizontalPath);break;}
						case 9:{squares[i][j].setIcon(OrangeCurvedPathLeftDown);break;}
						default:{squares[i][j].setIcon(GrassTile);break;}
					}
				}
      	
				//****************** ROW 2 ********************
				if (i == 1)
				{
					switch(j){
						case 0:{squares[i][j].setIcon(OrangeCurvedPathRightDown);break;}
						case 1:{squares[i][j].setIcon(BlueHorizontalPath);break;}
						case 2:{squares[i][j].setIcon(OrangeCurvedPathLeftUp);break;}
						case 4:{squares[i][j].setIcon(GreenVerticalPath);break;}
						case 5:{squares[i][j].setIcon(OrangeCurvedPathRightDown);break;}
						case 6:{squares[i][j].setIcon(BlueCurvedPathLeftUp);break;}
						case 9:{squares[i][j].setIcon(BlueVerticalPath);break;}
						default:{squares[i][j].setIcon(GrassTile);break;}
					}
				}
      	
				//****************** ROW 3 ********************      	
				if (i == 2)
				{
					switch(j){
					case 0:{squares[i][j].setIcon(OrangeVerticalPath);break;}
					case 4:{squares[i][j].setIcon(OrangeVerticalPath);break;}
					case 5:{squares[i][j].setIcon(OrangeVerticalPath);break;}
					case 8:{squares[i][j].setIcon(OrangeCurvedPathRightDown);break;}
					case 9:{squares[i][j].setIcon(OrangeCurvedPathLeftUp);break;}
					default:{squares[i][j].setIcon(GrassTile);break;}
					}
				}
        	
				//****************** ROW 4 ********************     	
				if (i == 3)
				{
					switch(j){
						case 0:{squares[i][j].setIcon(GreenVerticalPath);break;}
						case 1:{squares[i][j].setIcon(OrangeCurvedPathRightDown);break;}
						case 2:{squares[i][j].setIcon(OrangeCurvedPathLeftDown);break;}
						case 4:{squares[i][j].setIcon(OrangeFinishPathDown);break;}
						case 5:{squares[i][j].setIcon(OrangeVerticalPath);break;}
						case 6:{squares[i][j].setIcon(BlueCurvedPathRightDown);break;}
						case 7:{squares[i][j].setIcon(GreenCurvedPathLeftDown);break;}
						case 8:{squares[i][j].setIcon(OrangeCurvedPathUpRight);break;}
						case 9:{squares[i][j].setIcon(OrangeCurvedPathLeftDown);break;}
						default:{squares[i][j].setIcon(GrassTile);break;}
					}
				}

        	
				//****************** ROW 5 ********************
				if (i == 4)
				{
					switch(j){
					case 0:{squares[i][j].setIcon(OrangeCurvedPathUpRight);break;}
					case 1:{squares[i][j].setIcon(OrangeCurvedPathLeftUp);break;}
					case 2:{squares[i][j].setIcon(RedVerticalPath);break;}
					case 3:{squares[i][j].setIcon(OrangeCurvedPathRightDown);break;}
					case 4:{squares[i][j].setIcon(OrangeCurvedPathLeftDown);break;}
					case 5:{squares[i][j].setIcon(OrangeFinishPathDown);break;}
					case 6:{squares[i][j].setIcon(OrangeVerticalPath);break;}
					case 7:{squares[i][j].setIcon(OrangeCurvedPathUpRight);break;}
					case 8:{squares[i][j].setIcon(OrangeCurvedPathLeftDown);break;}
					case 9:{squares[i][j].setIcon(BlueVerticalPath);break;}
					default:{squares[i][j].setIcon(GrassTile);break;}
					}
				}
        	
				//****************** ROW 6 ********************
				if (i == 5)
				{
					switch(j){
					case 1:{squares[i][j].setIcon(BlueCurvedPathRightDown);break;}
					case 2:{squares[i][j].setIcon(OrangeCurvedPathLeftUp);break;}
					case 3:{squares[i][j].setIcon(OrangeVerticalPath);break;}
					case 4:{squares[i][j].setIcon(OrangeCurvedPathUpRight);break;}
					case 5:{squares[i][j].setIcon(GreenCurvedPathLeftDown);break;}
					case 6:{squares[i][j].setIcon(OrangeVerticalPath);break;}
					case 7:{squares[i][j].setIcon(OrangeCurvedPathRightDown);break;}
					case 8:{squares[i][j].setIcon(BlueCurvedPathLeftUp);break;}
					case 9:{squares[i][j].setIcon(GreenVerticalPath);break;}
					default:{squares[i][j].setIcon(GrassTile);break;}
					}
				}
      		      	
				//****************** ROW 7 ********************
				if (i == 6)
				{
					switch(j){
						case 1:{squares[i][j].setIcon(OrangeCurvedPathUpRight);break;}
						case 2:{squares[i][j].setIcon(GreenHorizontalPath);break;}
						case 3:{squares[i][j].setIcon(OrangeCurvedPathLeftUp);break;}
						case 5:{squares[i][j].setIcon(BlueCurvedPathUpRight);break;}
						case 6:{squares[i][j].setIcon(OrangeCurvedPathLeftUp);break;}
						case 7:{squares[i][j].setIcon(OrangeCurvedPathUpRight);break;}
						case 8:{squares[i][j].setIcon(OrangeHorizontalPath);break;}
						case 9:{squares[i][j].setIcon(OrangeCurvedPathLeftUp);break;}
						default:{squares[i][j].setIcon(GrassTile);break;}
					}  
				}
				gamePanel.add(squares[i][j]);
			}
		}
	
		scorePanel = new JPanel();
		scorePanel.setBorder(new TitledBorder(null, "Player Stats", TitledBorder.LEADING, TitledBorder.TOP, null, null));

	/*	
		for (int i = 0; i < playerList.size(); i++){												//For each player...
			panelArray[i] = new JPanel();															// *create a new JPanel
			panelArray[i].setBackground(playerList.get(i).color);								// *set the background colour to the players colour
			scorePanel.add(panelArray[i]);																// *add it to the main panel

			playerNameArray[i] = new JLabel(playerList.get(i).name);							// *put the player name on a JLabel
			scorePanel.add(playerNameArray[i]);															// *add the JLabel to the main panel

			playerMoneyArray[i] = new JLabel("- £" + playerList.get(i).money.toString());		// *put player money on a JLabel
			scorePanel.add(playerMoneyArray[i]);															// *add the JLabel to the main panel
		}*/
		
	
		scorePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		GroupLayout groupLayout = new GroupLayout(c);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(gamePanel, GroupLayout.PREFERRED_SIZE, 1000, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scorePanel, GroupLayout.PREFERRED_SIZE, 431, GroupLayout.PREFERRED_SIZE)
					.addGap(81))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(gamePanel, GroupLayout.PREFERRED_SIZE, 800, GroupLayout.PREFERRED_SIZE)
						.addComponent(scorePanel, GroupLayout.PREFERRED_SIZE, 830, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);


		gamePanel.setLayout(new GridLayout(sizeOfGridX,sizeOfGridY));
		c.setLayout(groupLayout);
		c.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("1000px"),
				FormFactory.GLUE_COLSPEC,},
			new RowSpec[] {
				RowSpec.decode("700px"),}));
		c.add(scorePanel, "2, 1, fill, fill");
		scorePanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		for(int z = 0; z < GameMechanics.playerList.size(); z++){
			scorePanel.add(createPlayerPanel(z));
		}
		
		rollAmount = new JTextField(20);
		playerTurn = new JTextField(20);
		tileInfo = new JTextField(20);
		tileInfo.setEditable(false);
		rollAmount.setEditable(false);
		playerTurn.setEditable(false);
		
		playerTurn.setText(GameMechanics.playerList.get(0).name + "'s turn");
		rollPanel.add(rollAmount);
		rollPanel.add(rollDice);
		rollPanel.add(playerTurn);
		rollPanel.add(tileInfo);
		scorePanel.add(rollPanel);
		
		intructions.addActionListener(
				new ActionListener()
				{
					//If howToPlay button is clicked
					public void actionPerformed(ActionEvent e) {
						//Close the menu and open the howToPlay frame (using visibility settings)
						//setVisible(false);
						instructs.setVisible(true);
					}
				});

		rollDice.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						if (GameMechanics.playerList.get(playerNumber).isFinished() != true)
						{
							if (GameMechanics.playerList.get(playerNumber).getMissTurn() == 0)
							{
								GameMechanics.movePlayer(playerNumber);
								rollAmount.setText(GameMechanics.playerList.get(playerNumber).name + " has rolled a " + GameMechanics.j);
								
								if ((playerNumber + 1) == GameMechanics.playerList.size())
								{
									playerNumber = 0;
								}
								else playerNumber++;
							}
							else
							{
								GameMechanics.playerList.get(playerNumber).missTurn = GameMechanics.playerList.get(playerNumber).getMissTurn() - 1; 
								rollAmount.setText(GameMechanics.playerList.get(playerNumber).name + " has missed a turn!");
								if ((playerNumber + 1) == GameMechanics.playerList.size())
								{
									playerNumber = 0;
								}
								else playerNumber++;
							}

							allPlayers = 0;

							while (GameMechanics.playerList.get(playerNumber).finished == true)
							{
								if (allPlayers == GameMechanics.playerList.size())
								{
									// GAME IS OVER
									GameFinished FinishFrame = new GameFinished();	//Selects number of Players	
									GameMechanics.gameOver = true;
									break;
								}
								else if (playerNumber + 1 == GameMechanics.playerList.size())
								{
									playerNumber = 0;
								}
								else playerNumber++;

								allPlayers++;
							}
						}
						
						playerTurn.setText(GameMechanics.playerList.get(playerNumber).name + "'s turn");
					}
				});

		setDefaultCloseOperation(MyFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
      	System.out.println(squares[0][4].getBounds().x); 	
      	System.out.println(squares[0][4].getBounds().y);
		
	}
	
	private static JPanel createPlayerPanel(int playerID){
		JPanel tempPanel = new JPanel();
		tempPanel.setBorder(new TitledBorder(null, GameMechanics.playerList.get(playerID).name, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel colorPanel = new JPanel();
		colorPanel.setBackground(GameMechanics.playerList.get(playerID).color);	// *set the background colour to the players colour
		tempPanel.add(colorPanel);
		
		JLabel moneyLabel = new JLabel("Money - £" + GameMechanics.playerList.get(playerID).money.toString());
		tempPanel.add(moneyLabel);
		JLabel loanLabel = new JLabel("Loan - £" + GameMechanics.playerList.get(playerID).loan.toString());
		tempPanel.add(loanLabel);
		JLabel courseLabel = new JLabel("Course - " + GameMechanics.playerList.get(playerID).course.name);
		tempPanel.add(courseLabel);
		JLabel placementLabel = new JLabel("Placement - " + GameMechanics.playerList.get(playerID).course.placement);
		tempPanel.add(placementLabel);
		JLabel salaryLabel = new JLabel("Salary - £" + GameMechanics.playerList.get(playerID).course.currentSalary.toPlainString());
		tempPanel.add(salaryLabel);
		JLabel houseLabel = new JLabel("House - " + GameMechanics.playerList.get(playerID).house.name);
		tempPanel.add(houseLabel);
		JLabel rentLabel = new JLabel("Rent - £" + GameMechanics.playerList.get(playerID).house.rentPrice.toString());
		tempPanel.add(rentLabel);
		
		return tempPanel;
		
	}
	
}
