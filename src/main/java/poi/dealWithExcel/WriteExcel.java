package poi.dealWithExcel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
public class WriteExcel {

	@Test
	public void writeExcel() throws IOException, InvalidFormatException{


		// Use output stream to write and append the data in excel
		File file = new File("./data/Report.xlsx");
		FileOutputStream fos = new FileOutputStream(file);

		// Create work book
		XSSFWorkbook wbook = new XSSFWorkbook();

		// Create sheet
		XSSFSheet sheet = wbook.createSheet("CreateLead");

		// Create row
		XSSFRow row = sheet.createRow(0);

		// create cell - 1
		XSSFCell cell = row.createCell(0);

		// Enter contents
		cell.setCellValue("Success");


		// Write is must , unless it doesn't write the data in your excel sheet
		wbook.write(fos);

		// Best practice close the file stream and work book for leakage issue
		wbook.close();
		fos.close();




	}

}