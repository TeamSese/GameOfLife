package com.teamSESE.gameOfLife;

import java.awt.*;

public class Main {

	public static void main(String[] args) {
		
		
		GameMechanics.setUpCourses();
		//GameMechanics.setUpHouses();
		//MyFrame f1 = new MyFrame("Game Of Life", Color.lightGray);	//Selects number of Players
		SelectCourseGUI test = new SelectCourseGUI(1);
	}

}
