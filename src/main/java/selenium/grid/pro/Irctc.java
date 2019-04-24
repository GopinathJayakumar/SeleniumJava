package selenium.grid.pro;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Irctc {
	@Test
	public void run() throws InterruptedException, MalformedURLException {

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WINDOWS);
		dc.setVersion("65.0");
		
		RemoteWebDriver driver = new RemoteWebDriver(new URL(
				"http://10.0.0.140:4477/wd/hub"), dc);
	
			
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		//WebElement securityQ = driver.findElementById("userRegistrationForm:securityQ");
		Select dd = new Select(
		driver.findElementById("userRegistrationForm:securityQ"));
		/*dd.selectByIndex(2);
		Thread.sleep(3000);
		dd.selectByValue("4");
		Thread.sleep(3000);
		dd.selectByVisibleText("What is your fathers middle name?");
		*/
		List<WebElement> allOptions = dd.getOptions();
		/*int count = allOptions.size();
		System.out.println(count);
		dd.selectByIndex(count-1);*/
		for (WebElement eachOption : allOptions) {
			String text = eachOption.getText();
			System.out.println(text);
		}		
	}
}
