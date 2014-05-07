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
		BufferedImage counter2;
		BufferedImage counter3;
		BufferedImage counter4;
		BufferedImage counter5;
		BufferedImage counter6;
    
    //ArrayList<Integer> xVal = new ArrayList<Integer>();
    //ArrayList<Integer> yVal = new ArrayList<Integer>();
	
    public GamePanel(){
    	
    	try {
    		
    		counter1 = ImageIO.read(new File("PurpleIcon.png"));
    		counter2 = ImageIO.read(new File("RedIcon.png"));
    		counter3 = ImageIO.read(new File("YellowIcon.png"));
    		counter4 = ImageIO.read(new File("OrangeIcon.png"));
    		counter5 = ImageIO.read(new File("GreenIcon.png"));
    		counter6 = ImageIO.read(new File("RedIcon.png"));
    		
    		
    		Timer timer = new Timer(20, new ActionListener() {
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
    	g.drawImage(counter2,(38 + playerXPos(1)), (38+ playerYPos(1)), this);
    	g.drawImage(counter3,(38 + playerXPos(2)), (38+ playerYPos(2)), this);
    	
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
