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
		
		int sizeOfGrid = 5;

		setTitle("QUB Game of Life");
		setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH );		//Maximises GUI
		setLocationRelativeTo(null);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		JButton squares[][] = new JButton[sizeOfGrid][sizeOfGrid];

		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "QUB Game of Life", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel_1);
		getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_1.setLayout(new GridLayout(sizeOfGrid, sizeOfGrid, 0, 0));
		
		ImageIcon water = new ImageIcon("src\\water.jpg");
		
		for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
          squares[i][j] = new JButton(water);
          squares[i][j].setIcon(water);
 
          panel_1.add(squares[i][j]);
      }
  }
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmMenuitem = new JMenuItem("MenuItem");
		menuBar.add(mntmMenuitem);
		
		
		JPanel panelArray[] = new JPanel[playerList.size()];										//Creates an array of JPanels and 
		JLabel playerNameArray[] = new JLabel[playerList.size()];									//JLabels of size number of players 
		JLabel playerMoneyArray[] = new JLabel[playerList.size()];		
		
		for (int i = 0; i < playerList.size(); i++){												//For each player...
			panelArray[i] = new JPanel();															// *create a new JPanel
			panelArray[i].setBackground(playerList.get(i).color);								// *set the background colour to the players colour
			panel.add(panelArray[i]);																// *add it to the main panel

			playerNameArray[i] = new JLabel(playerList.get(i).name);							// *put the player name on a JLabel
			panel.add(playerNameArray[i]);															// *add the JLabel to the main panel

			playerMoneyArray[i] = new JLabel("- �" + playerList.get(i).money.toString());		// *put player money on a JLabel
			panel.add(playerMoneyArray[i]);															// *add the JLabel to the main panel
		}

		setVisible(true);
	}		
}
