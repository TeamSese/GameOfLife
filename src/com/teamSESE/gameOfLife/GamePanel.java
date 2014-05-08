package com.teamSESE.gameOfLife;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GamePanel extends JPanel {
	
    public GamePanel(){
    	

    	Timer timer = new Timer(5, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < GameMechanics.playerList.size(); i++){
					if(playerXPos(i) != playerTargetXPos(i)){
						if(playerXPos(i) < playerTargetXPos(i)){incPlayerXPos(i);}
						if(playerXPos(i) > playerTargetXPos(i)){decPlayerXPos(i);}
					}
					if(playerYPos(i) != playerTargetYPos(i)){
						if(playerYPos(i) < playerTargetYPos(i)){incPlayerYPos(i);}
						if(playerYPos(i) > playerTargetYPos(i)){decPlayerYPos(i);}
					}
					if(playerXPos(i) == playerTargetXPos(i) && playerYPos(i) == playerTargetYPos(i)){
						if(playerBoardPos(i) != targetPlayerBoardPos(i)){
							System.out.println("Incrementing player board position");
							incPlayerBoardPos(i);
						}
						for(int j = 0; j < GameMechanics.playerList.size(); j++){
							if(playerBoardPos(j) == targetPlayerBoardPos(j)){
								if(j == (GameMechanics.playerList.size() - 1)){
									GameGUI.rollDice.setEnabled(true);
									GameMechanics.updatePlayerStats();
								}
							}
							else{
								break;
							}
						}
					}
				}
				repaint();
			}
		});
		timer.setRepeats(true);
		timer.setCoalesce(true);
		timer.start();

    }
    
    @Override
	public void paint(Graphics g) {
    	super.paintComponent(g);
    	g.drawImage(GameMechanics.playerList.get(0).playerIcon,(30 + playerXPos(0)), (30+ playerYPos(0)), this);
    	g.drawImage(GameMechanics.playerList.get(1).playerIcon,(34 + playerXPos(1)), (30+ playerYPos(1)), this);
    	if(GameMechanics.playerList.size() > 2){
    		g.drawImage(GameMechanics.playerList.get(2).playerIcon,(38 + playerXPos(2)), (30+ playerYPos(2)), this);
    	}
    	if(GameMechanics.playerList.size() > 3){
    		g.drawImage(GameMechanics.playerList.get(3).playerIcon,(30 + playerXPos(3)), (34+ playerYPos(3)), this);
    	}
    	if(GameMechanics.playerList.size() > 4){
    		g.drawImage(GameMechanics.playerList.get(4).playerIcon,(34 + playerXPos(4)), (34+ playerYPos(4)), this);
    	}
    	if(GameMechanics.playerList.size() > 5){
    		g.drawImage(GameMechanics.playerList.get(5).playerIcon,(38 + playerXPos(5)), (34+ playerYPos(5)), this);
    	}   	
    	
    }
    
    private int playerXPos(int playerID){
    	return GameMechanics.playerList.get(playerID).XPos;
    }
    private int playerYPos(int playerID){
    	return GameMechanics.playerList.get(playerID).YPos;
    }
    
    private void incPlayerXPos(int playerID){
    	GameMechanics.playerList.get(playerID).XPos = (GameMechanics.playerList.get(playerID).XPos +1);
    }
    private void incPlayerYPos(int playerID){
    	GameMechanics.playerList.get(playerID).YPos = (GameMechanics.playerList.get(playerID).YPos +1);
    }
    
    private void decPlayerXPos(int playerID){
    	GameMechanics.playerList.get(playerID).XPos = (GameMechanics.playerList.get(playerID).XPos -1);
    }
    private void decPlayerYPos(int playerID){
    	GameMechanics.playerList.get(playerID).YPos = (GameMechanics.playerList.get(playerID).YPos -1);
    }
    
    private int playerTargetXPos(int playerID){
    	int playerBoardPos = GameMechanics.playerList.get(playerID).boardPosition;
    	//System.out.println("player board pos: " +playerBoardPos);
    	Tile playerTile = GameMechanics.tileList.get(playerBoardPos);
    	//System.out.println("player tile grid x pos: "+playerTile.gridXPos);
    	//System.out.println("player tile x bound: "+GameGUI.squares[playerTile.gridXPos][playerTile.gridYPos].getBounds().x);
    	return GameGUI.squares[playerTile.gridXPos][playerTile.gridYPos].getBounds().x;
    }
    private int playerTargetYPos(int playerID){
    	int playerBoardPos = GameMechanics.playerList.get(playerID).boardPosition;
    	Tile playerTile = GameMechanics.tileList.get(playerBoardPos);
    	return GameGUI.squares[playerTile.gridXPos][playerTile.gridYPos].getBounds().y;
    }
    
	private int playerBoardPos(int i) {
		return GameMechanics.playerList.get(i).boardPosition;
	}
	
	private int targetPlayerBoardPos(int i) {
		return GameMechanics.playerList.get(i).targetBoardPos;
	}
    
	private void incPlayerBoardPos(int i) {
		GameMechanics.playerList.get(i).boardPosition = (GameMechanics.playerList.get(i).boardPosition+1);
	}


}
