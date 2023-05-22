package Day1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class dropdown_all_val {
public static void main(String[] args) throws InterruptedException {
		
	WebDriverManager.chromedriver().setup();
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	ChromeDriver driver = new ChromeDriver(options); 
		
//		Step 1- Launch "https://www.sotc.in/india-tour-packages/jammu-and-kashmir-tour-packages"
		
		driver.get("https://www.sotc.in/india-tour-packages/jammu-and-kashmir-tour-packages");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		
//		Step 2- Print all the prices displayed against the package name
		String PACKAGE_NAME_XPATH = "//*[@class='package_detail_holder']//child::h2[@class='all_packages_name']";
		String PRICE_XPATH = "//*[@class='package_detail_holder']//child::span[contains(@data-bind,'text: parseInt(ko.toJS')]";
		
		List <WebElement> listPName = driver.findElements(By.xpath(PACKAGE_NAME_XPATH));
		List <WebElement> listPPrice = driver.findElements(By.xpath(PRICE_XPATH));
		
		Map <String, String> packageAndPrice = new HashMap <String, String> ();
		
		for (int i=0; i<listPName.size(); i++) {
			packageAndPrice.put(listPName.get(i).getText(), listPPrice.get(i).getText());
		}

		
		for (WebElement we: listPName) {
			System.out.println(we.getText());
		}
		
		for (WebElement we: listPPrice) {
			System.out.println(we.getText());
		}
		
		
			
	}
}