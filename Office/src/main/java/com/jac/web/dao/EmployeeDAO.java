package com.jac.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	
	

}
