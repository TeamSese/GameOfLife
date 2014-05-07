package com.teamSESE.gameOfLife;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.awt.Rectangle;
import java.awt.Dimension;

import javax.swing.BoxLayout;

import java.awt.Component;

import javax.swing.SwingConstants;


public class SelectHouseGUI extends JDialog{
	
	JTextField choice1txt1 = new JTextField();
	JTextField choice1txt2 = new JTextField();
	JTextField choice2txt1 = new JTextField();
	JTextField choice2txt2 = new JTextField();

	
	JButton choiceButton1 = new JButton();
	JButton choiceButton2 = new JButton();
	JButton choiceButton3 = new JButton();
	JButton selectHouse2 = new JButton();
	JButton selectHouse1 = new JButton();
	
	JPanel welcome = new JPanel();
	JPanel main = new JPanel();
	JPanel choicePanel = new JPanel();
	JPanel choiceDetails1 = new JPanel();
	JPanel choiceDetails2 = new JPanel();
	JPanel choiceDetails1a = new JPanel();
	JPanel choiceDetails1b = new JPanel();
	JPanel choiceDetails2a = new JPanel();
	JPanel choiceDetails2b = new JPanel();
	
	List<Integer> list = new ArrayList<Integer>();
	int playerID, buttonPressCount = 0;
	
	
SelectHouseGUI(int playerIdentity){
		super((SelectHouseGUI)null);
		setModal(true);										
		
		playerID = playerIdentity;
		for(int i=0; i<GameMechanics.houseList.size(); i++){
			if(GameMechanics.houseList.get(i).available){
				list.add(i);		
			}
		}
		Collections.shuffle(list);
		
		setTitle("Select House");
		setSize(500,500);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new GridLayout(0,1));
		
		ImageIcon propertyHeader = new ImageIcon(new ImageIcon(getClass().getResource("propertypal.png")).getImage());
		JPanel propertyPanel = new JPanel();
		JLabel propertyLabel = new JLabel("", propertyHeader, JLabel.CENTER);
		propertyPanel.setBounds(0, 0, propertyHeader.getIconWidth() + 20, propertyHeader.getIconHeight() + 20);
		propertyPanel.setBackground(Color.lightGray);
		propertyPanel.add(propertyLabel);
																															
			
		main.setLayout(new GridLayout(1, 3, 0, 0));
		main.setBounds(155,50,250,250);
		choicePanel.setLayout(new GridLayout(0, 2, 0, 0));
		//Adds frames to the window
		getContentPane().add(propertyPanel);
		getContentPane().add(main);
		getContentPane().add(choicePanel);
		
		//Adds 3 choice buttons
		main.add(choiceButton1);
		main.add(choiceButton2);
		main.add(choiceButton3);
		choiceButton1.setText("???");
		choiceButton1.addActionListener(buttonActionListener);
		choiceButton2.setText("???");
		choiceButton2.addActionListener(buttonActionListener);
		choiceButton3.setText("???");
		choiceButton3.addActionListener(buttonActionListener);
			
		 //adds a panel for the first course choice details
		choicePanel.add(choiceDetails1);
		choiceDetails1.add(choiceDetails1a);
		choiceDetails1.add(choiceDetails1b);
		choiceDetails1.setBorder(new TitledBorder(null, "Choice 1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		choiceDetails1.setLayout(new GridLayout(2, 1, 0, 0));
		choiceDetails1a.setLayout(new GridLayout(3, 2, 0, 0));
		choiceDetails1a.add(new JLabel("Name"));
		choiceDetails1a.add(choice1txt1);
		choiceDetails1a.add(new JLabel("Rent Price"));
		choiceDetails1a.add(choice1txt2);
		choiceDetails1.setBackground(Color.white);
		choiceDetails1a.setBackground(Color.white);
		
		choiceDetails1b.setLayout(new GridLayout(1, 1, 0, 0));
		
		//adds a panel for the second course choice details		
		choicePanel.add(choiceDetails2);
		choiceDetails2.add(choiceDetails2a);
		choiceDetails2.add(choiceDetails2b);
		choiceDetails2.setBorder(new TitledBorder(null, "Choice 2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		choiceDetails2.setLayout(new GridLayout(2, 1, 0, 0));
		choiceDetails2a.setLayout(new GridLayout(3, 2, 0, 0));
		choiceDetails2a.add(new JLabel("Name"));
		choiceDetails2a.add(choice2txt1);
		choiceDetails2a.add(new JLabel("Rent Price"));
		choiceDetails2a.add(choice2txt2);
		choiceDetails2.setBackground(Color.white);
		choiceDetails2a.setBackground(Color.white);
		
		choiceDetails2b.setLayout(new GridLayout(1, 1, 0, 0));
		
		//creates select course buttons 
		choiceDetails1b.add(selectHouse1);
		selectHouse1.setText("Select House");
		selectHouse1.addActionListener(select1ActionListener);
		choiceDetails2b.add(selectHouse2);
		selectHouse2.setText("Select House");
		selectHouse2.addActionListener(select2ActionListener);
		
		choice1txt1.setEditable(false);
		choice1txt2.setEditable(false);
		choice2txt1.setEditable(false);
		choice2txt2.setEditable(false);
		setVisible(true);
		
}
	
	ActionListener buttonActionListener = new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			if(buttonPressCount == 1){
				System.out.println("button2 ActionListener Called");
				choice2txt1.setText(GameMechanics.houseList.get(list.get(1)).name);
				choice2txt2.setText(GameMechanics.houseList.get(list.get(1)).rentPrice.toString());
				choiceButton1.setEnabled(false);
				choiceButton2.setEnabled(false);
				choiceButton3.setEnabled(false);	
			}
			if(buttonPressCount == 0){
				System.out.println("button1 ActionListener Called");
				choice1txt1.setText(GameMechanics.houseList.get(list.get(0)).name);
				choice1txt2.setText(GameMechanics.houseList.get(list.get(0)).rentPrice.toString());
				buttonPressCount++;
			}
		}
	};
	
	ActionListener select1ActionListener = new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			if(!(choice1txt1.getText().isEmpty())){
				GameMechanics.playerList.get(playerID).house = GameMechanics.houseList.get(list.get(0));
				GameMechanics.houseList.get(list.get(0)).available = false;
				dispose();	
			}
		}	
				
	};
	
	ActionListener select2ActionListener = new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			if(!(choice2txt1.getText().isEmpty())){
				GameMechanics.playerList.get(playerID).house = GameMechanics.houseList.get(list.get(1));
				GameMechanics.houseList.get(list.get(1)).available = false;
				dispose();	
			}
		}	
				
	};
}