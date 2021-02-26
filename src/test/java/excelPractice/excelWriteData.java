package excelPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelWriteData {

	public static void main(String[] args) throws IOException {
		File f= new File("C:\\Users\\Kummari Bhikshapathi\\Desktop\\sample.xlsx");
		FileInputStream ip= new FileInputStream(f);
		Workbook wb=new XSSFWorkbook(ip);
	    Sheet sh= wb.getSheet("Test1");
	    int  rowcount=sh.getLastRowNum();
	    Row r=sh.getRow(0);
	    
	    Row newRow=sh.createRow(rowcount+1);
	     for(int j=0;j<r.getLastCellNum();j++)
	     {
	    	 Cell cell=newRow.createCell(j);
	    	 cell.setCellValue("test");
	     }
	     ip.close();
	     
	     FileOutputStream op= new FileOutputStream(f);
	     wb.write(op);
		 op.close();

		
		
	}

}
