package com.teamSESE.gameOfLife;

import javax.swing.*;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.*;

	public class instructionsFrame extends JFrame {
		JPanel button, text;
		JTextArea rules;
		JButton ok;
		String dLine = "\n" + "\n";
		String theRules = "GAME OF LIFE - QUB EDITION INSTRUCTIONS\n\n1. Players take turns to roll a dice by pressing the 'Roll Dice'\nbutton on the top right-hand side of the game panel. "
				+ "The\nplayer's counter then moves the appropriate number of spaces\nand lands on a tile.\n2. Orange tiles represent the day-to-day activities and events\nthat a student might encounter at University. Blue tiles allow\na player to indefinitely 'borrow' a sum of "
				+ "money from\nanother player. Green tiles represent income in the form of\nstudent loans (which much be paid back with 20% interest at\nthe end of the game) or a salary should the player manage\nto obtain a placement during the course of their studies at\nQUB. All players must "
				+ "stop on the red tile where they\nmust choose a new house to live in once they move out\nof Elms Village accommodation.\n3. The winner is the player that accrues the most money\nand 'life tiles' by the time they reach the end of the game\nboard.";
		
		public instructionsFrame()
		{
			//Initialise the frame
			setLocation(400, 75);
			setTitle("Instructions");
			setSize(450, 400);
			Container c = getContentPane();
			c.setLayout(new FlowLayout());
			//Initialise the text area for the rules and the ok button for the bottom
			rules = new JTextArea(theRules, 15, 1);
			rules.setEditable(false);
			JButton ok = new JButton("OK");
			//Initialise the JPanels and place the content onto them
			text = new JPanel();
			text.setSize(500, 300);
			text.add(rules);
			button = new JPanel();
			button.add(ok);
			//Add everything to the content pane
			c.add(text);
			c.add(button);
			
			//Create and initialise event handler
			ok.addActionListener(
					new ActionListener()
					{
						//If OK button is clicked
						public void actionPerformed(ActionEvent e) {
							//Set the current frame to invisible and make the menu visible
							dispose();
							//setVisible(false);
							//f1.setVisible(true);
						}
					});
			
			//Default value of frame is false until made true by menu button click
			setVisible(false);
			
			
			
		}

	}
	
