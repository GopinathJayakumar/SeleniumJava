package selenium.applitool.pro;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;

public class LearnApplitool {

	RemoteWebDriver driver;
	int i =1;


	public void takeSnap() throws WebDriverException, IOException {
		FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE), new File("./snaps/img"+i+".png"));
		i++;
	}

	@Test
	public void main() throws WebDriverException, IOException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();

		Eyes eyes = new Eyes();
		eyes.setApiKey("IfawciEQvk4Ilhtg7fQE7IlX8ULHwqab99MoQ4104sMcZM110");
		eyes.open(driver, "Hello Gopi", "Create Lead TestCases Image comp!",
				new RectangleSize(800, 600));


		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		takeSnap();
		eyes.checkWindow();
		driver.findElementById("username").sendKeys("DemoSalesManager");
		takeSnap();
		eyes.checkWindow();
		driver.findElementById("password").sendKeys("crmsfa");		
		takeSnap();
		eyes.checkWindow();		
		driver.close();		
		eyes.abortIfNotClosed();		
	}
}
