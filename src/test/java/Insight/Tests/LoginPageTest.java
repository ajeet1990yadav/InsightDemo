package Insight.Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Insight.Base.Base;
import Insight.Pages.LoginPage;
//import Insight.Utils.CaptureScreenshot;
import Insight.Utils.ExcelReader;

public class LoginPageTest extends Base {

	// Base B;
	LoginPage LP;
	ExcelReader ER = new ExcelReader();
	

	public LoginPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void start() throws IOException {
		// B=new Base();
		
		log = extent.startTest("LoginPageTest");
		Base.initalization();
	}

	@Test(dataProvider = "data")
	public void test(String email, String pass) throws IOException {
		LP = new LoginPage();
		// LP.Login(prop.getProperty("Email"), prop.getProperty("Pass"));
		// log.log(LogStatus.PASS, "Test Case Pass");
		LP.Login(email, pass);
		//Assert.assertTrue(false);

	}

	@AfterMethod
	public void aftermethod(ITestResult result) {

		//String path = CaptureScreenshot.capture();
		//System.out.println(path);
		if (result.getStatus() == ITestResult.FAILURE) {
			log.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			log.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
			// log.log(LogStatus.FAIL, log.addScreenCapture(path), "Test Case Fail");
			// log.log(LogStatus.FAIL, log.addScreenCapture(path));
			//log.log(LogStatus.FAIL, "Test Case Failed", log.addScreenCapture(path));
			String imagename=(System.currentTimeMillis()+"automationtestingscreenshot");
			Shutterbug.shootPage(driver).withName(imagename).save();
			String path="C:\\Users\\pankaj.sethi\\eclipse-workspace\\Insight\\screenshots\\"+imagename+".png";
			log.log(LogStatus.FAIL, "Test Case Failed", log.addScreenCapture(path));
			
		}
		else if (result.getStatus()==ITestResult.SUCCESS)
		{
			log.log(LogStatus.PASS, "Test Case Failed is " + result.getThrowable());
		}
		extent.endTest(log);
		driver.close();

	}

	@DataProvider(name = "data")
	public Object[][] dataprovider() throws IOException {
		ER = new ExcelReader();
		Object[][] obj = ER.exceldata("C:\\Users\\ajeet.yadav\\Desktop\\TestData.xlsx", "Sheet1");
		return obj;
	}

	// @DataProvider(name="Datanew2")
	// public ArrayList<ArrayList<String>> provideusinglist() throws IOException
	// {
	// ArrayList<ArrayList<String>> list1=ER.exceldata(prop.getProperty("path"),
	// prop.getProperty("sheetname"));
	// String str [][] = new String[list1.size()][list1.size()];
	// for(int i =0; i< list1.size(); i++) {
	// for(int j =0; j< list1.get(i).size(); j++) {
	// str[i][j] =
	// }
	// }
	// return list1;
	// }

	// data provider using 2D array
	@DataProvider(name = "Datanew")
	public String[][] dataprovidernew() throws IOException {
		// "C:\\Users\\ajeet.yadav\\Desktop\\TestData.xlsx"
		File file = new File(prop.getProperty("path"));
		FileInputStream fis = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheet(prop.getProperty("sheetname"));

		int row = sheet.getLastRowNum();

		int cell = sheet.getRow(row).getLastCellNum();
		System.out.println(row);
		System.out.println(cell);
		String array[][] = new String[row][cell];

		for (int i = 1; i <= row; i++) {

			for (int j = 0; j < cell; j++) {
				array[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				// System.out.println(abc);
			}
		}
		wb.close();
		return array;

	}

	// @AfterTest
	// public void stop() {
	//
	// extent.flush();
	// extent.close();
	//
	// }

}
