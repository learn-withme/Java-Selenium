package Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginPage {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(options);
			
		driver.navigate().to("https://gcreddy.com/project/admin/");
		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("gcreddy");
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("Temp@2020");
		driver.findElement(By.xpath("//span[@class= 'ui-button-text']")).click();
		
	}
}