package com.ultramain.bo;

import java.sql.SQLException;
import java.util.Scanner;

import com.ultramain.dao.EmpDao;
import com.ultramain.dto.EmpDto;

import com.ultramain.util.Scan1;

public class Business {
	public void empSystem(){
		int choice = 0;
		Scanner scan = Scan1.getScannerInstance();
		EmpDao dao = new EmpDao();
		do{
			System.out.println("1. View Employee                          >");
			System.out.println("\n2. Register Employee                    >");
			System.out.println("\n3. Update Existing Employee Details     >");
			System.out.println("\n4. Delete Existing Employee Details     >\n Note: Delete option ll permanently delete the details from the Employee table");
			System.out.println("\n5. View Employee details by Department  >");
			System.out.println("\n6. Exit ");
			System.out.println("\nEnter your choice: ");
			choice = scan.nextInt();
		}while(choice ==0);
		
		switch(choice){
		case 1:
			viewEmployees(dao);
			break;
		case 2:
			registerEmployee(dao);
			break;
		case 3:
			updateEmployee(dao);
			break;
	    case 4:
          deleteEmployee(dao);
          break;      
         case 5:
        	 viewEmployeesByDept(dao);
		case 6:
			return;
			
		}
	}
	

	public void viewEmployees(EmpDao dao){
		try {
			dao.viewEmployees();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	public void viewEmployeesByDept(EmpDao dao){
		try {
			dao.viewEmployeesByDept();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	public void registerEmployee(EmpDao dao){
		EmpDto empDto = getEmpDetails();
		try {
			dao.registerEmployee(empDto);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	public void updateEmployee(EmpDao dao)
	{
		EmpDto empDto = getEmpDetails();
		try {
			dao.updateEmployee(empDto);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	

	 public void deleteEmployee(EmpDao dao)
	 { 
		 try 
		 { dao.deleteEmployee(); 
		 } catch (SQLException e) 
		 { System.out.println(e.getMessage());
	 
		 }
	 }
	 
	public EmpDto getEmpDetails(){
		Scanner scan = Scan1.getScannerInstance();
		EmpDto empDto = new EmpDto();
		System.out.println("Enter Employee Id: ");
		empDto.setEmployeeId(scan.nextInt());
		System.out.println("Enter First Name : ");
		empDto.setFirstName(scan.next());
		System.out.println("Enter Last Name : ");
		empDto.setLastName(scan.next());
		System.out.println("Enter Salary : ");
		empDto.setSalary(scan.nextFloat());
		System.out.println("Enter Phone Number : ");
		empDto.setPhone_number(scan.nextInt());
		System.out.println("Enter Department : ");
		empDto.setDepartment(scan.next());
		return empDto;	
	
	}
}