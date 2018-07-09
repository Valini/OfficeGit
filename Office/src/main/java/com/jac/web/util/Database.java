package com.jac.web.util;

import java.io.*;
import java.sql.*;
import java.util.*;

public class Database {
	private static Connection con = null;

	public static Connection getConnection() {
		if (con != null) {
			return con;
		} else {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://den1.mysql3.gear.host:3306/javabeansproject",
						"javabeansproject", "Ha6R4_U~2Gx0");

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return con;
		}
	}
}
