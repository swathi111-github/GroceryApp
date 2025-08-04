package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	static FileInputStream f;
	static XSSFWorkbook wb; 
	static XSSFSheet sh; 
		public static String getStringData(String path,String sheetName,int a,int b) throws IOException 
	{
		f=new FileInputStream(path);
		wb= new XSSFWorkbook(f);
		sh=wb.getSheet(sheetName); 
		XSSFRow r =sh.getRow(a); 
		XSSFCell c = r.getCell(b); 
		return c.getStringCellValue(); 
	}
	
	
	
	

}
