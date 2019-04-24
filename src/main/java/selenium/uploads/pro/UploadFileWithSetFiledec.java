package selenium.uploads.pro;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;

public class UploadFileWithSetFiledec {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// opening Firefox browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		// maximize the browser
		driver.manage().window().maximize();
		// load the browser with url
		driver.get("https://www.naukri.com/");
		
		//driver.findElementById("input_resumeParser").click();
		
//		Thread.sleep(10000);		
		
		// Store the copied text in the clipboard
		/*StringSelection stringSelection = new StringSelection("c:\\Resume.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		   
		// Paste it using Robot class
		Robot robot = new Robot();
		
		// Enter to confirm it is uploaded
		 robot.keyPress(KeyEvent.VK_CONTROL);
         robot.keyPress(KeyEvent.VK_V);
         robot.keyRelease(KeyEvent.VK_V);
         robot.keyRelease(KeyEvent.VK_CONTROL);
         
         Thread.sleep(5000);
         robot.keyPress(KeyEvent.VK_ENTER);
         robot.keyRelease(KeyEvent.VK_ENTER);*/
		
	//	Way 2::
	/*	WebElement ele = driver.findElementById("input_resumeParser");		
		LocalFileDetector detect = new LocalFileDetector();
		((RemoteWebElement)ele).setFileDetector(detect);
		ele.sendKeys(detect.getLocalFile("c:\\Resume.pdf").getAbsolutePath());*/
         
	}

}
