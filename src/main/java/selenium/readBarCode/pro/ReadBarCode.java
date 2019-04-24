package selenium.readBarCode.pro;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ReadBarCode {

	public static void main(String[] args) throws IOException {

		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://4.bp.blogspot.com/-DQclrukGwvM/WKfIFcdOBOI/AAAAAAAAATI/H4j5VQvTfHE4reL56Zm5EYNX5LfvIt5AgCLcB/s1600/testImage.PNG");



		URL url = new URL("https://4.bp.blogspot.com/-DQclrukGwvM/WKfIFcdOBOI/AAAAAAAAATI/H4j5VQvTfHE4reL56Zm5EYNX5LfvIt5AgCLcB/s1600/testImage.PNG");


		BufferedImage barCodeBufferedImage = ImageIO.read(url);
		ITesseract instance = new Tesseract();  
		instance.setDatapath("./data/image");

		try {  
			String  result = instance.doOCR(barCodeBufferedImage);  
			System.out.println(result);
			Assert.assertEquals(result.trim(), "Create a Youtube metadata crawler using Java");
		} catch (TesseractException e) {  
			System.err.println(e.getMessage());  
			System.out.println("Error while reading image");  
		}  
		
		driver.close();
		driver.quit();
	}  




}


