package Day1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SOTC_E2E {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options); 

		driver.get("https://www.sotc.in/india-tour-packages/jammu-and-kashmir-tour-packages");
		driver.manage().window().maximize();
		String PACKAGE_CONTAINER_CSS_SELECTOR = "h2.all_packages_name";
		String PRICE_CSS_SELECTOR = ".INR+span[data-bind*='text: parseInt']";

		List <WebElement> packageDetails = driver.findElements(By.cssSelector(PACKAGE_CONTAINER_CSS_SELECTOR));
		List <WebElement> priceDetails = driver.findElements(By.cssSelector(PRICE_CSS_SELECTOR));		

		System.out.println("Total no of packages are : "+packageDetails.size());
		System.out.println("Total no of price details are : "+priceDetails.size());

		Map <String, String> packageAndPrice = new HashMap <String, String> ();  
		for (int i =0; i<packageDetails.size();i++) {
			packageAndPrice.put(packageDetails.get(i).getText(), priceDetails.get(i).getText());
		} 

		for(Map.Entry <String, String> m : packageAndPrice.entrySet()){  
			System.out.println(m.getKey()+" "+m.getValue());  
		}
		driver.close();

	}
}