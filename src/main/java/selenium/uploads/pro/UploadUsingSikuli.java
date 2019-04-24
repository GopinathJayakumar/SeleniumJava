package selenium.uploads.pro;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class UploadUsingSikuli {
	@Test
	public void sik() throws InterruptedException, FindFailed{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		driver.get("https://login.naukri.com/nLogin/Login.php");

		try {
			driver.findElementById("usernameField").sendKeys("rajpoppy2003@gmail.com");
			driver.findElementById("passwordField").sendKeys("poppy1779");
			driver.findElementByXPath("//button[text()='Login']").click();
			driver.findElementByXPath("//input[@value='Skip and Continue']").click();
		} catch (Exception e) {
			//e.printStackTrace();
		}

		try {
			driver.findElementById("emailTxt").sendKeys("rajpoppy2003@gmail.com");
			driver.findElementById("pwd1").sendKeys("poppy1779");
			driver.findElementByXPath("(//input[@id='sbtLog'])[2]").click();
		} catch (Exception e) {
			//e.printStackTrace();
		}
		driver.get("https://my.naukri.com/HomePage/view?id=");
		driver.findElementByXPath("//a[text()='Upload Photo ']").click();
		driver.findElementById("inpFile").click();
		Thread.sleep(2000);

		// Using Sikuli
		Screen screen = new Screen();
		
		Pattern fileNameInput = new Pattern("./koushik/FileName.PNG");
		Pattern openButton = new Pattern("./koushik/Open.PNG");
		screen.wait(fileNameInput);
		screen.type(fileNameInput, "C:\\Resume.pdf");
		screen.click(openButton);

		//		driver.findElementById("cancel").click();
		driver.close();
	}
}
