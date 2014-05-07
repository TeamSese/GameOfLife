package com.teamSESE.gameOfLife;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;

public class GamePanel extends JPanel {
	
		BufferedImage counter1;
    
    //ArrayList<Integer> xVal = new ArrayList<Integer>();
    //ArrayList<Integer> yVal = new ArrayList<Integer>();
	
    public GamePanel(){
    	
    	try {
    		
    		counter1 = ImageIO.read(new File("PurpleIcon.png"));
    		
    		Timer timer = new Timer(20, new ActionListener() {
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				
    				if(playerXPos(0) != playerTargetXPos(0)){
    					if(playerXPos(0) < playerTargetXPos(0)){incPlayerXPos(0);}
    					if(playerXPos(0) > playerTargetXPos(0)){decPlayerXPos(0);}
    				}
    				if(playerYPos(0) != playerTargetYPos(0)){
    					if(playerYPos(0) < playerTargetYPos(0)){incPlayerYPos(0);}
    					if(playerYPos(0) > playerTargetYPos(0)){decPlayerYPos(0);}
    				}
    				if(playerXPos(0) == playerTargetXPos(0) && playerYPos(0) == playerTargetYPos(0)){
    					if(playerBoardPos(0) != targetPlayerBoardPos(0)){
    						System.out.println("Incrementing player board position");
    						incPlayerBoardPos(0);
    					}
    				}
    				repaint();
    			}
    		});
    		timer.setRepeats(true);
    		timer.setCoalesce(true);
    		timer.start();
    	} catch (IOException ex) {
    		ex.printStackTrace();
    	}
    }
    
    @Override
	public void paint(Graphics g) {
    	super.paintComponent(g);
    	g.drawImage(counter1,(38 + playerXPos(0)), (38+ playerYPos(0)), this);
    	
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
