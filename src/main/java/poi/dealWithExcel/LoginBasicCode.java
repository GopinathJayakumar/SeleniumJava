package poi.dealWithExcel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginBasicCode extends DataInputProvider {

	
	@Test(dataProvider = "fetchData")
	public void Login(String uName, String password) throws InterruptedException{
		
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();	
		
		driver.manage().window().maximize();		
		
		
		driver.get("http://leaftaps.com/");
				
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		driver.findElementById("username").sendKeys(uName);
		
		
		driver.findElementById("password").sendKeys(password);
		
		
		driver.findElementByClassName("decorativeSubmit").click();
		
		Thread.sleep(3000);
		
		driver.findElementByClassName("decorativeSubmit").click();
		
		System.out.println("Success");
	
		driver.close();
		
		
		
		
		
		
		
		
		
		
	}

}
