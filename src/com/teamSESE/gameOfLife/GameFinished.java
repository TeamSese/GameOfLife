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
import javax.swing.ImageIcon;
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
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 498, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
					.addGap(2))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 498, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 135, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
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
			}
		});
		
		panel.add(btnNewButton);
		panel_1.setLayout(new GridLayout(0, 4, 0, 0));
		
		JPanel panel_3 = new JPanel();
		
	ImageIcon gameLogo = new ImageIcon(new ImageIcon(getClass().getResource("GameLogobBlank.png")).getImage().getScaledInstance(360,80, java.awt.Image.SCALE_SMOOTH));
	JLabel logoLabel = new JLabel("", gameLogo, JLabel.CENTER);
	panel_3.setBounds(50, 45, gameLogo.getIconWidth() + 20, gameLogo.getIconHeight() + 20);
	panel_3.setBackground(Color.white);
	panel_3.add(logoLabel);
		
		txtItsGraduationDay = new JLabel("It's Graduation day! Congratulations class of 2014. Here are your results:");
		txtItsGraduationDay.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(txtItsGraduationDay, GroupLayout.PREFERRED_SIZE, 494, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtItsGraduationDay, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(1))
		);
		panel_2.setLayout(gl_panel_2);
		getContentPane().setLayout(groupLayout);
		
//		for(int i = 0; i < GameMechanics.playerList.size(); i++){
//			JLabel temp = new JLabel("Player " + GameMechanics.playerList.get(i).name + " finished with £" + GameMechanics.playerList.get(i).money);
//			c.add(temp);
//		}
		
		setDefaultCloseOperation(MyFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
