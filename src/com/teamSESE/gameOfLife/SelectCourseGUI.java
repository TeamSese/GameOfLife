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
	
	SelectCourseGUI(int playerPosition){
		
		//System.out.print(list.get(2));
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
		
		
		
		JButton button1 = new JButton();
		button1.setText("1");
		button1.addActionListener(button1ActionListener);
		JButton button2 = new JButton();
		button2.setText("2");
		//button2.addActionListener(button2ActionListener);
		JButton button3 = new JButton();
		button3.setText("3");
		//button3.addActionListener(button3ActionListener);
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
		
		
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setBorder(new TitledBorder(null, "Choice 2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setLayout(new GridLayout(5, 2, 0, 0));
		panel_2.add(new JLabel("Name"));
		panel_2.add(new JTextField());
		panel_2.add(new JLabel("Base Salary"));
		panel_2.add(new JTextField());
		panel_2.add(new JLabel("Max Salary"));
		panel_2.add(new JTextField());
		JButton select2 = new JButton();
		select2.setText("Select Course");
		panel_2.add(select2);
		
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);			//close when closed
		setVisible(true);
		
		
	}
	
	ActionListener button1ActionListener = new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			List<Integer> list = Arrays.asList(0,1,2,3,4,5,6);
			Collections.shuffle(list);
			System.out.println("button1 ActionListener Called");
			if(GameMechanics.courseList.get(list.get(1)).available){
				txt1.setText(GameMechanics.courseList.get(list.get(1)).name);
				System.out.println(GameMechanics.courseList.get(list.get(1)).name);
				System.out.println("Course Available");
			}
			else{
				System.out.println(GameMechanics.courseList.get(list.get(1)).name);
			}
				
			}
			
				
	};
}
