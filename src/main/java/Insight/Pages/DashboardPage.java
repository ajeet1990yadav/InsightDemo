package Insight.Pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import Insight.Base.Base;

public class DashboardPage extends Base{

	@FindBy(xpath="//span[text()='Account Manager']/parent::label/following-sibling::div/div/div")
	WebElement AccountManagerdropdown;
	
	@FindBy(xpath="//li[text()='Ajeet Yadav']")
	WebElement Manager;
	
	public DashboardPage() throws IOException
	{ 
		PageFactory.initElements(driver, this);
	}
	
	
	public void selectmanager() throws InterruptedException
	{
			
		//Thread.sleep(20000);
	    WebDriverWait wait = new WebDriverWait(driver, 25);
	    AccountManagerdropdown = wait.until(ExpectedConditions.elementToBeClickable(AccountManagerdropdown));
		
//		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//		        .withTimeout(30, TimeUnit.SECONDS)
//		        .pollingEvery(5, TimeUnit.SECONDS);
//		
		AccountManagerdropdown.click();
		//Thread.sleep(3000);
		Manager.click();
	}
	
	
	
}
