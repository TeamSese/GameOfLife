package com.teamSESE.gameOfLife;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame 
{
	JButton startButton;																											//start button creation
	String items[] = {"-","1","2","3","4","5","6"};											// options of number of players
	JComboBox combo = new JComboBox(items);															// this is the drag down box
	JLabel numOfP = new JLabel("Select Number Of Players");							// label of instructions
	JTextField players = new JTextField(20);														// text box shows how many players are selected
	
	public MyFrame(String title, Color col)
  {
      setTitle(title);																								//title is set in main method
      setSize(500, 500);																						// this may need changed but looks ok 
      setLocationRelativeTo(null);																	// sets the location as the centre of the screen

      Container c = getContentPane();																	//container to hold the different panels
      c.setBackground(col);																						// col from main
      getContentPane().setLayout(null);																//no layout selected so we can place anywhere
      
      JPanel welcome = new JPanel();																			//wecome to the game message to display at top of box
      welcome.setBounds(155, 5, 190, 26);																	// location
      JLabel welcomeMessage = new JLabel ("Welcome to the Game of Life"); //message
      welcome.add(welcomeMessage);																				//add to panel
      c.add(welcome);																											// add to container
      
      JPanel playerPanel = new JPanel(); 																// new panel for players
      playerPanel.setBounds(92, 225, 316, 27);												// location
      playerPanel.setLayout(new GridLayout(1,2));											//layout as grid
      c.add(playerPanel);																							//add to container
      playerPanel.add(numOfP);																				//label to tell to select num of players
      playerPanel.add(combo);																					// drop down menu
      
      combo.addItemListener(new ItemListener(){											//this is to set the number of players to be displayed
        public void itemStateChanged(ItemEvent ie){
     
       if(ie.getStateChange() == ItemEvent.SELECTED){							
        String str = (String)combo.getSelectedItem();								// if the number changes then change the number of player message
        
        
        
        if(str=="1"){																								// self explanatory
        	players.setText("1 Player selected");}
      
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
       }																							// closes if statements

       }																								//closes method
        
      }																								//closes action listener
      
      );																										//closes action listener
      
      JPanel startPanel = new JPanel(); 									//start panel for start button
      startPanel.setBounds(123, 264, 254, 70);						//location 
      startPanel.setLayout(new GridLayout(2,1));					// using a grid layout
      startPanel.add(players);														// text box says number of payers
      startButton = new JButton();												// actual start button
      startPanel.add(startButton);												// button added
      startButton.setText("Start");											// button has the label start
      c.add(startPanel);																	// added to container
      
      JButton btnHelp = new JButton("Help");							//help button created with label help
      btnHelp.setBounds(191, 399, 117, 29);								//set a location
      getContentPane().add(btnHelp);											// added to container
      

      setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);			//close when closed
      setVisible(true);																			// takes off invisability cloak

  } // MyFrame constructor
}  // end of MyFrame class
