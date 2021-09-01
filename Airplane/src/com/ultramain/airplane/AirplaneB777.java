package com.ultramain.airplane;

public class AirplaneB777 
{

	public static void main(String[] args)
	{
		Cabin mycabin = new Cabin(); //same class Reference = same class object
		mycabin.seats(); // Child overrides the parent reference during the compile time itself
		mycabin.oxygenpack(); // child's own method
		mycabin.engine(); // invoking the parent method.
		
		System.out.println("******************************************************************");
		
		Control mycontrol01 =  new Engine01(); // parent reference = child object --> implicit type casting
		mycontrol01.fan(); // child overrides the parent reference during the run time of the program execution
		mycontrol01.fuel(); // parent own methods
		mycontrol01.seats();// parents own methods		
		
		Engine01 myengine01 =  (Engine01) mycontrol01; // explicit casting
		myengine01.engine();
		
		
	}
}
class Control
{
	public void engine()
	{
		System.out.println("Pilot turned ON the Engine 01");
		System.out.println("Pilot turned OFF the Engine 02");
	}
	public void fuel()
	{
		System.out.println("fuellevel meter ll display the fuel level");
	}
	public void seats()
	{
		System.out.println("150 seats not yet filled");
	}
	public void fan()
	{
		System.out.println("engine 1 has fan Control");
	}

}
class Engine01 extends Control
{
	public void fan()
	{
		System.out.println("engine 01 has fan and blades");
	}
}
class Engine02 extends Control{
	public void fan()
	{
		System.out.println("engine 2 has fan");
	}
}
class Fuselage extends Engine01{
	public void fuel()
	{
		System.out.println("fuel level 10000 Litres");
	}

}
class Cabin extends Control{
	public void seats()
	{
		System.out.println("Cabin has 300 seats");
	}
	public void oxygenpack()
	{
		System.out.println("Cabin has only seats with 200 oxygen packs for passengers");
	}
}
class Wing extends Fuselage{
	public void elevator()
	{
		System.out.println("elevator ll increase flight altitude level");
	}
}
class Tail extends Wing{
	public void direction()
	{
		System.out.println("tail ll help to direct the flight");
	}
}