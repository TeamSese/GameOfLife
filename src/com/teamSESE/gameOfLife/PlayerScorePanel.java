package com.teamSESE.gameOfLife;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerScorePanel extends JPanel {
	
	JLabel moneyLabel;
	JLabel loanLabel;
	JLabel courseLabel;
	JLabel placementLabel;
	JLabel salaryLabel;
	JLabel houseLabel;
	JLabel rentLabel;
	
	
	
	public PlayerScorePanel(int playerID){
		
		moneyLabel = new JLabel("Money - £" + GameMechanics.playerList.get(playerID).money.toString());
		add(moneyLabel);
		loanLabel = new JLabel("Loan - £" + GameMechanics.playerList.get(playerID).loan.toString());
		add(loanLabel);
		courseLabel = new JLabel("Course - " + GameMechanics.playerList.get(playerID).course.name);
		add(courseLabel);
		salaryLabel = new JLabel("Salary - £" + GameMechanics.playerList.get(playerID).course.salary.toPlainString());
		add(salaryLabel);
		houseLabel = new JLabel("House - " + GameMechanics.playerList.get(playerID).house.name);
		add(houseLabel);
		rentLabel = new JLabel("Rent - £" + GameMechanics.playerList.get(playerID).house.rentPrice.toString());
		add(rentLabel);
		
	}
	public void updatePanel(int playerID){
		moneyLabel.setText("Money - £" + GameMechanics.playerList.get(playerID).money.toString());
		loanLabel.setText("Loan - £" + GameMechanics.playerList.get(playerID).loan.toString());
		courseLabel.setText("Course - " + GameMechanics.playerList.get(playerID).course.name);
		salaryLabel.setText("Potential Salary - £" + GameMechanics.playerList.get(playerID).course.salary.toPlainString());
		houseLabel.setText("House - " + GameMechanics.playerList.get(playerID).house.name);
		rentLabel.setText("Rent - £" + GameMechanics.playerList.get(playerID).house.rentPrice.toString());
		this.repaint();
	}

}
