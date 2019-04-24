package voices;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJson {	
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("./data/g.txt"));

		JSONObject jsonObject = (JSONObject) obj;

		String name = (String) jsonObject.get("Name");
		String author = (String) jsonObject.get("Author");
		JSONArray companyList = (JSONArray) jsonObject.get("Mentors List");

		System.out.println("Name: " + name);
		System.out.println("Author: " + author);
		System.out.println("\nCompany List:");			
		
		for (Object object : companyList) {
			System.out.println("\t"+object);
		}
		
	
	}
}
