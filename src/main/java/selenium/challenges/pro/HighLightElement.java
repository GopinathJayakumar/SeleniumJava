package selenium.challenges.pro;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class HighLightElement {

	public RemoteWebDriver driver;

	@Test
	public void main() throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();		
		driver.manage().window().maximize();		
		driver.get("http://jqueryui.com/");

		WebElement checkIn =driver.findElement(By.linkText("Demos"));

		for (int i = 0; i < 20; i++) {
			
			((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1]);", checkIn,
					"color: Yellow; border: 10px dotted solid green;");
			Thread.sleep(300);
			((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1]);", checkIn,
					"color: transparent;");
			Thread.sleep(300);
		}

		driver.close();

	}

}
