package com.teamSESE.gameOfLife;

import java.math.BigDecimal;
import java.util.ArrayList;

public class GameMechanics {
	
	static ArrayList<Course> courseList = new ArrayList<Course>();
	static ArrayList<House> houseList = new ArrayList<House>();
	
	public static void setUpCourses(){
								//	Name					Available	DegreeReq?		BaseSalary				MaxSalary				CurrentSalary
		courseList.add(new Course("Doctor",					true, 		true, 			new BigDecimal(60000), 	new BigDecimal(100000),	new BigDecimal(60000)));
		courseList.add(new Course("Computer Consultant",	true, 		true, 			new BigDecimal(40000), 	new BigDecimal(70000),	new BigDecimal(40000)));
		//etc...
	}
	
	public static void setUpHouses(){
						//		Name		Available	BuyPrice				SellPrice
		houseList.add(new House("Mansion",	true,		new BigDecimal(600000),	new BigDecimal(700000)));
		houseList.add(new House("Caravan",	true,		new BigDecimal(40000),	new BigDecimal(20000)));
	}
	
	

}
