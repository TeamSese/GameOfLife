package com.teamSESE.gameOfLife;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.GridLayout;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;

public class DebugGUI extends JFrame{
	
	String playerLabel[] = {"Name","Colour","Money","Loan","Course","House","Board Position:"};
	String courseLabel[] = {"Name","available", "baseSalary", "maxSalary","currentSalary"};
	String houseLabel[] =  {"Name", "Available", "Rent"};
	
	private ArrayList<JTextField> playertfArray = new ArrayList<JTextField>();
	ArrayList<JLabel> playerlblArray = new ArrayList<JLabel>();
	ArrayList<JPanel> playerpnlArray = new ArrayList<JPanel>();
	
	ArrayList<JTextField> coursetfArray = new ArrayList<JTextField>();
	ArrayList<JLabel> courselblArray = new ArrayList<JLabel>();
	ArrayList<JPanel> coursepnlArray = new ArrayList<JPanel>();
	
	ArrayList<JTextField> housetfArray = new ArrayList<JTextField>();
	ArrayList<JLabel> houselblArray = new ArrayList<JLabel>();
	ArrayList<JPanel> housepnlArray = new ArrayList<JPanel>();
	

	DebugGUI(){
		setTitle("Debugging Window");
		setSize(1024,768);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		//********************	Players Panel
		JPanel playersPanel = new JPanel();
		playersPanel.setBorder(new TitledBorder(null, "Players", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(playersPanel);
		
		for(int i = 0, k = 0; i < GameMechanics.playerList.size(); i++){
			playerpnlArray.add(new JPanel());
			playerpnlArray.get(i).setLayout(new GridLayout(0, 2, 0, 0));
			playerpnlArray.get(i).setBorder(new TitledBorder(null, "Player: " + i, TitledBorder.LEADING, TitledBorder.TOP, null, null));
			
			for (int j =0; j < playerLabel.length; j++){
				playerlblArray.add(new JLabel(playerLabel[j]));
				playertfArray.add(new JTextField());
				playertfArray.get(k).setColumns(10);
				
				playerpnlArray.get(i).add(playerlblArray.get(k));
				playerpnlArray.get(i).add(playertfArray.get(k));
				k++;
			}
			playersPanel.add(playerpnlArray.get(i));
		}
		
		//********************	Courses Panel
		
		JPanel coursesPanel = new JPanel();
		coursesPanel.setBorder(new TitledBorder(null, "Courses", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(coursesPanel);
		for(int i = 0, k = 0; i < GameMechanics.courseList.size(); i++){
			coursepnlArray.add(new JPanel());
			coursepnlArray.get(i).setLayout(new GridLayout(0, 2, 0, 0));
			coursepnlArray.get(i).setBorder(new TitledBorder(null, "Course: " + i, TitledBorder.LEADING, TitledBorder.TOP, null, null));
			
			for (int j =0; j < courseLabel.length; j++){
				courselblArray.add(new JLabel(courseLabel[j]));
				coursetfArray.add(new JTextField());
				coursetfArray.get(k).setColumns(10);
				
				coursepnlArray.get(i).add(courselblArray.get(k));
				coursepnlArray.get(i).add(coursetfArray.get(k));
				k++;
			}
			coursesPanel.add(coursepnlArray.get(i));
		}
		
		//********************	Houses Panel
		
		JPanel housesPanel = new JPanel();
		housesPanel.setBorder(new TitledBorder(null, "Houses", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(housesPanel);
		
		for(int i = 0, k = 0; i < GameMechanics.houseList.size(); i++){
			housepnlArray.add(new JPanel());
			housepnlArray.get(i).setLayout(new GridLayout(0, 2, 0, 0));
			housepnlArray.get(i).setBorder(new TitledBorder(null, "house: " + i, TitledBorder.LEADING, TitledBorder.TOP, null, null));
			
			for (int j =0; j < houseLabel.length; j++){
				houselblArray.add(new JLabel(houseLabel[j]));
				housetfArray.add(new JTextField());
				housetfArray.get(k).setColumns(10);
				
				housepnlArray.get(i).add(houselblArray.get(k));
				housepnlArray.get(i).add(housetfArray.get(k));
				k++;
			}
			housesPanel.add(housepnlArray.get(i));
		}
		
		//********************	General Panel
		
		JPanel generalPanel = new JPanel();
		generalPanel.setBorder(new TitledBorder(null, "General Stuff", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(generalPanel);
		
		updateDebugGUI();
		setVisible(true);
		
	}
	
	void updateDebugGUI(){
		int k = 0;
		for(int i = 0; i < GameMechanics.playerList.size();i++){
			playertfArray.get(k).setText(GameMechanics.playerList.get(i).name);k++;
			playertfArray.get(k).setBackground(GameMechanics.playerList.get(i).color);k++;
			playertfArray.get(k).setText(GameMechanics.playerList.get(i).money.toString());k++;
			playertfArray.get(k).setText(GameMechanics.playerList.get(i).loan.toString());k++;
			
			/*playertfArray.get(k).setText(GameMechanics.playerList.get(i).course.name);*/k++;
			playertfArray.get(k).setText(GameMechanics.playerList.get(i).house.name);k++;
			playertfArray.get(k).setText(Integer.toString(GameMechanics.playerList.get(i).boardPosition));k++;
		}
		
		k = 0;
		for(int i = 0; i < GameMechanics.courseList.size();i++){
			coursetfArray.get(k).setText(GameMechanics.courseList.get(i).name);k++;
			coursetfArray.get(k).setText(GameMechanics.courseList.get(i).available.toString())
			;k++;
			coursetfArray.get(k).setText(GameMechanics.courseList.get(i).maxSalary.toString());k++;
			coursetfArray.get(k).setText(GameMechanics.courseList.get(i).currentSalary.toString());k++;
			coursetfArray.get(k).setText(GameMechanics.courseList.get(i).baseSalary.toString());k++;

		}
		
		k = 0;
		for(int i = 0; i < GameMechanics.houseList.size();i++){
			housetfArray.get(k).setText(GameMechanics.houseList.get(i).name);k++;
			housetfArray.get(k).setText(GameMechanics.houseList.get(i).available.toString());k++;
			housetfArray.get(k).setText(GameMechanics.houseList.get(i).rentPrice.toString());k++;
		}
		/*
		textField_6.setText(GameMechanics.courseList.get(1).name);
		textField_7.setText(GameMechanics.courseList.get(1).available.toString());
		textField_8.setText(GameMechanics.courseList.get(1).baseSalary.toString());
		textField_9.setText(GameMechanics.courseList.get(1).currentSalary.toString());
		textField_10.setText(GameMechanics.courseList.get(1).maxSalary.toString());*/
	}
	
}
