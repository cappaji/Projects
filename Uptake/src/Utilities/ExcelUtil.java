package Utilities;

import java.io.File;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	XSSFWorkbook workBook;
	XSSFSheet sheetName;
	XSSFCell cell;
	
	String filePath;
	String shtname;
	
	public ExcelUtil(String filePath, String shtname){
		this.filePath = filePath;
		this.shtname = shtname;
		setExcelFile();
	}
	
	public void setExcelFile(){
		File file  = new File(filePath);
		try{
		workBook = new XSSFWorkbook(file);
		sheetName = workBook.getSheet(shtname);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public int noOfRows(){
		int row = sheetName.getLastRowNum();
		return row;
	}
	
	public int noOfColumns(){
		int row = sheetName.getLastRowNum();
		Row r = sheetName.getRow(row);
		int column=  r.getLastCellNum();
		return column;
	}
	
	public String getCellValue(int rowNum, int colNum){
		XSSFRow row = sheetName.getRow(rowNum);
		cell = row.getCell(colNum);
		
//		System.out.println(cell);
		
//		String cellValue = cell.getStringCellValue();
		
		return cell.toString().trim();
	}

}
