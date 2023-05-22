//Drop Down bar selection
package Day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class selectDemo {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options); 

		driver.get("https://www.salesforce.com/in/form/contact/contactme/?d=fb1-btn-contact&bc=HA");
		Thread.sleep(3000);


		WebElement jobTitle = driver.findElement(By.name("UserTitle")); 
		WebElement emp = driver.findElement(By.name("CompanyEmployees")); 
		WebElement selectProduct = driver.findElement(By.xpath("//select[starts-with(@id,'Lead.Primary_Product_Interest')]"));

		Select selectJobTitle = new Select(jobTitle);
		Select selectEmp = new Select(emp);
		Select selectPObj = new Select(selectProduct);


		// Selecting by Value
		selectJobTitle.selectByValue("Sales_Manager_AP");
		Thread.sleep(3000);


		// Selecting by Visible Text
		selectEmp.selectByVisibleText("1 - 15 employees");
		Thread.sleep(3000);

		// Selecting by Index
		selectPObj.selectByIndex(3);
		Thread.sleep(3000);	

		selectPObj.selectByIndex(5);

	}
}