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
		String theRules = "THE RULES FOR HOW TO PLAY SHOULD GO HERE";
		
		public instructionsFrame()
		{
			//Initialise the frame
			setLocation(400, 75);
			setTitle("Instructions");
			setSize(500, 400);
			Container c = getContentPane();
			c.setLayout(new FlowLayout());
			//Initialise the text area for the rules and the ok button for the bottom
			rules = new JTextArea(theRules, 15, 1);
			rules.setEditable(false);
			JButton ok = new JButton("OK");
			//Initialise the JPanels and place the content onto them
			text = new JPanel();
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
	
