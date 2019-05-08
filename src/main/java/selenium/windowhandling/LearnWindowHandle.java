package selenium.windowhandling;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.SessionId;

public class LearnWindowHandle {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");	
		/*ChromeOptions op = new ChromeOptions();
		op.setExperimentalOption("debuggerAddress", "localhost:9014");		
		ChromeDriver driver = new ChromeDriver(op);			
		driver.findElementByLinkText("Sign in").click();*/
		
		ChromeDriver driver = new ChromeDriver();	
		SessionId sessionId = driver.getSessionId();
		CommandExecutor commandExecutor = driver.getCommandExecutor();
		System.out.println(sessionId);
		System.out.println(commandExecutor);
		
	}

}
