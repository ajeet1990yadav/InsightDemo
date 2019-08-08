package Insight.Tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Insight.Base.Base;
import Insight.Pages.ContactsPage;
import Insight.Pages.DashboardPage;
import Insight.Pages.LoginPage;

public class DashboardPageTest extends Base{
	
	LoginPage LP;
	ContactsPage CP;
	DashboardPage DP;
	
	public DashboardPageTest() throws IOException
	{
		super();
	}
	
	@BeforeClass
	public void start()
	{
		Base.initalization();
	}
	
	@Test
	public void test() throws IOException, InterruptedException
	{
		
		LP=new LoginPage();
		CP=new ContactsPage();
		DP=new DashboardPage();
		LP.Login(prop.getProperty("Email"), prop.getProperty("Pass"));
		CP.clickonDashboard();
		DP.selectmanager();
		
		
	}
	
	@AfterClass
	public void stop()
	{
		//driver.close();
	}
	
	


}
