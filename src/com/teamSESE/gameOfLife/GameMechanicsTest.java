package com.teamSESE.gameOfLife;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.*;

public class GameMechanicsTest {


	@Test
	public void testsetUpCourses() {
		ArrayList<Course> courseList = new ArrayList<Course>();																				//set up course list array
		Course j = (new Course("SESE","Job",		true, 		new BigDecimal(60000), 	new BigDecimal(100000),	new BigDecimal(60000)));	//
		courseList.add(j);																													//enter a course into the array
		Course i = courseList.get(0);																										//fetch the course out of the array
		assertSame(i, j);																													//make sure the courses are still the same
	}
	
	@Test
	public void testSetUpHouses() {
		
		ArrayList<House> houseList = new ArrayList<House>();			//set up house list array				
		House house1 = new House("Elms", false, new BigDecimal(40));	//
		houseList.add(house1);											//add a house to the array
		int houseSize = houseList.size();								//fetch the size of the list
		assertEquals(1, houseSize);										//make sure it has a single value
	}

	@Test
	public void testSetUpBoard() {
		int tileProperties[] = {			//define some tiles
				Tile.SELECT_COURSE,3,4,		//0
				Tile.GAIN_200,2,4,			//1
				Tile.PAY_DAY,1,4,			//2
				Tile.MISS_TURN,0,4,			//3
				Tile.MISS_TURN,0,3,			//4
				Tile.MISS_TURN,0,2,			//5
				Tile.MISS_TURN,1,2,			//6
				Tile.FINISH,1,1,			//7
		};
		
		ArrayList<Tile> tileList = new ArrayList<Tile>();	//set up tile array list
		
		int j = 0;
		for(int i = 0; i < tileProperties.length; i=i+3){			//This will create the new tiles as they are in the tileProperties array
			System.out.println(i);
			tileList.add(new Tile(tileProperties[i],tileProperties[i+1],tileProperties[i+2])); 			//and add them to the tileList ArrayList (the board)
			System.out.println("Tile: " + j + " X: "+tileList.get(j).gridXPos +" Y: "+ tileList.get(j).gridYPos);
			j++;
		}
		int tileSize = tileList.size();		//fetch the size of the list
		assertEquals(8, tileSize);			//make sure the list has all eight tiles
	}

	@Test
	public void testDice() {
		
		Object die = null;						//set object to null
		die = 1 + (int)(6 * Math.random());		//give object a value
		assertNotNull(die);						//check if the object is null
	}

	@Test
	public void testRandomNumber() {
		Object RNG = null;						//set object to null
		int low = 1;
		int high = 20;
		RNG = low + (int)(high * Math.random());//give object a value
		assertNotNull(RNG);						//check if the object is null
	}

	

}

