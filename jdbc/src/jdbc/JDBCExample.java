package jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/sakila";
	
	static final String USERNAME = "root";
	static final String PASSWORD = "feef100!";
	
	public void accessDB() {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			System.out.println("Inserting records into the table...");
			stmt = conn.createStatement();
			String sql = "SELECT country_id, country FROM country";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("country_id");
				String country = rs.getString("country");
				System.out.println("Country_id: " + id +", Country: " + country);
				
			}
			rs.close();
				
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(stmt!= null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("Goodbye!");
		
	}
	
	
}
