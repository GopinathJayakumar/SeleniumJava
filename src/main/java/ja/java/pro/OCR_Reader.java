package ja.java.pro;

import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class OCR_Reader {
	
	public static void main(String[] args) throws TesseractException {
		
		String img = "C:\\Users\\GopinathJayakumar\\Desktop\\1.jpg";		
		Tesseract tr = new Tesseract();		
		tr.setDatapath("C:\\Users\\GopinathJayakumar\\Desktop\\ts");
		tr.setLanguage("eng");		
		String txt = tr.doOCR(new File(img));		
		System.out.println(txt);		
	}
}
