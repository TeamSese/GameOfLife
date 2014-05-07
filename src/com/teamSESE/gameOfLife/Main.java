package com.teamSESE.gameOfLife;

import java.awt.*;

public class Main {


	public static void main(String[] args) {
		
		MyFrame f1 = new MyFrame("Game Of Life", Color.lightGray);	//Selects number of Players	
		
		GameMechanics.setUpCourses();
		GameMechanics.setUpHouses();
		GameMechanics.setUpBoard();
<<<<<<< HEAD
=======
		
		MyFrame f1 = new MyFrame("Game Of Life", Color.lightGray);	//Selects number of Players	
>>>>>>> 43210f040778c9b3a960638a803f2ffd228dc489
	}

}
