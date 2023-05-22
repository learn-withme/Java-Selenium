package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc_select {
	
	public static void main(String[] args) throws SQLException {
	
	Connection con = DriverManager.getConnection
			("jdbc:oracle:thin:@orcl-aws.xxxxx","User_name","pwd");
	Statement stat = con.createStatement();
	String sele = "select c_id,c_name from city";
	ResultSet rs = stat.executeQuery(sele);
	while (rs.next())
	{
		int c_id =  rs.getInt("c_id");
		String c_name = rs.getString("c_name");
		
		System.out.println(c_id);
		System.out.println(c_name);		
	}
	
  }
}
