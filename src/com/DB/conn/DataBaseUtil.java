package com.DB.conn;

import java.sql.*;

public class DataBaseUtil {

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/graduateproject";
			
			conn = DriverManager.getConnection(url, "root","123456");
		} 
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return conn;
	}
	
	public static void close(ResultSet rs,Statement st,Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement pst,Connection conn) {
	 close(null, pst, conn);
	}
}


