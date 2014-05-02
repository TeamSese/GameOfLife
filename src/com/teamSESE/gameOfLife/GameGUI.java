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


public class GameGUI extends JFrame{
	
	int sizeOfGrid = 5;
	JPanel gamePanel, scorePanel;
	JButton [][] squares = new JButton[sizeOfGrid][sizeOfGrid];
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

	public GameGUI(ArrayList<Player> playerList){

		setTitle("QUB Game of Life");
		setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH );		//Maximises GUI
		setLocationRelativeTo(null);
		
		Container c = getContentPane();
		c.setBackground(Color.green);
		c.setLayout(new GridLayout(1,2));
		
		intructions = new JMenuItem("Instructions");
		options = new JMenu("Options");
		options.add(intructions);
		bar = new JMenuBar();
		bar.add(options);
		
		gamePanel = new JPanel();
		gamePanel.setLayout(new GridLayout(sizeOfGrid,sizeOfGrid));
		ImageIcon water = new ImageIcon(getClass().getResource("water.jpg"));
		
		for (int i= 0; i< sizeOfGrid; i++) {
      for (int j= 0; j< sizeOfGrid; j++) {
      		
          squares[i][j] = new JButton();
          squares[i][j].setIcon(water);
          gamePanel.add(squares[i][j]);
      }
		}
		
		scorePanel = new JPanel();
		scorePanel.setBorder(new TitledBorder(null, "Player Stats", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scorePanel.setLayout(new FlowLayout());
		
		JPanel panelArray[] = new JPanel[playerList.size()];										//Creates an array of JPanels and 
		JLabel playerNameArray[] = new JLabel[playerList.size()];									//JLabels of size number of players 
		JLabel playerMoneyArray[] = new JLabel[playerList.size()];		
		
		for (int i = 0; i < playerList.size(); i++){												//For each player...
			panelArray[i] = new JPanel();															// *create a new JPanel
			panelArray[i].setBackground(playerList.get(i).color);								// *set the background colour to the players colour
			scorePanel.add(panelArray[i]);																// *add it to the main panel

			playerNameArray[i] = new JLabel(playerList.get(i).name);							// *put the player name on a JLabel
			scorePanel.add(playerNameArray[i]);															// *add the JLabel to the main panel

			playerMoneyArray[i] = new JLabel("- £" + playerList.get(i).money.toString());		// *put player money on a JLabel
			scorePanel.add(playerMoneyArray[i]);															// *add the JLabel to the main panel
		}
		
		setJMenuBar(bar);
		c.add(gamePanel);
		c.add(scorePanel);
		
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
}
