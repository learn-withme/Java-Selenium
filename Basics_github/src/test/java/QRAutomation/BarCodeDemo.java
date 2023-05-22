package QRAutomation;

import java.awt.image.BufferedImage;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import javax.imageio.ImageIO;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.Result;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class BarCodeDemo { 
		
	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver(); 

		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		String BarlocationURL = driver.findElement(By.xpath("//div[@id='HTML12']//img[1]")).getAttribute("src");
		
		URL Barurl = new URL(BarlocationURL);
		
		BufferedImage barimageio = ImageIO.read(Barurl);
		
		//to help decode images from files which arrive as RGB data from an ARGB pixel array
		LuminanceSource barsource = new BufferedImageLuminanceSource (barimageio);
		
		//Convert the data into Bitmap
		BinaryBitmap barbitmap = new BinaryBitmap(new HybridBinarizer(barsource));
		
		Result barresult = new MultiFormatReader().decode(barbitmap);
		
		System.out.println("QR or Bar code reader info : " +barresult.getText());
					
		driver.close();
			
	}
}