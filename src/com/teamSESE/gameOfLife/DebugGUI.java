package com.teamSESE.gameOfLife;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;

public class DebugGUI extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JLabel lblName;
	private JLabel lblAvailability;
	private JLabel lblBasesalary;
	private JLabel lblCurrentsalary;
	private JLabel lblMaxsalary;
	private JLabel lblNewLabel;
	
	DebugGUI(){
		setTitle("Debugging Window");
		setSize(1024,768);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Players", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Player1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));
		
		textField = new JTextField();
		panel_4.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		panel_4.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		panel_4.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		panel_4.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		panel_4.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		panel_4.add(textField_5);
		textField_5.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Courses", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel_1);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new TitledBorder(null, "Course1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(panel_10);
		panel_10.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblName = new JLabel("Name:");
		panel_10.add(lblName);
		
		textField_6 = new JTextField();
		panel_10.add(textField_6);
		textField_6.setColumns(10);
		
		lblAvailability = new JLabel("Availability:");
		panel_10.add(lblAvailability);
		
		textField_7 = new JTextField();
		panel_10.add(textField_7);
		textField_7.setColumns(10);
		
		lblBasesalary = new JLabel("BaseSalary:");
		panel_10.add(lblBasesalary);
		
		textField_8 = new JTextField();
		panel_10.add(textField_8);
		textField_8.setColumns(10);
		
		lblCurrentsalary = new JLabel("CurrentSalary:");
		panel_10.add(lblCurrentsalary);
		
		textField_9 = new JTextField();
		panel_10.add(textField_9);
		textField_9.setColumns(10);
		
		lblMaxsalary = new JLabel("MaxSalary:");
		panel_10.add(lblMaxsalary);
		
		textField_10 = new JTextField();
		panel_10.add(textField_10);
		textField_10.setColumns(10);
		
		lblNewLabel = new JLabel("Degree Req?");
		panel_10.add(lblNewLabel);
		
		textField_11 = new JTextField();
		panel_10.add(textField_11);
		textField_11.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Houses", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel_2);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Houses1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.add(panel_12);
		panel_12.setLayout(new GridLayout(0, 2, 0, 0));
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		panel_12.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		panel_12.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		panel_12.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		panel_12.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		panel_12.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		panel_12.add(textField_17);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "General Stuff", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel_3);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "General1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.add(panel_11);
		panel_11.setLayout(new GridLayout(0, 2, 0, 0));
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		panel_11.add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		panel_11.add(textField_19);
		
		textField_20 = new JTextField();
		textField_20.setColumns(10);
		panel_11.add(textField_20);
		
		textField_21 = new JTextField();
		textField_21.setColumns(10);
		panel_11.add(textField_21);
		
		textField_22 = new JTextField();
		textField_22.setColumns(10);
		panel_11.add(textField_22);
		
		textField_23 = new JTextField();
		textField_23.setColumns(10);
		panel_11.add(textField_23);
		setVisible(true);
		
		textField_6.setText(GameMechanics.courseList.get(1).name);
		textField_7.setText(GameMechanics.courseList.get(1).available.toString());
		textField_8.setText(GameMechanics.courseList.get(1).baseSalary.toString());
		textField_9.setText(GameMechanics.courseList.get(1).currentSalary.toString());
		textField_10.setText(GameMechanics.courseList.get(1).maxSalary.toString());
		textField_11.setText(GameMechanics.courseList.get(1).degreeRequired.toString());
		
		
	}
	
	

}
