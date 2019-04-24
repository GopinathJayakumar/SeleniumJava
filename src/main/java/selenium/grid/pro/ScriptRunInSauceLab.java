package selenium.grid.pro;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.saucelabs.saucerest.SauceREST;

public class ScriptRunInSauceLab {

	public SauceREST sR;
	public CharSequence fJob;

	@BeforeTest
	public void  sauceClass() {
	sR = new SauceREST("ortoni09", 
			"554bcbee-227b-4329-9843-25428b495e0b");
	}
	
	public CharSequence jobNum() {		
		String[] x = sR.getJobs().split(",");
		for (String eachX : x) {	
			fJob=eachX.subSequence(9, 41);
			break;
		}
		return fJob;
	}
	
	@Test
	public void sample() throws IOException, InterruptedException {		
		/*System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();*/

		DesiredCapabilities dc = new  DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WINDOWS);

		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://SarathMuthu:"+
				"23772337-4dcb-46aa-9e96-0872bb17a0d7@ondemand.saucelabs.com:80/wd/hub"), dc);

		driver.get("http://leaftaps.com/opentaps");
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		System.out.println("***********Login clicked************");

		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/snap1.jpg");
		FileUtils.copyFile(source, dest);
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Find Leads").click();
		System.out.println("***********Find Leads clicked************");

		source = driver.getScreenshotAs(OutputType.FILE);
		dest = new File("./snaps/snap2.jpg");
		FileUtils.copyFile(source, dest);

		driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("Gopinath");
		driver.findElementByXPath("//button[contains(text(),'Find Leads')]").click();
		Thread.sleep(3000);

		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a").click();
		System.out.println("***********Selected First Lead************");		

		driver.findElementByLinkText("Edit").click();
		WebElement industry = driver.findElementById("updateLeadForm_industryEnumId");
		Select dropdown = new Select(industry);
		dropdown.selectByVisibleText("Computer Software");
		driver.findElementByXPath("//input[@value='Update']").click();
		if(driver.findElementById("viewLead_industryEnumId_sp").getText().equals("Computer Software")){
			System.out.println("***********Updated Lead with Industry************");
		}else{
			System.out.println("***********Could not Update Lead with Industry************");
		}

		source = driver.getScreenshotAs(OutputType.FILE);
		dest = new File("./snaps/snap4.jpg");
		FileUtils.copyFile(source, dest);

		driver.close();						
	}
	
	@BeforeMethod
	public void sauceJobID() {
		sR.downloadLog(""+jobNum(), "./sauceLogs");		 
		sR.downloadVideo(""+jobNum(),"./sauceVideos");
	}

}
