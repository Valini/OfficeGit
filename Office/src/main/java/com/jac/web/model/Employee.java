package com.jac.web.model;

public class Employee {
	
	private int employeeId;
	private String employeeName;
	private String password;
	private String firstName;
	private String lastName;
	private String city;
	private String postalCode;
	

	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", city=" + city + ", postalCode="
				+ postalCode + ", getEmployeeId()=" + getEmployeeId() + ", getEmployeeName()=" + getEmployeeName()
				+ ", getPassword()=" + getPassword() + ", getFirstName()=" + getFirstName() + ", getLastName()="
				+ getLastName() + ", getCity()=" + getCity() + ", getPostalCode()=" + getPostalCode() + "]";
	}
	
	
	
	
	 
}
