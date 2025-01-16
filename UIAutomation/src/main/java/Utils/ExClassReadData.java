package Utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExClassReadData
{

	public static String[][] readMethod(String file) throws IOException
	{
		
		XSSFWorkbook wb=new XSSFWorkbook("./src/main/java/data/"+file+".xlsx");
		XSSFSheet sheet1 = wb.getSheet("Sheet1");
		XSSFRow row = sheet1.getRow(0) ;
		
		int lastRowNum = sheet1.getLastRowNum();
		int lastCellNum = row.getLastCellNum();
		String[][] readdata=new String[lastRowNum][lastCellNum];
		
		for(int i=1;i<=lastRowNum;i++)
		{	 
			{
		
				for(int j=0;j<row.getLastCellNum();j++)
				{
					readdata[i-1][j]= sheet1.getRow(i).getCell(j).getStringCellValue();
				
				
				}
				
			}
		}
		
		wb.close();
		
		return readdata;
		
		
	}
}
