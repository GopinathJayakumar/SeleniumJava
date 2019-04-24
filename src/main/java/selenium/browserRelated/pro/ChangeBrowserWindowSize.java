package selenium.browserRelated.pro;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChangeBrowserWindowSize {
	
	public static void main(String[] args) throws InterruptedException {		
		System.out.println(System.getProperty("userDir"));
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");	
		ChromeDriver driver = new ChromeDriver();	
		driver.get("http://jqueryui.com/droppable/");		
		driver.manage().window().maximize();		
		Thread.sleep(2000);		
		driver.manage().window().setSize(new Dimension(100, 100));		
	}
}
