package selenium.challenges.pro;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginUsingJS {

	@Test
	public void loginJS() {		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");		
		JavascriptExecutor js = (JavascriptExecutor)driver;		
		js.executeScript("document.getElementById('username').value='DemoSalesManager'");
	}
}
