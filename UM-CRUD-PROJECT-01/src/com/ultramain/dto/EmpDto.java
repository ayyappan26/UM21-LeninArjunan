package com.ultramain.dto;

/**
 * Data Transfer Object for holding employee details.
 * 
 * @author LArjunan
 * 
 *
 */
public class EmpDto {
	private int employeeId;
	private String firstName;
	private String lastName;
	private float salary;
	private int phoneNumber;
	private String department;
	
	/**
	 * @return the employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}
	
	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * @return the salary
	 */
	public float getSalary() {
		return salary;
	}
	
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}
	
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	
	/**
	 * @return 
	 * @return the phone_number
	 */
	public int getPhone_number() {
		return phoneNumber;
	}

	/**
	 * @param phone_number the phone_number to set
	 */
	public void setPhone_number(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	
	}
}

