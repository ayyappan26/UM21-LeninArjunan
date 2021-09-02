package com.ultramain.collections;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class UniqueCollection {
	
	public static void main(String[] args)
	{
		/**
		 * Creating string array which contains aircraft parts some of them are duplicate
		 */
		String aircraftParts[]= {"Wings","Wings","Engine","Engine", "Nose","Tail"};
		/**
		 * Converting the string array to array list
		 */
		List<String> aircraftPartList = Arrays.asList(aircraftParts);
		/**
		 * Converting the string array to array list and printed the list
		 */
		System.out.println("Not Unique Parts:\n\n"+ aircraftPartList);
		/**
		 * Sorted the array with collections predefined sort method
		 */
		Collections.sort(aircraftPartList);
		/**
		 * getting the unique sorted array list using HashSet
		 */
		HashSet<String> uniqueParts = new HashSet <String>(aircraftPartList);
		System.out.println("\n\nUnique Parts:\n\n" + uniqueParts);
	}
}
