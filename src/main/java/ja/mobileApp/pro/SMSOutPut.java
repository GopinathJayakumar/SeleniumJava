package ja.mobileApp.pro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.testng.annotations.Test;

public class SMSOutPut {

	@Test(dataProvider="fetchData")
	public void main(String name,String data,String msg) throws ClientProtocolException, IOException {

		String myPasscode = "password123456";
		String myUsername = "GopinathJayakumar";    
		String toPhoneNumber = "91"+data;
		String myMessage = "Second "+msg+" hi "+name;

		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet("http://cloud.fowiz.com/api/message_http_api.php?"
				+ "username="+URLEncoder.encode(myUsername, "UTF-8")
				+"&phonenumber="+URLEncoder.encode(toPhoneNumber, "UTF-8")
				+"&message="+URLEncoder.encode(myMessage, "UTF-8")
				+"&passcode="+URLEncoder.encode(myPasscode, "UTF-8"));
		HttpResponse response = client.execute(request);

		HttpGet request1 = new HttpGet("https://platform.clickatell.com/messages/http/send?apiKey=RjNQOz94SNuKxzav-Q3G8Q==&to="+toPhoneNumber+"&content="+myMessage);
		HttpResponse response1 = client.execute(request1);
		BufferedReader rd = new BufferedReader
				(new InputStreamReader(response1.getEntity().getContent()));

		String line = "";
		StringBuffer response2 = new StringBuffer();
		while ((line = rd.readLine()) != null) {
			response2.append(line);
		}   

			System.out.println(response.toString());
	}
}