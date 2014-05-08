package com.teamSESE.gameOfLife;

import static org.junit.Assert.*;


import org.junit.*;

public class GameMechanicsTest {


	@Test
	public void testsetUpCourses() {
		GameMechanics.setUpCourses();								//enter courses into array
		int courseListSize = GameMechanics.courseList.size();		//fetch the size of the list
		assertEquals(8, courseListSize);							//make sure it has the right number of values
	}
	
	@Test
	public void testSetUpHouses() {
				
		GameMechanics.setUpHouses();								//enter houses into array
		int houseListSize = GameMechanics.houseList.size();			//fetch the size of the list
		assertEquals(7, houseListSize);								//make sure it has the right number of values
	}

	@Test
	public void testSetUpBoard() {
		
		int j = 0;
		for(int i = 0; i < GameMechanics.tileProperties.length; i=i+3){			//This will create the new tiles as they are in the tileProperties array
			System.out.println(i);
			GameMechanics.tileList.add(new Tile(GameMechanics.tileProperties[i],GameMechanics.tileProperties[i+1],GameMechanics.tileProperties[i+2])); 			//and add them to the tileList ArrayList (the board)
			System.out.println("Tile: " + j + " X: "+GameMechanics.tileList.get(j).gridXPos +" Y: "+ GameMechanics.tileList.get(j).gridYPos);
			j++;
		}
		
		int tileSize = GameMechanics.tileList.size();		//fetch the size of the list
		assertEquals(55, tileSize);							//make sure the list has all eight tiles

	}

	@Test
	public void testDice() {
		Object die = null;						//set object to null
		die = GameMechanics.dice();				//give object a value
		assertNotNull(die);						//check if the object is null
	}

	@Test
	public void testRandomNumber() {
		Object RNG = null;						//set object to null
		int low = 1;
		int high = 20;
		RNG = GameMechanics.randomNumber(low, high);	//give object a value
		assertNotNull(RNG);								//check if the object is null
	}

	

}

