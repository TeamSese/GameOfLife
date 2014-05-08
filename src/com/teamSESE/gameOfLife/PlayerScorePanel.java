package com.teamSESE.gameOfLife;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PlayerScorePanel extends JPanel {
	
	JPanel playerColor;
	JLabel moneyLabel;
	JLabel loanLabel;
	JLabel courseLabel;
	JLabel placementLabel;
	JLabel salaryLabel;
	JLabel houseLabel;
	JLabel rentLabel;
	
	
	
	public PlayerScorePanel(int playerID){
		
		setBorder(new TitledBorder(null, GameMechanics.playerList.get(playerID).name, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		playerColor = new JPanel();
		playerColor.setBackground(GameMechanics.playerList.get(playerID).color);
		add(playerColor);
		moneyLabel = new JLabel("Money - £" + GameMechanics.playerList.get(playerID).money.toString());
		add(moneyLabel);
		loanLabel = new JLabel("Loan - £" + GameMechanics.playerList.get(playerID).loan.toString());
		add(loanLabel);
		courseLabel = new JLabel("Course - " + GameMechanics.playerList.get(playerID).course.name);
		add(courseLabel);
		placementLabel = new JLabel("Placement - " + GameMechanics.playerList.get(playerID).course.placement);
		add(placementLabel);
		salaryLabel = new JLabel("Salary - £" + GameMechanics.playerList.get(playerID).course.currentSalary.toPlainString());
		add(salaryLabel);
		houseLabel = new JLabel("House - " + GameMechanics.playerList.get(playerID).house.name);
		add(houseLabel);
		rentLabel = new JLabel("Rent - £" + GameMechanics.playerList.get(playerID).house.rentPrice.toString());
		add(rentLabel);
		
	}
	public void updatePanel(int playerID){
		setBorder(new TitledBorder(null, GameMechanics.playerList.get(playerID).name, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		playerColor.setBackground(GameMechanics.playerList.get(playerID).color);
		moneyLabel.setText("Money - £" + GameMechanics.playerList.get(playerID).money.toString());
		loanLabel.setText("Loan - £" + GameMechanics.playerList.get(playerID).loan.toString());
		courseLabel.setText("Course - " + GameMechanics.playerList.get(playerID).course.name);
		placementLabel.setText("Placement - " + GameMechanics.playerList.get(playerID).course.placement);
		salaryLabel.setText("Salary - £" + GameMechanics.playerList.get(playerID).course.currentSalary.toPlainString());
		houseLabel.setText("House - " + GameMechanics.playerList.get(playerID).house.name);
		rentLabel.setText("Rent - £" + GameMechanics.playerList.get(playerID).house.rentPrice.toString());
		this.repaint();
	}

}
