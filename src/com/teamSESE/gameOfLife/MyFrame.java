package com.teamSESE.gameOfLife;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame 
{
	JButton startButton;															// start button creation
	String items[] = {"-","2","3","4","5","6"};									// options of number of players
	JComboBox combo = new JComboBox(items);											// this is the drag down box
	JLabel numOfP = new JLabel("Select Number Of Players");							// label of instructions
	JTextField players = new JTextField(20);										// text box shows how many players are selected

	public MyFrame(String title, Color col)
	{
		setTitle(title);																				//title is set in main method
		setSize(500, 500);																				// this may need changed but looks ok 
		setLocationRelativeTo(null);																	// sets the location as the centre of the screen

		Container c = getContentPane();																	//container to hold the different panels
		c.setBackground(Color.green);																			//col from main
		getContentPane().setLayout(null);																//no layout selected so we can place anywhere
		
		JPanel welcome = new JPanel();																		//wecome to the game message to display at top of box
		welcome.setBounds(155, 5, 190, 26);																	// location
		JLabel welcomeMessage = new JLabel ("Welcome to the Game of Life"); //message
		welcome.add(welcomeMessage);																		//add to panel
		welcome.setBackground(Color.green);
		c.add(welcome);																						// add to container

		JPanel playerPanel = new JPanel(); 													// new panel for players
		playerPanel.setBounds(92, 225, 316, 27);											// location
		playerPanel.setLayout(new GridLayout(1,2));											//layout as grid
		playerPanel.setBackground(Color.green);
		c.add(playerPanel);																	//add to container
		playerPanel.add(numOfP);															//label to tell to select num of players
		playerPanel.add(combo);																// drop down menu

		combo.addItemListener(new ItemListener(){											//this is to set the number of players to be displayed
			public void itemStateChanged(ItemEvent ie){

				if(ie.getStateChange() == ItemEvent.SELECTED){							
					String str = (String)combo.getSelectedItem();							// if the number changes then change the number of player message

					if(str=="2"){
						players.setText("2 Players selected");}

					if(str=="3"){
						players.setText("3 Players selected");}

					if(str=="4"){
						players.setText("4 Players selected");}

					if(str=="5"){
						players.setText("5 Players selected");}

					if(str=="6"){
						players.setText("6 Players selected");}
				}																						// closes if statements

			}																							//closes method

		}																								//closes action listener

				);																						//closes action listener

		JPanel startPanel = new JPanel(); 								//start panel for start button
		startPanel.setBounds(123, 264, 254, 70);						//location 
		startPanel.setLayout(new GridLayout(2,1));						// using a grid layout
		startPanel.add(players);										// text box says number of payers
		startPanel.setBackground(Color.green);
		
		startButton = new JButton();
		startButton.setText("Start");											// button has the label start												// actual start button
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
