package com.teamSESE.gameOfLife;

import java.math.BigDecimal;
import java.util.ArrayList;

public class GameMechanics {
	
	static ArrayList<Course> courseList = new ArrayList<Course>();
	static ArrayList<House> houseList = new ArrayList<House>();
	
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
						//		Name		Available	BuyPrice				SellPrice
		houseList.add(new House("Holylands",	true,		new BigDecimal(20)));
		houseList.add(new House("Malone Road",	true,		new BigDecimal(40)));
		houseList.add(new House("Lisburn Road",	true,		new BigDecimal(40)));
		houseList.add(new House("Tates Avenue",	true,		new BigDecimal(40)));
		houseList.add(new House("Stran",	true,		new BigDecimal(40)));
		houseList.add(new House("Elms",	true,		new BigDecimal(40)));
		houseList.add(new House("Botanic",	true,		new BigDecimal(40)));
		
	}
	
	

}
