package com.teamSESE.gameOfLife;

import javax.swing.ButtonGroup;
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


public class SelectCourseGUI extends JFrame{
	JPanel panel_1 = new JPanel();
	JTextField txt1 = new JTextField();
	JTextField txt2 = new JTextField();
	JTextField txt3 = new JTextField();
	JTextField txt4 = new JTextField();
	JTextField txt5 = new JTextField();
	JTextField txt6 = new JTextField();
	int buttonPressCount = 0;
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	List<Integer> list = new ArrayList<Integer>();
	int playerPos;
	
	SelectCourseGUI(int playerPosition){
		playerPos = playerPosition;
		setTitle("Select Course");
		setSize(500,352);
		getContentPane().setLayout(new GridLayout(0,1));
		
		JPanel welcome = new JPanel();																		//wecome to the game message to display at top of box
		welcome.setBounds(155, 5, 190, 26);																	// location
		JLabel welcomeMessage = new JLabel ("Player " + playerPosition + " choose 2 career cards"); 		//message
		welcome.add(welcomeMessage);																		//add to panel
		getContentPane().add(welcome);													
		JPanel main = new JPanel();
		main.setLayout(new FlowLayout());
		main.setBounds(155,50,250,250);
		JPanel details1 = new JPanel();
		details1.setLayout(new FlowLayout());
		JPanel details2 = new JPanel();
		details2.setLayout(new FlowLayout());

		button1.setText("???");
		button1.addActionListener(buttonActionListener);
		button2.setText("???");
		button2.addActionListener(buttonActionListener);
		button3.setText("???");
		button3.addActionListener(buttonActionListener);
		
		main.add(button1);
		main.add(button2);
		main.add(button3);
		getContentPane().add(main);
		JPanel panel = new JPanel();
		panel.setMinimumSize(new Dimension(10, 20));
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
			
		panel.add(panel_1);
		panel_1.setBorder(new TitledBorder(null, "Choice 1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setLayout(new GridLayout(5, 2, 0, 0));
		panel_1.add(new JLabel("Name"));
		panel_1.add(txt1);
		panel_1.add(new JLabel("Base Salary"));
		panel_1.add(txt2);
		panel_1.add(new JLabel("Max Salary"));
		panel_1.add(txt3);
		JButton select1 = new JButton();
		select1.setText("Select Course");
		panel_1.add(select1);
		select1.addActionListener(select1ActionListener);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setBorder(new TitledBorder(null, "Choice 2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setLayout(new GridLayout(5, 2, 0, 0));
		panel_2.add(new JLabel("Name"));
		panel_2.add(txt4);
		panel_2.add(new JLabel("Base Salary"));
		panel_2.add(txt5);
		panel_2.add(new JLabel("Max Salary"));
		panel_2.add(txt6);
		JButton select2 = new JButton();
		select2.setText("Select Course");
		panel_2.add(select2);
		select2.addActionListener(select2ActionListener);
		
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);			//close when closed
		setVisible(true);
		
		for(int i=0; i<GameMechanics.courseList.size(); i++){
			if(GameMechanics.courseList.get(i).available){
				list.add(i);		
			}
		}
		Collections.shuffle(list);
		
		
	}
	
	ActionListener buttonActionListener = new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			if(buttonPressCount == 1){
				System.out.println("button2 ActionListener Called");
				txt4.setText(GameMechanics.courseList.get(list.get(1)).name);
				txt5.setText(GameMechanics.courseList.get(list.get(1)).baseSalary.toString());
				txt6.setText(GameMechanics.courseList.get(list.get(1)).maxSalary.toString());
				button1.setEnabled(false);
				button2.setEnabled(false);
				button3.setEnabled(false);	
			}
			if(buttonPressCount == 0){
				System.out.println("button1 ActionListener Called");
				txt1.setText(GameMechanics.courseList.get(list.get(0)).name);
				txt2.setText(GameMechanics.courseList.get(list.get(0)).baseSalary.toString());
				txt3.setText(GameMechanics.courseList.get(list.get(0)).maxSalary.toString());
				buttonPressCount++;
			}
		}
				
	};
	
	ActionListener select1ActionListener = new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			System.out.println(GameMechanics.playerList.get(playerPos).name);
			GameMechanics.playerList.get(playerPos).course.equals(GameMechanics.courseList.get(list.get(0)));
			System.out.println(GameMechanics.playerList.get(playerPos).course.name);
			dispose();
		}	
				
	};
	
	ActionListener select2ActionListener = new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			System.out.println(GameMechanics.playerList.get(playerPos).course.name);
			GameMechanics.playerList.get(playerPos).course.equals(GameMechanics.courseList.get(list.get(1)));
			dispose();
		}	
				
	};
}