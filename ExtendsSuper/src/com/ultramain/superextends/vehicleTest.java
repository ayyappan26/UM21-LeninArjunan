package com.ultramain.superextends;

 

public class vehicleTest {

 

    public static void main(String[] args) 
    {

        car maruti = new car(); 
        // created new object for the motorbike and class
    }
}
class vehicle// class vehicle created, inside parameterized constructor is created
{
    int speed = 40;
    public vehicle()
    {
        System.out.println("Default");
    }
    public vehicle(String fastBike)
    {

 

        System.out.println("All Motor bikes");
        System.out.println("Fastest bike " + fastBike);

 

    }
}
class motorBike extends vehicle
{
    public motorBike()

 

    {
        super("duke"); 
        //super keyword is a keyword where it call a constructor in the immediate parent class
        //wherever the extends keyword is present by default super method will be added.
        speed = speed +20;

 

        System.out.println("Speed of motor bike duke = "+ speed);    

 

    }
    public motorBike(String fastCar)
    {

 


        System.out.println("Fastest car " + fastCar);

 

    }
}
class car extends motorBike
{
    public car()
    {
        super("maruti"); 
        //super keyword is a keyword where it call a constructor in the immediate parent class
        //wherever the extends keyword is present by default super method will be added.
        speed = speed + 40;
        System.out.println("Speed of car = "+ speed);    

 

    }
}