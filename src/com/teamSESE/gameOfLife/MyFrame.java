package com.teamSESE.gameOfLife;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MyFrame extends JFrame 
{
	JButton startButton;															// start button creation
	String items[] = {"-","2","3","4","5","6"};									// options of number of players
	JComboBox combo = new JComboBox(items);											// this is the drag down box
	JLabel numOfP = new JLabel("Select Number Of Players:");							// label of instructions
	JTextField players = new JTextField(20);										// text box shows how many players are selected

	public MyFrame(String title, Color col)
	{
		setTitle(title);																				//title is set in main method
		setSize(500, 500);																				// this may need changed but looks ok 
		setLocationRelativeTo(null);																	// sets the location as the centre of the screen

		Container c = getContentPane();																//container to hold the different panels
		c.setBackground(Color.white);																			//col from main
		getContentPane().setLayout(null);																//no layout selected so we can place anywhere
		
																					// add to container

		ImageIcon gameLogo = new ImageIcon(new ImageIcon(getClass().getResource("GameLogobBlank.png")).getImage().getScaledInstance(360,80, java.awt.Image.SCALE_SMOOTH));
		JPanel logoPanel = new JPanel();
		JLabel logoLabel = new JLabel("", gameLogo, JLabel.CENTER);
		logoPanel.setBounds(50, 45, gameLogo.getIconWidth() + 20, gameLogo.getIconHeight() + 20);
		logoPanel.setBackground(Color.white);
		logoPanel.add(logoLabel);
		c.add(logoPanel);
		
		ImageIcon qubLogo = new ImageIcon(new ImageIcon(getClass().getResource("QUBLogo.png")).getImage());
		JPanel qubLogoPanel = new JPanel();
		JLabel qubLogoLabel = new JLabel("", qubLogo, JLabel.CENTER);
		qubLogoPanel.setBounds(5, 380, qubLogo.getIconWidth() + 10, qubLogo.getIconHeight() + 10);
		qubLogoPanel.setBackground(Color.white);
		qubLogoPanel.add(qubLogoLabel);
		c.add(qubLogoPanel);
		
		ImageIcon seseLogo = new ImageIcon(new ImageIcon(getClass().getResource("seseLogo.png")).getImage());
		JPanel seseLogoPanel = new JPanel();
		JLabel seseLogoLabel = new JLabel("", seseLogo, JLabel.CENTER);
		seseLogoPanel.setBounds(320, 380, seseLogo.getIconWidth() + 10, seseLogo.getIconHeight() + 10);
		seseLogoPanel.setBackground(Color.white);
		seseLogoPanel.add(seseLogoLabel);
		c.add(seseLogoPanel);
		
		JPanel playerPanel = new JPanel(); 													// new panel for players
		playerPanel.setBounds(92, 200, 316, 27);											// location
		playerPanel.setLayout(new GridLayout(1,2));											//layout as grid
		playerPanel.setOpaque(false);
		c.add(playerPanel);																	//add to container
		playerPanel.add(numOfP);															//label to tell to select num of players
		playerPanel.add(combo);																// drop down menu

		players.setEditable(false);
		
		combo.addItemListener(new ItemListener(){											//this is to set the number of players to be displayed
			public void itemStateChanged(ItemEvent ie){

				if(ie.getStateChange() == ItemEvent.SELECTED){							
					String str = (String)combo.getSelectedItem();							// if the number changes then change the number of player message

					if(str=="2"){
						players.setText("2 players selected");}

					if(str=="3"){
						players.setText("3 players selected");}

					if(str=="4"){
						players.setText("4 players selected");}

					if(str=="5"){
						players.setText("5 players selected");}

					if(str=="6"){
						players.setText("6 players selected");}
				}																						// closes if statements

			}																							//closes method

		}																								//closes action listener

				);																						//closes action listener

		JPanel startPanel = new JPanel(); 								//start panel for start button
		startPanel.setBounds(123, 239, 254, 70);						//location 
		startPanel.setLayout(new GridLayout(2,1));						// using a grid layout
		startPanel.add(players);										// text box says number of payers
		startPanel.setBackground(Color.white);
		
		startButton = new JButton();
		startButton.setText("Start Game!");											// button has the label start												// actual start button
		startPanel.add(startButton);											// button added
		startButton.addActionListener(startButtonActionListener);				// added actionlistener 
		c.add(startPanel);														// added to container



		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);			//close when closed
		setVisible(true);																			// takes off invisability cloak
	} // MyFrame constructor

	ActionListener startButtonActionListener = new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("startButtonActionListener Called");
			if(combo.getSelectedIndex() == 0){						//If number of players is not selected show message
				JOptionPane.showMessageDialog(null,					//Show message dialogue box
						"Please enter number of players...",		//dialogue box text
						"Warning",									//dialogue box title
						JOptionPane.ERROR_MESSAGE);
			}
			else{
				AddPlayersGUI aPGUI = new AddPlayersGUI((combo.getSelectedIndex()) + 1);		//Open add players GUI and passes in no of players
				dispose();										//Closes this GUI
			}
		}
	};
}  // end of MyFrame class
