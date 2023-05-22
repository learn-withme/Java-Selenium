package Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;


public class DateSelection {

	public static void main(String[] args) {
		
		String url ="https://www.kayak.co.in/";
		String from_city = "Mumbai";
		String to_city = "New Delhi";
		String from_xpath = "//*[@aria-label = 'Flight origin input']";
		String to_xpath ="//*[@aria-label = 'Flight destination input']";
		String cal_xpath ="//*[@class='sR_k-value']";
		String fromDate = "25 July, 2023";
		String toDate = "28 July, 2023";
		String date_xpath = "//*[@class ='ATGJ-monthWrapper']//child::div[contains(@class,'mkUa mkUa-pres-mcfly')]";
		String btn_xpath ="//*[@aria-label = 'Search']";
		String label = "aria-label";
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(options);
		
		driver.get(url);
		driver.manage().window().maximize();
		WebElement fromCity = driver.findElement(By.xpath(from_xpath));
		fromCity.sendKeys(from_city);
		
		WebElement toCity = driver.findElement(By.xpath(to_xpath));
		toCity.sendKeys(to_city);
		
		WebElement Calen = driver.findElement(By.xpath(cal_xpath));
		Calen.click();		
	
		List <WebElement> allDates = driver.findElements(By.xpath(date_xpath));
		
		for (WebElement we : allDates) {
			if (we.getAttribute(label) .equals(fromDate)) {
				we.click();
				System.out.println ("Clicked fromDate");
				break;
			}
		}
			
		for (WebElement we1:allDates) {
			if (we1.getAttribute(label) .equals(toDate)) {
				System.out.println ("Clicking toDate");
				we1.click();
				break;
			}
		}
		
		WebElement btnClk = driver.findElement(By.xpath(btn_xpath));
		btnClk.click();
		
	}
}












