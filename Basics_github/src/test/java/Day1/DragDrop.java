package Day1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DragDrop {
public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options); 

		driver.get("https://jqueryui.com/droppable/");
		Thread.sleep(3000);		
		
		// Defining the iframe WebElement
		WebElement frameEle = driver.findElement(By.cssSelector(".demo-frame"));
		
		// Switch to the iframe, in order to interact the WebElements inside the iframe
		driver.switchTo().frame(frameEle);		
		
		WebElement dragEle = driver.findElement(By.xpath("//*[@id='draggable']"));
		WebElement dropEle = driver.findElement(By.xpath("//*[@id='droppable']"));
		
		new Actions(driver).dragAndDrop(dragEle, dropEle).perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.close();
			
	}
}