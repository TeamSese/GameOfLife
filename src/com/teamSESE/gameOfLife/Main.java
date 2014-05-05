package com.teamSESE.gameOfLife;

import java.awt.*;

public class Main {


	public static void main(String[] args) {
		
		
		GameMechanics.setUpCourses();
		GameMechanics.setUpHouses();
		GameMechanics.setUpBoard();
		
		
		MyFrame f1 = new MyFrame("Game Of Life", Color.lightGray);	//Selects number of Players	
	}

}
