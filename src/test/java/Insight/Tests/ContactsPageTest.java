package Insight.Tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
	
	
	@BeforeClass
	public void start()
	{
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
	
	
	@AfterClass
	public void stop()
	{
		//driver.close();
	}

}
