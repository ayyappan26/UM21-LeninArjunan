package com.ultramain.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.ultramain.dto.EmpDto;
import com.ultramain.sqldbconnection.DbConnection;
public class EmpDao {
	public void viewEmployees() throws SQLException{
		Connection con = DbConnection.getDbConnection();
		System.out.println("Enter the Employee ID to view the details: ");
		Scanner scan = new Scanner(System.in);
		int empId = scan.nextInt();

		String sqlQuery = "Select Employee_ID, First_Name, Last_Name, Salary, Phone_Number, department  FROM employee WHERE EMPLOYEE_ID = " +empId;
		PreparedStatement pst = con.prepareStatement(sqlQuery);
		ResultSet rs = pst.executeQuery();
		String first_name;
		String last_name;
		float salary;
		int phone_Number;
		String department;

		while(rs.next()){
			empId = rs.getInt(1);
			first_name = rs.getString(2);
			last_name = rs.getString(3);
			salary = rs.getFloat(4);
			phone_Number = rs.getInt(5);
			department = rs.getString(6);

			System.out.println("Employee_id : " + empId);
			System.out.println("First Name : " + first_name);
			System.out.println("Last Name : " + last_name);
			System.out.println("Salary : " + salary);
			System.out.println("Mobile : " + phone_Number);
			System.out.println("Department : " +  department);
			System.out.println("----------------------------------");

		}
	}

	/**
	 * @param empDto
	 * @throws SQLException
	 */
	public void registerEmployee(EmpDto empDto) throws SQLException{
		Connection con = DbConnection.getDbConnection();
		String sql = "INSERT INTO employee VALUES (?,?,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, empDto.getEmployeeId());
		pst.setString(2, empDto.getFirstName());
		pst.setString(3, empDto.getLastName());
		pst.setFloat(4, empDto.getSalary());
		pst.setInt(5, empDto.getPhone_number());
		pst.setString(6,empDto.getDepartment());
		int rowsUpdated = pst.executeUpdate();

		System.out.println("Employee Registered Successfully!: " + rowsUpdated);

	}
	public void updateEmployee(EmpDto empDto) throws SQLException{
		
        System.out.println("Type the Employee ID for whom you want to update the details");	
	    Scanner scan = new Scanner(System.in);
        int empId = scan.nextInt(); 
		Connection con = DbConnection.getDbConnection();
		String sql = "Update employees SET SALARY=?"
				+ " WHERE EMPLOYEE_ID =" + empId;
		PreparedStatement pst = con.prepareStatement(sql);
   //   	pst.setInt(1, empDto.getEmployeeId());
		//pst.setString(1, empDto.getFirstName());
       // pst.setString(2, empDto.getLastName());
        pst.setFloat(1, empDto.getSalary());
//        pst.setInt(4, empDto.getPhone_number());
//        pst.setString(5,empDto.getDepartment());
		int rowsUpdated = pst.executeUpdate();
		System.out.println("Employee Details Updated Successfully!: " + rowsUpdated);
	}
}