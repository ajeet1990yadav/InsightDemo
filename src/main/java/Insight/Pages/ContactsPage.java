package Insight.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Insight.Base.Base;

public class ContactsPage extends Base{
	
	@FindBy(xpath="//span[text()='Dashboard']")
	WebElement DashboardBtn;
	
	
	public ContactsPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickonDashboard()
	{
		DashboardBtn.click();
	}
	

}
