package com.ultramain.exceptionhandling;

public class AccountBalance
{
	public static void main(String[] args)
	{
		try
		{
			int a = 5/0;
		
		}
		catch(ArithmeticException a)
		{
			System.out.println("Arithmetic exception caught here" + a.getMessage());
		}
		finally 
		{
		 System.out.println("Finally");
		}
	}
}
