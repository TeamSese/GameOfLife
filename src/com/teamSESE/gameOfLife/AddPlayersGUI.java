package com.teamSESE.gameOfLife;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class AddPlayersGUI extends JFrame implements ActionListener{
	JTextField playerNameField;
	JRadioButton rdbtnRed,rdbtnBlue,rdbtnGreen,rdbtnOrange,rdbtnYellow,rdbtnPink,rdbtnMagenta,rdbtnCyan;
	private int selectedPlayers;										//Creates arraylist of players

	AddPlayersGUI(int selectedPlayers){

		this.selectedPlayers = selectedPlayers;
		setTitle("Enter Player Info");																	//title is set in main method
		setSize(500, 500);																				// this may need changed but looks ok 
		setLocationRelativeTo(null);																	// sets the location as the centre of the screen
		setResizable(false);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.lightGray);
		getContentPane().setLayout(new GridLayout(0,1));
//		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {				//layout and gui created with window builder
//				FormFactory.GLUE_COLSPEC,},
//				new RowSpec[] {
//				RowSpec.decode("50px"),
//				FormFactory.LINE_GAP_ROWSPEC,
//				RowSpec.decode("82px"),
//				FormFactory.LINE_GAP_ROWSPEC,
//				FormFactory.GLUE_ROWSPEC,}));
		
		ImageIcon qsisHeader = new ImageIcon(new ImageIcon(getClass().getResource("qsis.png")).getImage());
		JPanel qsisPanel = new JPanel();
		JLabel qsisLabel = new JLabel("", qsisHeader, JLabel.CENTER);
		qsisPanel.setBounds(0, 0, qsisHeader.getIconWidth() + 20, qsisHeader.getIconHeight() + 20);
		qsisPanel.setBackground(Color.lightGray);
		qsisPanel.add(qsisLabel);
		getContentPane().add(qsisPanel);
		
		JPanel textBoxPanel = new JPanel();
		textBoxPanel.setLayout(new GridLayout(3,1));
		getContentPane().add(textBoxPanel);
		textBoxPanel.setBackground(Color.white);
		
		JLabel playerLabel = new JLabel("  Player " + (GameMechanics.playerList.size()+1) + " QUB Registration");
		textBoxPanel.add(playerLabel);
		
		JPanel innerTextBoxPanel = new JPanel();
		innerTextBoxPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		innerTextBoxPanel.setBackground(Color.white);
		JLabel lblEnterPlayer = new JLabel("1. Please enter your name:     ");
		//lblEnterPlayer.setAlignmentX(LEFT_ALIGNMENT);
		innerTextBoxPanel.add(lblEnterPlayer);
		
		playerNameField = new JTextField();
		innerTextBoxPanel.add(playerNameField);
		playerNameField.setColumns(27);
		textBoxPanel.add(innerTextBoxPanel, BorderLayout.CENTER);
		
		JLabel lblEnterColor = new JLabel("  2. Choose a colour:");
		textBoxPanel.add(lblEnterColor);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new GridLayout(4,4));
		getContentPane().add(panel_1);
		panel_1.setBackground(Color.white);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.RED);
		if(colorIsAvailable(Color.red)){panel_1.add(panel_3);}			//Only show colour if it hasn't already been used

		rdbtnRed = new JRadioButton("Red");
		rdbtnRed.setBackground(Color.RED);
		panel_3.add(rdbtnRed);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.BLUE);
		if(colorIsAvailable(Color.blue)){panel_1.add(panel_4);}

		rdbtnBlue = new JRadioButton("Blue");
		rdbtnBlue.setBackground(Color.BLUE);
		panel_4.add(rdbtnBlue);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.GREEN);
		if(colorIsAvailable(Color.green)){panel_1.add(panel_5);}

		rdbtnGreen = new JRadioButton("Green");
		rdbtnGreen.setBackground(Color.GREEN);
		panel_5.add(rdbtnGreen);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.ORANGE);
		if(colorIsAvailable(Color.orange)){panel_1.add(panel_6);}

		rdbtnOrange = new JRadioButton("Orange");
		rdbtnOrange.setBackground(Color.ORANGE);
		panel_6.add(rdbtnOrange);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.YELLOW);
		if(colorIsAvailable(Color.yellow)){panel_1.add(panel_7);}

		rdbtnYellow = new JRadioButton("Yellow");
		rdbtnYellow.setBackground(Color.YELLOW);
		panel_7.add(rdbtnYellow);

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.PINK);
		if(colorIsAvailable(Color.pink)){panel_1.add(panel_8);}

		rdbtnPink = new JRadioButton("Pink");
		rdbtnPink.setBackground(Color.PINK);
		panel_8.add(rdbtnPink);

		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.MAGENTA);
		if(colorIsAvailable(Color.magenta)){panel_1.add(panel_9);}

		rdbtnMagenta = new JRadioButton("Magenta");
		rdbtnMagenta.setBackground(Color.MAGENTA);
		panel_9.add(rdbtnMagenta);

		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.CYAN);
		if(colorIsAvailable(Color.cyan)){panel_1.add(panel_10);}

		rdbtnCyan = new JRadioButton("Cyan");
		rdbtnCyan.setBackground(Color.CYAN);
		panel_10.add(rdbtnCyan);

		
		JPanel panel_2 = new JPanel(new GridBagLayout());
		getContentPane().add(panel_2);
		panel_2.setBackground(Color.white);

		ButtonGroup group = new ButtonGroup();		//Groups the radio buttons so that 
		group.add(rdbtnRed);						//only 1 can be selected at a time
		group.add(rdbtnBlue);
		group.add(rdbtnGreen);
		group.add(rdbtnOrange);
		group.add(rdbtnYellow);
		group.add(rdbtnPink);
		group.add(rdbtnMagenta);
		group.add(rdbtnCyan);

		
		JButton btnNext = new JButton("Continue");
		btnNext.addActionListener(this);			//adds actionlistener (code is in method below)
		panel_2.add(btnNext);
		setVisible(true);


	}
	/*
	public void closeJFrame(){
		System.out.println("Closing JFrame");
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);		
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
	}*/

	private Color getSelectedColor(){						//returns the colour corresponding to 
		if(rdbtnRed.isSelected()){return Color.red;}		//the selected radio button
		if(rdbtnBlue.isSelected()){return Color.blue;}
		if(rdbtnGreen.isSelected()){return Color.green;}
		if(rdbtnOrange.isSelected()){return Color.orange;}
		if(rdbtnYellow.isSelected()){return Color.yellow;}
		if(rdbtnPink.isSelected()){return Color.pink;}
		if(rdbtnMagenta.isSelected()){return Color.magenta;}
		if(rdbtnCyan.isSelected()){return Color.cyan;}
		return null;
	}

	private boolean colorIsAvailable (Color col){				//Method finds if colour is already used by another player
		for(int i = 0; i < GameMechanics.playerList.size(); i++){				//Cycles through players in list
			if(GameMechanics.playerList.get(i).color.equals(col)){		//If a player already has that colour
				return false;									//	return false for colorIsAvailable
			}
		}
		return true;											//If colour was not found assume it is available
	}

	@Override
	public void actionPerformed(ActionEvent e){
		System.out.println("btnNextActionListener Called");

		if(!playerNameField.getText().equals(null) && !playerNameField.getText().equals("") && getSelectedColor() != null){	//if all player info has been entered
			GameMechanics.playerList.add(new Player(playerNameField.getText(),getSelectedColor()));										//add the player
			System.out.println("Adding Player: " + GameMechanics.playerList.get(GameMechanics.playerList.size()-1).name);
			System.out.println("Player Colour: " + GameMechanics.playerList.get(GameMechanics.playerList.size()-1).color.toString());
			dispose();																										//close the GUI
			if (selectedPlayers != GameMechanics.playerList.size()){				//if another player needs to be added
				new AddPlayersGUI(selectedPlayers);										//open the AddPlayersGUI again 
			}
			else{
				GameMechanics.startGame();						//in the ArrayList of players
			}										
		}
		else{
			System.out.println("Player name and colour not entered...");	//If all info is not entered show message
			JOptionPane.showMessageDialog(null,								//Show message dialogue box
					"Please enter player name and colour.",					//dialogue box text
					"Warning",												//dialogue box title
					JOptionPane.ERROR_MESSAGE);
		}

	}
}

