package ja.java.pro;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import org.xml.sax.Locator;

public class GetDate {
	@Test
	public void test1() {
		DateFormat dateFormat = new SimpleDateFormat("dd mm yy");
		System.out.println(dateFormat);
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
	}

}
