package windowbulderTest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static windowbulderTest.coding_1.p_name1;
import static windowbulderTest.coding_1.onum;
import static windowbulderTest.coding_1.oprice;
import static windowbulderTest.Login.mmid;

public class test {
	static Connection conn;

	static Statement stmt;
	static ResultSet rs;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        stmt = null;
        rs = null;
        String sql = "Select * From order";

		try {

			 conn = DriverManager.getConnection("jdbc:mysql://localhost/shop", 
					"root","1234");
			System.out.println("success");
		stmt = conn.createStatement();
			query("insert", "insert into test values ('"+mmid+"','"+onum+"','"+oprice+"','"+p_name1+"')");

		} catch (SQLException ex) {
			System.out.println("SQLException" + ex);
		}
		
		
		
	}
	public static void query(String order, String sql) throws SQLException {
		if (order == "select") {
			rs = stmt.executeQuery(sql);
		} 

		else {
			stmt.executeUpdate(sql);
		}
	}

}