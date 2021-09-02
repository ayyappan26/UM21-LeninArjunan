package com.ultramain.collections;

import java.util.ArrayList;


public class ListManager
{
	/**
	 * Created the Class which contains  the devManagerList and mangerList
	 */

	public static void main(String[] args)
	{
		ArrayList<String> devMangerList = new ArrayList<>();// Created the List1
		devMangerList.add("Athiprathapan");
		devMangerList.add("Premalatha");
		devMangerList.add("Tony");
		devMangerList.add("Sivasankari");
		ArrayList<String> managerList = new ArrayList<>();// Created the List2
		managerList.add("Raj");
		managerList.add("Nirmal");
		managerList.add("Rejith");
		managerList.add("Sivasankari");
		System.out.println("Develoment Team Manager's List:\n\n" + devMangerList); 

		managerList.removeAll(devMangerList);
		/**
		 * removed the elements from the list1,
		 */
		System.out.println("\n\nAfter removing the Development Team Manager's from the Managerlist:\n\n"+ managerList);

	}


}