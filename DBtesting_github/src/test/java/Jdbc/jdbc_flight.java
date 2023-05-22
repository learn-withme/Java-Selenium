package Jdbc;

import java.sql.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class jdbc_flight {

	public static void main(String [] args) throws SQLException {

		String db_url = "jdbc:oracle:thin:@orcl-aws.XXXXXX";
		String db_user_id = "ABCDEF";
		String db_pwd = "abcdef";

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.makemytrip.com/");

		try 
		{

			Connection conn = DriverManager.getConnection (db_url,db_user_id,db_pwd);

			Statement stat = conn.createStatement();

			//Set the auto commit off for the batch execution
			conn.setAutoCommit(false);

			String tbl_create = "create table jdbc_flight (from_city varchar(20),to_city varchar(20))";
			String commit = "commit";
			stat.execute(tbl_create);

			String insert_rec1 =  "insert into jdbc_flight values ('Chennai','Mumbai')";
			stat.addBatch(insert_rec1);
			String insert_rec2 =  "insert into jdbc_flight values ('Delhi','Bangalore')";
			stat.addBatch(insert_rec2);
			String insert_rec3 =  "insert into jdbc_flight values ('Chennai','Comibatore')";
			stat.addBatch(insert_rec3);
			String insert_rec4 =  "insert into jdbc_flight values ('Pune','Bangkok')";
			stat.addBatch(insert_rec4);
			String insert_rec5 =  "insert into jdbc_flight values ('Chennai','Bangkok')";
			stat.addBatch(insert_rec5);
			stat.addBatch(commit);
			stat.executeBatch();
			System.out.println("Table created:");

			String select = "select from_city,to_city from jdbc_flight";
			ResultSet rs = stat.executeQuery(select);
			while (rs.next()) {

				String from_city = rs.getString("from_city");
				String to_city = rs.getString("to_city");

				driver.findElement(By.xpath("//*[contains(@placeholder,'From')]")).sendKeys(from_city);
				driver.findElement(By.xpath("//*[contains(@placeholder,'To')]")).sendKeys(to_city);
				driver.findElement(By.xpath("//*[contains(@class,'primaryBtn')]")).click();

			}

			conn.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}

	}

}
