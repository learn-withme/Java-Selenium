package Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Tooltips {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options); 
		
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
		//To Scroll the webPage
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		 
		scroll.executeScript("window.scrollBy(0,1000)");
				
		WebElement link = driver.findElement(By.linkText("Messenger"));
		
		//Mouse hover to the link  Messenger , Actions will interact with Selenium
		Actions action = new Actions(driver);
		
		action.moveToElement(link).perform();
		
		String tooltip = link.getAttribute("title");
		
		System.out.println ("The ToolTip tilte is : "+tooltip);
		
		driver.close();
	}

}
