package selenium.browserRelated.pro;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifingPageLoading {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();		
		driver.get("http://leaftaps.com/opentaps");
		//Using JavaScript Executor
		String state = (String) ((JavascriptExecutor)driver).executeScript("return document.readyState");

		switch (state) {
		
		case "loading":
			System.out.println("The document is still loading.");
			break;
		
		case "interactive":
			System.out.println(
					        "The document has finished loading." +
							"We can now access the DOM elements.\n"+ 
							"But sub-resources such as images, stylesheets and"+
							"frames are still loading"
					        );
			break;
		
		case "complete":
			System.out.println("The page is fully loaded.");
			break;

		default:
			break;
		}
	}
}
