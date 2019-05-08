package selenium.aui.pro;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class RightClick {
	
	public static void main(String[] args) {	
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		ChromeOptions opt = new ChromeOptions();
		//opt.addArguments("--disable-popup-blocking");
	//	opt.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(opt);
		
		driver.get("https://www.myntra.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement men = driver.findElementByLinkText("Home & Living");
		Actions builder = new Actions(driver);
		builder.contextClick().perform();
		
	}

}
