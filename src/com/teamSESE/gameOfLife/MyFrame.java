package com.teamSESE.gameOfLife;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame 
{
	
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
      c.setLayout(new FlowLayout());
      
      JPanel welcome = new JPanel();
      JLabel welcomeMessage = new JLabel ("Welcome to the Game of Life");
      welcome.add(welcomeMessage);
      c.add(welcome);
      
      JPanel playerPanel = new JPanel(); 
      playerPanel.setLayout(new GridLayout(1,2));
      playerPanel.add(numOfP);
      playerPanel.add(combo);
      c.add(playerPanel);
      
      JPanel startPanel = new JPanel(); 
      startPanel.setLayout(new GridLayout(2,1));
      start = new JButton();
      start.setText("Start");
      startPanel.add(players);
      startPanel.add(start);
      c.add(startPanel);
      
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
      

      setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      setVisible(true);

  } // MyFrame constructor
	
	//test
	
	

}
