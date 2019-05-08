package poi.dealWithExcel;
import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
public class DataInputProvider {


	public Object[][] readExcel(String fileName) throws IOException, InvalidFormatException{

		File input = new File("./data/"+fileName+".xlsx");

		//	Open  a work (Using XSSFWorkbook)
		XSSFWorkbook wbook = new XSSFWorkbook(input);

		//	Go to the specific sheet using name or index (XSSFSheet -> getSheet)
		XSSFSheet sheet = wbook.getSheetAt(0);

		int rowCount = sheet.getLastRowNum();
		System.out.println(rowCount);
		int columnCount = sheet.getRow(0).getLastCellNum();
		System.out.println(columnCount);

		Object[][] data=new Object[rowCount][columnCount];


		//For Rows
		for (int i = 1; i <= rowCount; i++) {

			XSSFRow row = sheet.getRow(i);

			//For Column
			for (int j = 0; j < columnCount; j++) {

				XSSFCell cell = row.getCell(j);
				if(cell == null){
					data[i-1][j]="";
					System.out.println("Blank Cell");
				}
				else if(cell.getCellType()== CellType.STRING){
					data[i-1][j]=cell.getStringCellValue();
					System.out.println(cell.getStringCellValue());
				}
				else if(cell.getCellType()== CellType.NUMERIC){
					data[i-1][j]=cell.getNumericCellValue();
					System.out.println(cell.getNumericCellValue());
				}				

			}
		}
		return data;
	}










}