package selenium.grid.pro;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Login {

	@Test
	public void login() throws MalformedURLException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("firefox");
		dc.setVersion("59.0");
		dc.setPlatform(Platform.WINDOWS);
		
		RemoteWebDriver driver = 
				new RemoteWebDriver(new URL("http://10.0.0.140:4477/wd/hub"), dc);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//load url
		driver.get("http://leaftaps.com/opentaps");
		//enter UserName
		driver.findElementById("username").sendKeys("DemoSalesManager",Keys.TAB);          
	
		//enter Password
		driver.findElementById("password").sendKeys("crmsfa");
		//click login
		driver.findElementByClassName("decorativeSubmit").click();
		
		driver.close();
		
		
		
		
	}

}
