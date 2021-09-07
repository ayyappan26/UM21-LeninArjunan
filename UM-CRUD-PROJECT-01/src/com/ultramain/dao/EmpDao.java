package com.ultramain.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.ultramain.dto.EmpDto;
import com.ultramain.sqldbconnection.DbConnection;
public class EmpDao {
	/**
	 * View Employee Class to view the Employees in the EMPLOYEE table
	 */
	public void viewEmployees() throws SQLException{
		Connection con = DbConnection.getDbConnection();
		System.out.println("Enter the Employee ID to view the details: ");
		Scanner scan = new Scanner(System.in);
		int empId = scan.nextInt();

		String sqlQuery = "Select Employee_ID, First_Name, Last_Name, Salary, Phone_Number, department  "
				+ "FROM employee WHERE EMPLOYEE_ID = " +empId;
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
	 * Views the employee details based on the Department ID given by the user.
	 * 
	 * @throws SQLException
	 */
	public void viewEmployeesByDept() throws SQLException {
		Connection con = DbConnection.getDbConnection();
		System.out.println("Enter the Department ID to view the details: ");
		Scanner scan = new Scanner(System.in);
		String dept = scan.next();
		String sqlQuery = "Select Employee_ID, First_Name, Last_Name, Salary, Phone_Number, Department "
				           + "FROM employee";
		PreparedStatement pst = con.prepareStatement(sqlQuery);
		ResultSet rs = pst.executeQuery();
		
		HashMap<String, List<EmpDto>>  empDetailsMap = new HashMap<String, List<EmpDto>>();
		List<EmpDto> empDtoList = new ArrayList<EmpDto>();
		while (rs.next()) {
			EmpDto empDto = new EmpDto();
			empDto.setEmployeeId(rs.getInt(1));
			empDto.setFirstName(rs.getString(2));
			empDto.setLastName(rs.getString(3));
			empDto.setSalary(rs.getInt(4));
			empDto.setPhone_number(rs.getInt(5));
			empDto.setDepartment(rs.getString(6).toUpperCase());

			empDtoList = empDetailsMap.get(empDto.getDepartment().toUpperCase());
			if (empDtoList == null || empDtoList.isEmpty()) {
				empDtoList = new ArrayList<EmpDto>();
				empDetailsMap.put(empDto.getDepartment().toUpperCase(), empDtoList);
			}
			empDtoList.add(empDto);
		}
		List<EmpDto> empDtoListByDept = empDetailsMap.get(dept.toUpperCase());
		if (empDtoListByDept != null && !empDtoListByDept.isEmpty()) {
			for (EmpDto empDto : empDtoListByDept) 
			{
				System.out.println("Employee_id : " + empDto.getEmployeeId());
				System.out.println("First Name : " + empDto.getFirstName());
				System.out.println("Last Name  : " + empDto.getLastName());
				System.out.println("Salary     : " + empDto.getSalary());
				System.out.println("Mobile     : " + empDto.getPhone_number());
				System.out.println("Department : " + empDto.getDepartment());
				System.out.println("----------------------------------");
			}
		} 
		else 
		{
			System.out.println("No Records found"); 
		}
	}

	/**
	 * @param empDto
	 * @throws sqlException to the Business
	 * 
	 * Register Employee> to insert the employee details
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
	/**
	 * 
	 * @param 
	 * @throws SQLException to the Business object
	 * 
	 * Update Employee details in the Employee table
	 */
	public void updateEmployee(EmpDto empDto) throws SQLException{

		System.out.println("Type the Employee ID for whom you want to update the details");	
		Scanner scan = new Scanner(System.in);
		int empId = scan.nextInt(); 
		Connection con = DbConnection.getDbConnection();
		String sql = "Update employee SET First_Name =?, Last_Name=?, SALARY=?, Phone_number=?, Department=?"
				  + " WHERE EMPLOYEE_ID =?";
		PreparedStatement pst = con.prepareStatement(sql);
		//pst.setInt(1, empDto.getEmployeeId());
		pst.setString(1, empDto.getFirstName());
		pst.setString(2, empDto.getLastName());
		pst.setFloat(3, empDto.getSalary());
		pst.setInt(4, empDto.getPhone_number());
		pst.setString(5,empDto.getDepartment());
		pst.setInt(6, empId);
		
		int rowsUpdated = pst.executeUpdate();
		System.out.println("Employee Details Updated Successfully!: " + rowsUpdated);
	}

	/**
	 * delete Employee method to delete the detais of the employee table
	 */
	public void deleteEmployee() throws SQLException 
	{
		Connection con = DbConnection.getDbConnection();
		System.out.println("Enter the Employee ID to delete:");	
		Scanner scan = new Scanner(System.in);
		int empId = scan.nextInt(); 
		String sql = "Delete employees"
				  + " WHERE EMPLOYEE_ID ="+empId;
		PreparedStatement pst = con.prepareStatement(sql);
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
}