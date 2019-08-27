package Insight.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelReader {
	
	
	public Object[][] exceldata(String path, String sheetname) throws IOException
	{		
		//"C:\\Users\\ajeet.yadav\\Desktop\\TestData.xlsx"
		File file=new File(path);
		FileInputStream fis=new FileInputStream(file);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		XSSFSheet sheet=wb.getSheet(sheetname);
		
		int row=sheet.getLastRowNum();
		
		int cell=sheet.getRow(row).getLastCellNum();
		System.out.println(row);
		System.out.println(cell);
	    Object[][] array= new Object[row][cell];
		
		for (int i=1; i<=row; i++)
		{
	     for(int j=0;j<cell;j++)
			{
			CellType type=sheet.getRow(i).getCell(j).getCellType();
		     System.out.println(type);
		      if (type.name().equals("STRING"))
		        {
				array[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
				 }
//		         else if (type.name().equals("NUMERIC"))
//		         	{
//                   array[i-1][j]=sheet.getRow(i).getCell(j).getNumericCellValue();
//			System.out.println(sheet.getRow(i).getCell(j).getNumericCellValue());
//		}
		         else
	               {
		        	 array[i-1][j]=sheet.getRow(i).getCell(j).getRawValue();
	        	     System.out.println(sheet.getRow(i).getCell(j).getRawValue());
		              }
			}
		}
		
//		Iterator<Object> itr=list.iterator();
//		while(itr.hasNext())
//		{
//		
//		System.out.println(itr.next());
//		
//		}
		
		wb.close();
		return array;
		
	}
	
	@Test
	public void test() throws IOException
	{
		exceldata("C:\\Users\\ajeet.yadav\\Desktop\\TestData.xlsx", "Sheet1");
	}
	
	

}
