package com.teamSESE.gameOfLife;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame 
{
	
	JButton start;
	String items[] = {"-","1","2","3","4"};
	JComboBox combo = new JComboBox(items);
	JLabel numOfP = new JLabel("Select Number Of Players");
	JTextField players = new JTextField(20);
	
	public MyFrame(int x, int y, String title, Color col)
  {
      setTitle(title);
      setSize(500, 500);
      setLocation(x, y);

      Container c = getContentPane();
      c.setBackground(col);
      c.setLayout(new FlowLayout());
      
      start = new JButton();
      start.setText("Start");
      c.add(numOfP);
      c.add(combo);
      c.add(start);
      c.add(players);
      
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
       }

       }
        
      }
      
      );
      

      setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      setVisible(true);

  } // MyFrame constructor
	
	
	
	

}
