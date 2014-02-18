package com.teamSESE.gameOfLife;

import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame 
{
	
	JButton start;
	
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
      c.add(start);

      setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      setVisible(true);

  } // MyFrame constructor
	
	
	
	

}
