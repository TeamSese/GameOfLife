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
    int currentX = 0;
    int currentY = 0;
    int xArrayPos = 0;
    int yArrayPos = 0;
    
    ArrayList<Integer> xVal = new ArrayList<Integer>();
    ArrayList<Integer> yVal = new ArrayList<Integer>();
	
    public GamePanel(){
    	addValuesToArrays();
    	
    	try {
    		
    		counter1 = ImageIO.read(new File("PurpleIcon.png"));
    		
    		Timer timer = new Timer(20, new ActionListener() {
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				if(currentX != xVal.get(xArrayPos)){
    					if(currentX < xVal.get(xArrayPos)){currentX++;}
    					if(currentX > xVal.get(xArrayPos)){currentX--;}
    				}
    				if(currentY != yVal.get(yArrayPos)){
    					if(currentY < yVal.get(yArrayPos)){currentY++;}
    					if(currentY > yVal.get(yArrayPos)){currentY--;}
    				}
    				if(currentX == xVal.get(xArrayPos) && currentY == yVal.get(yArrayPos)){
    					System.out.println("inc array " + xArrayPos + yArrayPos);
    					xArrayPos++;
    					yArrayPos++;		//Advance to next "tile"
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
    private void addValuesToArrays() {
    	xVal.add(0);
    	yVal.add(0);
    	xVal.add(100);
    	yVal.add(0);
    	xVal.add(200);
    	yVal.add(0);
    	xVal.add(200);
    	yVal.add(100);

    	xVal.add(300);
    	yVal.add(0);
    	xVal.add(300);
    	yVal.add(300);
    	xVal.add(0);
    	yVal.add(300);

    }
    /*
        @Override
        public Dimension getPreferredSize() {
            return boat == null ? super.getPreferredSize() : new Dimension(boat.getWidth() * 4, boat.getHeight());
        }
     */
    
    @Override
	public void paint(Graphics g) {
    	super.paintComponent(g);
    	g.drawImage(counter1, currentX, currentY, this);
    	
    }
    


}
