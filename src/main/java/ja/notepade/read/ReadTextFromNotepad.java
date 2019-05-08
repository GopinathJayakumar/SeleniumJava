package ja.notepade.read;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextFromNotepad {
	
	String filename = "C:\\Users\\admin\\Desktop\\gopi.txt";

	public static void main(String[] args) throws FileNotFoundException {

		
		
	}
	
	public void usingBufferedReader() throws FileNotFoundException {
		BufferedReader reader = new BufferedReader(new FileReader(filename));

		try{
			String line;
			
			//as long as there are lines in the file, print them
			while((line = reader.readLine()) != null){ 
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
