package excelPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelReadData {

	public static void main(String[] args) throws IOException {
		
		File f= new File("C:\\Users\\Kummari Bhikshapathi\\Desktop\\sample.xlsx");
		FileInputStream ip= new FileInputStream(f);
		Workbook wb= new XSSFWorkbook(ip);
		Sheet sht=wb.getSheet("Test1");	
		int rCount=sht.getLastRowNum();
		HashMap<String, String> map = new HashMap<String, String>();
		
		for (int r = 1; r < rCount+1; r++) {
			Row row=sht.getRow(r);
			Cell k=row.getCell(1);
			String Key=k.getStringCellValue().trim();
			
			Cell v=row.getCell(0);
			String val=v.getStringCellValue().trim();
			
			String[] s=Key.split("");
			if(s[0].equals("9")||s[0].equals("1"))
			{
				map.put(Key, val);
				System.out.println("This is the final created map : "+map);
			}
        }

	}

}
