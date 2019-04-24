package selenium.browserRelated.pro;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class ChromeBrowserOpenedinAndroid {

	@Test
	public void chromeWithAndroid(){
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("androidPackage", "com.android.chrome");
		chromeOptions.setExperimentalOption("androidDeviceSerial", "ZY2245Q5W4");
		ChromeDriver driver = new  ChromeDriver(chromeOptions);
		driver.get("https://web.whatsapp.com/");
	}

}
