package com.teamSESE.gameOfLife;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.border.TitledBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;


public class GameGUI extends JFrame{
	
	int sizeOfGridX = 8;
	int sizeOfGridY = 10;
	JPanel gamePanel, scorePanel;
	JLabel [][] squares = new JLabel[sizeOfGridX][sizeOfGridY];
	JMenu options;
	JMenuItem intructions;
	instructionsFrame instructs = new instructionsFrame();
	JMenuBar bar;
	
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
	private JPanel panel;

	public GameGUI(ArrayList<Player> playerList){
		getContentPane().setMinimumSize(new Dimension(1100, 700));

		setTitle("QUB Game of Life");
		setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH );		//Maximises GUI
		setLocationRelativeTo(null);
		
		Container c = getContentPane();
		c.setBackground(Color.green);
		
		intructions = new JMenuItem("Instructions");
		options = new JMenu("Options");
		options.add(intructions);
		bar = new JMenuBar();
		bar.add(options);
		
		gamePanel = new JPanel();
		gamePanel.setLayout(new GridLayout(sizeOfGridX,sizeOfGridY));
		
		ImageIcon GreenCurvedPathLeftDown = new ImageIcon(getClass().getResource("GreenCurvedPathLeftDown.jpg"));
		ImageIcon GreenCurvedPathLeftUp = new ImageIcon(getClass().getResource("GreenCurvedPathLeftUp.jpg"));
		ImageIcon GreenCurvedPathRightDown = new ImageIcon(getClass().getResource("GreenCurvedPathRightDown.jpg"));
		ImageIcon GreenCurvedPathUpRight = new ImageIcon(getClass().getResource("GreenCurvedPathUpRight.jpg"));
		ImageIcon GreenHorizontalPath = new ImageIcon(getClass().getResource("GreenHorizontalPath.jpg"));
		ImageIcon GreenVerticalPath = new ImageIcon(getClass().getResource("GreenVerticalPath.jpg"));
		
		ImageIcon OrangeCurvedPathLeftDown = new ImageIcon(getClass().getResource("OrangeCurvedPathLeftDown.jpg"));
		ImageIcon OrangeCurvedPathLeftUp = new ImageIcon(getClass().getResource("OrangeCurvedPathLeftUp.jpg"));
		ImageIcon OrangeCurvedPathRightDown = new ImageIcon(getClass().getResource("OrangeCurvedPathRightDown.jpg"));
		ImageIcon OrangeCurvedPathUpRight = new ImageIcon(getClass().getResource("OrangeCurvedPathRightUp.jpg"));
		ImageIcon OrangeHorizontalPath = new ImageIcon(getClass().getResource("OrangeHorizontalPathOrange.jpg"));
		ImageIcon OrangeVerticalPath = new ImageIcon(getClass().getResource("OrangeVerticalPathOrange.jpg"));
		
		ImageIcon BlueCurvedPathLeftDown = new ImageIcon(getClass().getResource("BlueCurvedPathLeftDown.jpg"));
		ImageIcon BlueCurvedPathLeftUp = new ImageIcon(getClass().getResource("BlueCurvedPathLeftUp.jpg"));
		ImageIcon BlueCurvedPathRightDown = new ImageIcon(getClass().getResource("BlueCurvedPathRightDown.jpg"));
		ImageIcon BlueCurvedPathUpRight = new ImageIcon(getClass().getResource("BlueCurvedPathRightUp.jpg"));
		ImageIcon BlueHorizontalPath = new ImageIcon(getClass().getResource("BlueHorizontalPath.jpg"));
		ImageIcon BlueVerticalPath = new ImageIcon(getClass().getResource("BlueVerticalPath.jpg"));
		
		ImageIcon RedVerticalPath = new ImageIcon(getClass().getResource("RedVerticalPath.jpg"));
		
		ImageIcon GrassTile = new ImageIcon(getClass().getResource("GrassTile.jpg"));
		

		
		// dont look in here its full of if statements 
		for (int i= 0; i< sizeOfGridX; i++) {
      for (int j= 0; j< sizeOfGridY; j++) {
      	
      	squares[i][j] = new JLabel();
      	squares[i][j].setPreferredSize(new Dimension(100, 100));
      	
      	if (i == 0)
      	{
      		if (j == 2)
      		{
      			squares[i][j].setIcon(OrangeCurvedPathRightDown);
      		}
      		else if (j == 3)
      		{
      			squares[i][j].setIcon(OrangeHorizontalPath);
      		}
      		else if (j == 4)
      		{
      			squares[i][j].setIcon(OrangeCurvedPathLeftDown);
      		}
      		else if (j == 6)
      		{
      			squares[i][j].setIcon(OrangeCurvedPathRightDown);
      		}
      		else if (j == 7)
      		{
      			squares[i][j].setIcon(OrangeHorizontalPath);
      		}
      		else if (j == 8)
      		{
      			squares[i][j].setIcon(GreenHorizontalPath);
      		}
      		else if (j == 9)
      		{
      			squares[i][j].setIcon(OrangeCurvedPathLeftDown);
      		}
      		else squares[i][j].setIcon(GrassTile);
      	}
      	else squares[i][j].setIcon(GrassTile);
      	
      
      	
      	
      	
      	
      	
          gamePanel.add(squares[i][j]);
      }
		}
		
		scorePanel = new JPanel();
		scorePanel.setBorder(new TitledBorder(null, "Player Stats", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panelArray[] = new JPanel[playerList.size()];										//Creates an array of JPanels and 
		JLabel playerNameArray[] = new JLabel[playerList.size()];									//JLabels of size number of players 
		JLabel playerMoneyArray[] = new JLabel[playerList.size()];		
	/*	
		for (int i = 0; i < playerList.size(); i++){												//For each player...
			panelArray[i] = new JPanel();															// *create a new JPanel
			panelArray[i].setBackground(playerList.get(i).color);								// *set the background colour to the players colour
			scorePanel.add(panelArray[i]);																// *add it to the main panel

			playerNameArray[i] = new JLabel(playerList.get(i).name);							// *put the player name on a JLabel
			scorePanel.add(playerNameArray[i]);															// *add the JLabel to the main panel

			playerMoneyArray[i] = new JLabel("- �" + playerList.get(i).money.toString());		// *put player money on a JLabel
			scorePanel.add(playerMoneyArray[i]);															// *add the JLabel to the main panel
		}*/
		
		setJMenuBar(bar);
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("1000px"),
				FormFactory.GLUE_COLSPEC,},
			new RowSpec[] {
				RowSpec.decode("700px"),}));
		getContentPane().add(gamePanel, "1, 1, fill, fill");
		getContentPane().add(scorePanel, "2, 1, fill, fill");
		scorePanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		for(int i = 0; i < GameMechanics.playerList.size(); i++){
			scorePanel.add(createPlayerPanel(i));
		}
		
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

		setDefaultCloseOperation(MyFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private static JPanel createPlayerPanel(int playerID){
		JPanel tempPanel = new JPanel();
		tempPanel.setBorder(new TitledBorder(null, GameMechanics.playerList.get(playerID).name, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel colorPanel = new JPanel();
		colorPanel.setBackground(GameMechanics.playerList.get(playerID).color);	// *set the background colour to the players colour
		tempPanel.add(colorPanel);
		
		JLabel moneyLabel = new JLabel("Money - �" + GameMechanics.playerList.get(playerID).money.toString());
		tempPanel.add(moneyLabel);
		JLabel loanLabel = new JLabel("Loan - �" + GameMechanics.playerList.get(playerID).loan.toString());
		tempPanel.add(loanLabel);
		JLabel courseLabel = new JLabel("Course - �"); //+ GameMechanics.playerList.get(playerID).course.name);
		tempPanel.add(courseLabel);
		JLabel houseLabel = new JLabel("House - �" + GameMechanics.playerList.get(playerID).house.name);
		tempPanel.add(houseLabel);
		
		return tempPanel;
		
	}
}
