package selenium.webTable.pro;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Erail {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://erail.in/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElementById("txtStationFrom").clear();
		driver.findElementById("txtStationFrom").sendKeys("MAS");
		
		driver.findElementById("txtStationTo").clear();
		driver.findElementById("txtStationTo").sendKeys("SBC");
		
	//	driver.findElementsByTagName("tr");
		
		WebElement table = driver.findElementByXPath("//table[@class='DataTable TrainList']");
		
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		
		List<WebElement> allCells = allRows.get(1).findElements(By.tagName("td"));
		allCells.get(1).getText();
		
		for (WebElement eachRow : allRows) {
			String text = eachRow.findElements(By.tagName("td")).get(1).getText();
			System.out.println(text);
		}
		
	}

}
