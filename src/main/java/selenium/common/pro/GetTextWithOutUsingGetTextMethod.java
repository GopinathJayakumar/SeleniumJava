package selenium.common.pro;

import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

public class GetTextWithOutUsingGetTextMethod {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Using WebDriver Code
		String txt = driver.findElementById("tdToOnly").getAttribute("innerText");
		System.out.println(txt);
	/*	
		//Using JavaScriptExecutor
		JavascriptExecutor js = (JavascriptExecutor)driver;		
		String txt1 = 
		*js.executeScript("return document.getElementById('tdToOnly').innerText").toString();*		
		System.out.println(txt1);
		
	*/	
	}
	
	

}
