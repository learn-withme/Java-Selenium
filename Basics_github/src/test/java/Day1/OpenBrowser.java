package Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenBrowser {

	public static void main(String[] args) {
	
		// This will setup Chrome Browser
		WebDriverManager.chromedriver().setup();
		
		//This is for Chrome Compactible
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--  remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(options);
		
		// Launch the given URL on the Chrome browser
		driver.get("https://www.Google.com/");
		//driver.navigate().to("https://www.Google.com/");
		
		driver.findElement(By.xpath("//input[@title ='Search']")).sendKeys("javapoint tutorial");
		driver.findElement(By.xpath("//input[@value = 'Google Search']")).click();
		
		driver.close();
	}

}
