package selenium.challenges.pro;

import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ScrollDown {

	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();		
		driver.manage().window().maximize();	
		driver.get("https://www.naukri.com/");
		
		//driver.findElementByLinkText("Browse All Jobs").click();
		System.out.println(driver.findElementByLinkText("Browse All Jobs").isDisplayed());

		int y = driver.findElementByLinkText("Browse All Jobs").getLocation().getY();
		((JavascriptExecutor) driver).executeScript("scroll(0,"+y+");");
	}
}
