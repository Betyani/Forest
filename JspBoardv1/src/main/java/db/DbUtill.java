package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtill {
	private static final String URL = "jdbc:mysql://localhost:3306/my_cat";
	private static final String USER = "root";
	private static final String PASS = "root";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
