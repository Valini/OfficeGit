package com.jac.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jac.web.model.Employee;


public class EmployeeDAO {

	public Employee getEmployee(String employeeName) {
		Employee s1 = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://den1.mysql3.gear.host:3306/javabeansproject",
					"javabeansproject", "Ha6R4_U~2Gx0");
			String query = "SELECT employeeName , password from employees  where employeeName=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, employeeName);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				s1 = new Employee();
				String employeeNameFromDB = rs.getString("employeeName");
				String passwordFromDB = rs.getString("password");

				s1.setEmployeeName(employeeNameFromDB);
				s1.setPassword(passwordFromDB);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s1;
	}

	public boolean addEmployee(Employee employee) {
		boolean success = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://den1.mysql3.gear.host:3306/javabeansproject",
					"javabeansproject", "Ha6R4_U~2Gx0");
			// the mysql insert statement
			String query = "INSERT INTO employees (employeeName, password, firstName, lastName, city, postalCode )"
					+ " VALUES (?, ?, ?, ?, ?, ?)";

			// create the mysql insert prepared statement
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, employee.getEmployeeName());
			preparedStmt.setString(2, employee.getPassword());
			preparedStmt.setString(3, employee.getFirstName());
			preparedStmt.setString(4, employee.getLastName());
			preparedStmt.setString(5, employee.getCity());
			preparedStmt.setString(6, employee.getPostalCode());

			// execute the prepared statement
			int count = preparedStmt.executeUpdate();
			con.close();

			if (count > 0) {
				success = true;
			} else {
				success = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	public String deleteEmployee(int ID) {
		boolean success = false;
		String result = "Product was not successfully deleted";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://den1.mysql3.gear.host:3306/javabeansproject",
					"javabeansproject", "Ha6R4_U~2Gx0");
			// the mysql insert statement
			String query = "DELETE FROM employees WHERE employeeID= ?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt(1, ID);

			// execute the prepared statement
			int count = preparedStmt.executeUpdate();
			if (count > 0) {
				result = "Product successfully deleted!";
				
			} else {
				result = "Product was not successfully deleted";
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Employee getEmployeeByID(int ID) {
		Employee s1 = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://den1.mysql3.gear.host:3306/javabeansproject",
					"javabeansproject", "Ha6R4_U~2Gx0");
			String query = "SELECT * from employees  where employeeId=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, ID);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				s1 = new Employee();
				int employeeIDFromDB = rs.getInt("employeeID");
				String employeeNameFromDB = rs.getString("employeeName");
				String passwordFromDB = rs.getString("password");
				String firstNameFromDB = rs.getString("firstName");
				String lastNameFromDB = rs.getString("lastName");
				String cityFromDB = rs.getString("city");
				String postalCodeFromDB = rs.getString("postalCode");
				
				s1.setEmployeeId(employeeIDFromDB);
				s1.setEmployeeName(employeeNameFromDB);
				s1.setPassword(passwordFromDB);
				s1.setFirstName(firstNameFromDB);
				s1.setLastName(lastNameFromDB);
				s1.setCity(cityFromDB);
				s1.setPostalCode(postalCodeFromDB);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s1;
	}

	public boolean updateEmployee(Employee employee) {
		boolean success=false;
		try {
			// create a java mysql database connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://den1.mysql3.gear.host:3306/javabeansproject",
					"javabeansproject", "Ha6R4_U~2Gx0");

			// create the java mysql update prepared statement
			String query = "update javabeansproject.employees set employeeName = ?,password=?,firstName=?, lastName=?, city=?, postalCode=? where employeeId = ?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, employee.getEmployeeName());
			preparedStmt.setString(2, employee.getPassword());
			preparedStmt.setString(3, employee.getFirstName());
			preparedStmt.setString(4, employee.getLastName());
			preparedStmt.setString(5, employee.getCity());
			preparedStmt.setString(6, employee.getPostalCode());
			preparedStmt.setInt(7, employee.getEmployeeId());

			// execute the java prepared statement
			int count = preparedStmt.executeUpdate();

			con.close();
			if (count > 0) {
				success = true;
			} else {
				success = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	public ArrayList<Employee> getAllEmployees() {
		
		ArrayList<Employee> list = new ArrayList<Employee>();
		
		try {
			// create a java mysql database connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://den1.mysql3.gear.host:3306/javabeansproject",
					"javabeansproject", "Ha6R4_U~2Gx0");

	

			String query = "select * from employees";

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {

				Employee e = new Employee();
				e.setEmployeeId(rs.getInt(1));
				e.setEmployeeName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setFirstName(rs.getString(4));
				e.setLastName(rs.getString(5));
				e.setCity(rs.getString(6));
				e.setPostalCode(rs.getString(7));
				
				list.add(e);

			}

			con.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
}
