package com.ultramain.collections;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CarList {
	public static void main(String[] args) {
		//Creating string array of elements
		String carList[]= {"Benz", "Audi","Viper", "Polo","Tata","Toyota"}; 
		//Converting String array to list
		List<String> carList1 = Arrays.asList(carList);
		System.out.println("Before Sorting:\n\n"+ carList1+ "\n" );
		// Sorting ArrayList in ascending Order
		Collections.sort(carList1); 
		// printing the sorted ArrayList   
		System.out.println("After Sorting:\n\n"+ carList1);
	}   
} 	
