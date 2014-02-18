package com.teamSESE.gameOfLife;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame 
{
	//blah blah blah test test test
	JButton start;
	String items[] = {"-","1","2","3","4","5","6"};
	JComboBox combo = new JComboBox(items);
	JLabel numOfP = new JLabel("Select Number Of Players");
	JTextField players = new JTextField(20);
	
	public MyFrame(String title, Color col)
  {
      setTitle(title);
      setSize(500, 500);
      setLocationRelativeTo(null);

      Container c = getContentPane();
      c.setBackground(col);
      getContentPane().setLayout(null);
      
      JPanel welcome = new JPanel();
      welcome.setBounds(155, 5, 190, 26);
      JLabel welcomeMessage = new JLabel ("Welcome to the Game of Life");
      welcome.add(welcomeMessage);
      c.add(welcome);
      
      JPanel playerPanel = new JPanel(); 
      playerPanel.setBounds(92, 225, 316, 27);
      playerPanel.setLayout(new GridLayout(1,2));
      c.add(playerPanel);
      playerPanel.add(numOfP);
      playerPanel.add(combo);
      
      combo.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent ie){
     
       if(ie.getStateChange() == ItemEvent.SELECTED){
        String str = (String)combo.getSelectedItem();
        
        
        
        if(str=="1"){
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
       }

       }
        
      }
      
      );
      
      JPanel startPanel = new JPanel(); 
      startPanel.setBounds(123, 264, 254, 58);
      startPanel.setLayout(new GridLayout(2,1));
      c.add(startPanel);
      startPanel.add(players);
      start = new JButton();
      start.setBounds(123, 348, 254, 29);
      getContentPane().add(start);
      start.setText("Start");
      
      JButton btnHelp = new JButton("Help");
      btnHelp.setBounds(191, 399, 117, 29);
      getContentPane().add(btnHelp);
      

      setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      setVisible(true);

  } // MyFrame constructor
}
