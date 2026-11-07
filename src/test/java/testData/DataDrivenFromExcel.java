package testData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;


public class DataDrivenFromExcel {
										//Sheet1
	public Object[][] getDataFromExcel(String sheetName) throws IOException
	{
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\java\\testData\\Axis_Online_Application_Form.xlsx");
		FileInputStream fis = new FileInputStream(file);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
	
		Object[][] data = new Object[rowCount -1][1];
		DataFormatter formatter = new DataFormatter();
		
		for(int i =1;i<rowCount;i++)
		{
			Row row = sheet.getRow(i);
			HashMap<String,String> map = new HashMap<>();
			
			for(int j = 0;j<colCount;j++)
			{
				String key = formatter.formatCellValue(sheet.getRow(0).getCell(j));
				String value = formatter.formatCellValue(row.getCell(j));
				map.put(key, value);
			}
			data[i-1][0] = map;
		}
		
		workbook.close();
		fis.close();
		
		return data;
		
	}
	
}
