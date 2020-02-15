package code.java.manager.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils  {

	private static final String url = "jdbc:mysql://localhost/zen?useTimezone=true&serverTimezone=UTC";
	private static final String userName = "root";
	private static final String userPass = "";

	public static Connection getConnection() {

		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			conn = DriverManager.getConnection(url, userName, userPass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
