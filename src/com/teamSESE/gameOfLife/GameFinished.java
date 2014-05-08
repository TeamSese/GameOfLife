package com.teamSESE.gameOfLife;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameFinished extends JFrame{
	JLabel values[][] = new JLabel[7][4];
	private JLabel txtItsGraduationDay;
	ArrayList<Player> playerArray = new ArrayList<Player>();
	ArrayList<String> gradeArray = new ArrayList<String>(); 
	
	public GameFinished()
	{
		setTitle("The Game is Over");															//title is set in main method
		setSize(500, 500);																				// this may need changed but looks ok 
		setLocationRelativeTo(null);
		setResizable(false);
		
		Container c = getContentPane();
		c.setBackground(Color.white);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.white);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.white);
		
		gradeArray.add("1.1");
		gradeArray.add("2.1");
		gradeArray.add("2.2");
		gradeArray.add("Third");
		gradeArray.add("Fail");
		gradeArray.add("Dropped Out");
		
		for(int i = 0; i < GameMechanics.playerList.size(); i++){
			playerArray.add(GameMechanics.playerList.get(i));
		}
		
		Collections.sort(playerArray, new Comparator<Player>() {
      @Override
      public int compare(Player p1, Player p2)
      {
          return  (p2.finalMoney()).compareTo(p1.finalMoney());
      }
  });
		
		for (int x= 0; x<=playerArray.size(); x++)
		{
			for (int y= 0; y<4; y++)
			{

				if (x == 0)
				{
					switch(y){
					case 0:{values[x][y] = new JLabel("  #");break;}
					case 1:{values[x][y] = new JLabel("  Name");break;}
					case 2:{values[x][y] = new JLabel("  £");break;}
					case 3:{values[x][y] = new JLabel("  Grade");break;}
					}
				}

				else{
					switch(y){
					case 0:{values[x][y] = new JLabel("  " + x);break;}
					case 1:{values[x][y] = new JLabel("  " + playerArray.get(x-1).name);break;}
					case 2:{values[x][y] = new JLabel("  " + playerArray.get(x-1).finalMoney());break;}
					case 3:{values[x][y] = new JLabel("  " + gradeArray.get(x-1));break;}
					}
				}

				panel_1.add(values[x][y]);
			}
		}
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 498, Short.MAX_VALUE))
					.addGap(2))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(1))
		);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.setBackground(Color.white);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				System.gc();  
				java.awt.Window win[] = java.awt.Window.getWindows();   
				for(int i=0;i<win.length;i++){   
					win[i].dispose();   
					win[i]=null;  
				} 

				MyFrame f1 = new MyFrame("Game Of Life", Color.lightGray);
			}
		});
		
		panel.add(btnNewButton);
		panel_1.setLayout(new GridLayout(0, 4, 0, 0));
		
		txtItsGraduationDay = new JLabel("It's Graduation day! Congratulations class of 2014. Here are your results:");
		txtItsGraduationDay.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(txtItsGraduationDay);
		getContentPane().setLayout(groupLayout);
		
//		for(int i = 0; i < GameMechanics.playerList.size(); i++){
//			JLabel temp = new JLabel("Player " + GameMechanics.playerList.get(i).name + " finished with £" + GameMechanics.playerList.get(i).money);
//			c.add(temp);
//		}
		
		setDefaultCloseOperation(MyFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
