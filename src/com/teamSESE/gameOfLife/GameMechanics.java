package com.teamSESE.gameOfLife;

import java.math.BigDecimal;
import java.util.ArrayList;

public class GameMechanics {
	
	static ArrayList<Player> playerList = new ArrayList<Player>();
	static ArrayList<Course> courseList = new ArrayList<Course>();
	static ArrayList<House> houseList = new ArrayList<House>();
	static ArrayList<Tile> tileList = new ArrayList<Tile>();
	
	
	public static void setUpCourses(){
								//	Name		Available	BaseSalary				MaxSalary				CurrentSalary
		
		courseList.add(new Course("SESE",		true, 		new BigDecimal(60000), 	new BigDecimal(100000),	new BigDecimal(60000)));
		courseList.add(new Course("Medicine",	true, 		new BigDecimal(40000), 	new BigDecimal(70000),	new BigDecimal(40000)));
		courseList.add(new Course("Law",		true, 		new BigDecimal(40000), 	new BigDecimal(70000),	new BigDecimal(40000)));
		courseList.add(new Course("Languages",	true, 		new BigDecimal(40000), 	new BigDecimal(70000),	new BigDecimal(40000)));
		courseList.add(new Course("History",	true, 		new BigDecimal(40000), 	new BigDecimal(70000),	new BigDecimal(40000)));
		courseList.add(new Course("Engineering",true,		new BigDecimal(40000), 	new BigDecimal(70000),	new BigDecimal(40000)));
		courseList.add(new Course("Nursing",	true, 		new BigDecimal(40000), 	new BigDecimal(70000),	new BigDecimal(40000)));

	}
	
	public static void setUpHouses(){
						//		Name		Available		Rent
		houseList.add(new House("Elms",			true,		new BigDecimal(40)));
		houseList.add(new House("Holylands",	true,		new BigDecimal(20)));
		houseList.add(new House("Malone Road",	true,		new BigDecimal(40)));
		houseList.add(new House("Lisburn Road",	true,		new BigDecimal(40)));
		houseList.add(new House("Tates Avenue",	true,		new BigDecimal(40)));
		houseList.add(new House("Stran",		true,		new BigDecimal(40)));
		houseList.add(new House("Botanic",		true,		new BigDecimal(40)));
		
	}
	
	public static int dice(){
		return 1 + (int)(6 * Math.random());
	}

}
