package Insight.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Insight.Base.Base;

public class LoginPage extends Base{
	
	@FindBy(xpath="//span[text()='Email Address']/parent::label/following-sibling::div/input")
	WebElement EmailAddress;
	
	@FindBy(xpath="//span[text()='Password']/parent::label/following-sibling::div/input")
	WebElement Password;
	
	@FindBy(xpath="//span[text()='Login']/parent::span/parent::button")
	WebElement LoginBtn;
	
	public LoginPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Login(String Email, String Pass)
	{
		EmailAddress.sendKeys(Email);
		Password.sendKeys(Pass);
		LoginBtn.click();
	}

}
