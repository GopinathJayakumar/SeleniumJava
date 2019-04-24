package selenium.grid.pro;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JqueryUi {

	@Test
	public void frame() throws InterruptedException, MalformedURLException {
		
	/*	DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setVersion("64.0");
		dc.setPlatform(Platform.WINDOWS);
		
		RemoteWebDriver driver = new RemoteWebDriver(
				new URL("http://10.0.0.140:4477/wd/hub"), dc);
		
	*/	//Load the URL
		System.setProperty("webdriver.chrome.driver",
				"./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://jqueryui.com/draggable/");
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
		WebElement demo = driver.findElementByClassName("demo-frame");
		
		// switch to the frame
		driver.switchTo().frame(demo);
		
		// Get the text of the draggable
		System.out.println(driver.findElementById("draggable").getText());
		
		// come out frame
		driver.switchTo().defaultContent();
		
		// Click on the Download
		driver.findElementByLinkText("Download").click();
		
		
		
		
	}
}