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
	
	int sizeOfGridX = 7;
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
		
		int sizeConstraint = 100;
		
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
		
		ImageIcon BlueCurvedPathLeftDown = new ImageIcon(new ImageIcon(getClass().getResource("BlueCurvedPathLeftDown.jpg")).getImage().getScaledInstance(sizeConstraint,sizeConstraint, java.awt.Image.SCALE_SMOOTH));
		ImageIcon BlueCurvedPathLeftUp = new ImageIcon(new ImageIcon(getClass().getResource("BlueCurvedPathLeftUp.jpg")).getImage().getScaledInstance(sizeConstraint,sizeConstraint, java.awt.Image.SCALE_SMOOTH));
		ImageIcon BlueCurvedPathRightDown = new ImageIcon(new ImageIcon(getClass().getResource("BlueCurvedPathRightDown.jpg")).getImage().getScaledInstance(sizeConstraint,sizeConstraint, java.awt.Image.SCALE_SMOOTH));
		ImageIcon BlueCurvedPathUpRight = new ImageIcon(new ImageIcon(getClass().getResource("BlueCurvedPathRightUp.jpg")).getImage().getScaledInstance(sizeConstraint,sizeConstraint, java.awt.Image.SCALE_SMOOTH));
		ImageIcon BlueHorizontalPath = new ImageIcon(new ImageIcon(getClass().getResource("BlueHorizontalPath.jpg")).getImage().getScaledInstance(sizeConstraint,sizeConstraint, java.awt.Image.SCALE_SMOOTH));
		ImageIcon BlueVerticalPath = new ImageIcon(new ImageIcon(getClass().getResource("BlueVerticalPath.jpg")).getImage().getScaledInstance(sizeConstraint,sizeConstraint, java.awt.Image.SCALE_SMOOTH));
		
		ImageIcon RedVerticalPath = new ImageIcon(new ImageIcon(getClass().getResource("RedVerticalPath.jpg")).getImage().getScaledInstance(sizeConstraint,sizeConstraint, java.awt.Image.SCALE_SMOOTH));
		
		ImageIcon GrassTile = new ImageIcon(new ImageIcon(getClass().getResource("GrassTile.jpg")).getImage().getScaledInstance(sizeConstraint,sizeConstraint, java.awt.Image.SCALE_SMOOTH));
		

		
		// dont look in here its full of if statements 
		for (int i= 0; i< sizeOfGridX; i++) {
      for (int j= 0; j< sizeOfGridY; j++) {
      	
      	squares[i][j] = new JLabel();
      	squares[i][j].setPreferredSize(new Dimension(sizeConstraint, sizeConstraint));
      	
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
      	
      	if (i == 1)
      	{
      		if (j == 0)
      		{
      			squares[i][j].setIcon(OrangeCurvedPathRightDown);
      		}
      		else if (j == 1)
      		{
      			squares[i][j].setIcon(BlueHorizontalPath);
      		}
      		else if (j == 2)
      		{
      			squares[i][j].setIcon(OrangeCurvedPathLeftUp);
      		}
      		else if (j == 4)
      		{
      			squares[i][j].setIcon(GreenVerticalPath);
      		}
      		else if (j == 5)
      		{
      			squares[i][j].setIcon(OrangeCurvedPathRightDown);
      		}
      		else if (j == 6)
      		{
      			squares[i][j].setIcon(BlueCurvedPathLeftUp);
      		}
      		else if (j == 9)
      		{
      			squares[i][j].setIcon(BlueVerticalPath);
      		}
      		else squares[i][j].setIcon(GrassTile);
      	}
      	
      	if (i == 2)
      	{
      		if (j == 0)
      		{
      			squares[i][j].setIcon(OrangeVerticalPath);
      		}
      		else if (j == 4)
      		{
      			squares[i][j].setIcon(OrangeVerticalPath);
      		}
      		else if (j == 5)
      		{
      			squares[i][j].setIcon(OrangeVerticalPath);
      		}
      		else if (j == 8)
      		{
      			squares[i][j].setIcon(OrangeCurvedPathRightDown);
      		}
      		else if (j == 9)
      		{
      			squares[i][j].setIcon(OrangeCurvedPathLeftUp);
      		}
      		else squares[i][j].setIcon(GrassTile);
      	}
      	
      	if (i == 3)
      	{
      		if (j == 0)
      		{
      			squares[i][j].setIcon(GreenVerticalPath);
      		}
      		else if (j == 1)
      		{
      			squares[i][j].setIcon(OrangeCurvedPathRightDown);
      		}
      		else if (j == 2)
      		{
      			squares[i][j].setIcon(OrangeCurvedPathLeftDown);
      		}
      		else if (j == 4)
      		{
      			squares[i][j].setIcon(RedVerticalPath);
      		}
      		else if (j == 5)
      		{
      			squares[i][j].setIcon(OrangeVerticalPath);
      		}
      		else if (j == 6)
      		{
      			squares[i][j].setIcon(BlueCurvedPathRightDown);
      		}
      		else if (j == 7)
      		{
      			squares[i][j].setIcon(GreenCurvedPathLeftDown);
      		}
      		else if (j == 8)
      		{
      			squares[i][j].setIcon(OrangeCurvedPathUpRight);
      		}
      		else if (j == 9)
      		{
      			squares[i][j].setIcon(OrangeCurvedPathLeftDown);
      		}
      		else squares[i][j].setIcon(GrassTile);
      	}
      	
      	if (i == 4)
      	{
      		if (j == 0)
      		{
      			squares[i][j].setIcon(OrangeCurvedPathUpRight);
      		}
      		else if (j == 1)
      		{
      			squares[i][j].setIcon(OrangeCurvedPathLeftUp);
      		}
      		else if (j == 2)
      		{
      			squares[i][j].setIcon(RedVerticalPath);
      		}
      		else if (j == 3)
      		{
      			squares[i][j].setIcon(OrangeCurvedPathRightDown);
      		}
      		else if (j == 4)
      		{
      			squares[i][j].setIcon(OrangeCurvedPathLeftDown);
      		}
      		else if (j == 5)
      		{
      			squares[i][j].setIcon(RedVerticalPath);
      		}
      		else if (j == 6)
      		{
      			squares[i][j].setIcon(OrangeVerticalPath);
      		}
      		else if (j == 7)
      		{
      			squares[i][j].setIcon(OrangeCurvedPathUpRight);
      		}
      		else if (j == 8)
      		{
      			squares[i][j].setIcon(OrangeCurvedPathLeftDown);
      		}
      		else if (j == 9)
      		{
      			squares[i][j].setIcon(BlueVerticalPath);
      		}
      		else squares[i][j].setIcon(GrassTile);
      	}
      	
      	
      	
      	
      	
      	
      	
      
      	
      	
      	
      	
      	
          gamePanel.add(squares[i][j]);

      }
		}
		
		scorePanel = new JPanel();
		scorePanel.setBorder(new TitledBorder(null, "Player Stats", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
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
		scorePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
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
		gamePanel.setLayout(new GridLayout(7, 10));
		getContentPane().setLayout(groupLayout);
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("1000px"),
				FormFactory.GLUE_COLSPEC,},
			new RowSpec[] {
				RowSpec.decode("700px"),}));
		getContentPane().add(gamePanel, "1, 1, fill, fill");
		getContentPane().add(scorePanel, "2, 1, fill, fill");
		scorePanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel = new JPanel();
		scorePanel.add(panel);
		
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
		JPanel temp = new JPanel();
		
		return temp;
		
	}
}
