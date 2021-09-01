package com.ultramain.company;

public class InheritanceActivity
{
	public static void main(String[] args)
	{
		Manager mymanager = new Manager(126534l, "Peter", "Chennai India", 237844l, 65000);// object of manager class > calling the overloaded constructor with parameters
		mymanager.calculateSalary(); //invoked calculate salary method for the manager, calculated salary for the manager will be printed in the console
		mymanager.calculateTransportAllowance();
		System.out.println("-----------------------------------------------------");
		Trainee mytrainee = new Trainee(29846l, "Jack", "Mumbai India", 442085l, 45000);
		mytrainee.calculateSalary();//invoked calculate salary method for the trainee, calculated salary for the trainee will be printed in the console
		mytrainee.calculateTransportAllowance();
		System.out.println("-----------------------------------------------------");
        

	}
}

class Employee
{

	public long employeeID;
	public String employeeName;
	public String employeeAddress;
	public long employeePhone;
	public double basicSalary;
	final double  specialAllowance = 250.80;
	final double Hra = 1000.50;

	public void calculateSalary()
	{
		double salary; // Salary local variable
		salary = basicSalary + (basicSalary * specialAllowance / 100) + (basicSalary * Hra / 100);
		System.out.println("Calculated Salary    = "+salary);
	}
	public void calculateTransportAllowance()
	{
		double transportAllowance;
		transportAllowance = 15 * basicSalary / 100;
		System.out.println("Tansport Allowance   = "+transportAllowance);
	}
	
}
class Manager extends Employee // created class Manager and overloaded the constructors with parameters
{

	Manager() {

	}

	Manager(long id, String Name, String address, long phone, double salary) 
	{
		employeeID = id;
		employeeName = Name;
		employeeAddress = address;
		employeePhone = phone;
		basicSalary = salary;

		System.out.println("Manager ID           = " + employeeID);
		System.out.println("Manager Name         = " + employeeName);
		System.out.println("Manager address      = " + employeeAddress);
		System.out.println("Manager Phone        = " + employeePhone);
		System.out.println("Manager Salary       = " + basicSalary);
	}
}
	class Trainee extends Employee // created class trainee and overloaded the constructors with parameters
	{

		Trainee() {

		}

		Trainee(long id, String Name, String address, long phone, double salary) {
			employeeID = id;
			employeeName = Name;
			employeeAddress = address;
			employeePhone = phone;
			basicSalary = salary;

			System.out.println("Trainee ID           = " + employeeID);
			System.out.println("Trainee Name         = " + employeeName);
			System.out.println("Trainee address      = " + employeeAddress);
			System.out.println("Trainee phone        = " + employeePhone);
			System.out.println("Trainee salary       = " + basicSalary);
		}
	}


