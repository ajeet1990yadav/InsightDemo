package Insight.Tests;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.relevantcodes.extentreports.LogStatus;

import Insight.Base.Base;
import Insight.Pages.ContactsPage;
import Insight.Pages.LoginPage;

public class ContactsPageTest extends Base{
	
	LoginPage LP;
	ContactsPage CP;
	
	
	public ContactsPageTest() throws IOException
	{
		super();
	}
	
	
	@BeforeMethod
	public void start()
	{
		log = extent.startTest("ContactsPageTest");
		Base.initalization();
	}
	
	@Test
	public void test() throws IOException
	{
		
		
		LP=new LoginPage();
		CP=new ContactsPage();
		LP.Login(prop.getProperty("Email"), prop.getProperty("Pass"));
		CP.clickonDashboard();
	}
	
	
	@AfterMethod
	public void stop(ITestResult result)
	{
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

}
