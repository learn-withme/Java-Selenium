package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 Open Connection
 Create statement
 Execute Statement
 Close Connection 
 */

public class JdbcEx_DML{

	public static void main(String[] args) throws SQLException {
		//Open Connection
		Connection con = DriverManager.getConnection
			("jdbc:oracle:thin:@orcl-aws.xxxxx","User_name","pwd");

		//Create Statement
		Statement stat = con.createStatement();
		
		//Execute Statement
		String comm_insert = "insert into city values (50,'Coimbatore',250123)";
		stat.execute(comm_insert);
		String comm_update = "update city set c_name = 'Erode' where c_id = 50";
		stat.execute(comm_update);
		//String comm_detele = "delete from city where c_name = 'Erode'";
		//stat.execute(comm_detele);
		
		//Close connection
		con.close();
		
		System.out.println("Data Inserted,Updated and Deleted");
	}
}


