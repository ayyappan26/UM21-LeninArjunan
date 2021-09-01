package com.ultramain.emirates;

public class Emirates
{

	public static void main(String[] args)
	{
		vendor1 myvendor = new vendor1();
		myvendor.vendno();
	}
}
	 class vendor1
	{
		String vendno = "D2016";
		public void vendno()
		{
			System.out.println("vendo no "+ vendno);
		}
		public void vendoraddress()
		{
			System.out.print(" vendoradress = 54 B emirates engineering services, dubai");
		}
		final class vendor2 extends vendor1
		{
			String vendno = "D2016";
			public void vendno()
			{
				System.out.println("vendo no "+ vendno);
			}
			public void vendoraddress()
			{
				System.out.print(" vendoradress = 54 B engineering services two");
		}
	}
	
	}
