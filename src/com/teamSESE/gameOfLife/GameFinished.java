package com.teamSESE.gameOfLife;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameFinished extends JFrame{
	
	public GameFinished()
	{
		setLayout(new GridLayout(GameMechanics.playerList.size(),1));
		setTitle("The Game is Over");															//title is set in main method
		setSize(500, 500);																				// this may need changed but looks ok 
		setLocationRelativeTo(null);
		
		Container c = getContentPane();
		
		for(int i = 0; i < GameMechanics.playerList.size(); i++){
			JLabel temp = new JLabel("Player " + GameMechanics.playerList.get(i).name + " finished with £" + GameMechanics.playerList.get(i).money);
			c.add(temp);
		}
		
		setDefaultCloseOperation(MyFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
