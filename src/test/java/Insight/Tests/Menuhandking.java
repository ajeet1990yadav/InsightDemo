package Insight.Tests;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Menuhandking {
	
	WebDriver driver;
	
	
	@BeforeMethod
	public void start()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\software\\Selenium\\ChromeDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://www.globalsqa.com/demo-site/select-dropdown-menu/");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() throws InterruptedException
	{
		Select drp=new Select(driver.findElement(By.xpath("//div[@class='information closable']/following-sibling::p/select")));
		List<WebElement> list=drp.getOptions();
		
		for(int i=0;i<list.size();i++)
		{
			//drp.selectByIndex(i);
			//Thread.sleep(2000);
			WebElement el=list.get(i);
			for (int j=list.size()-1;j>i;j--)
			{
				if(el.equals(list.get(j)))
						{
					System.out.println("Duplicate Element is " + el);
						}
			}
			
		}
		
		System.out.println(list.size());
	}
	
	@AfterMethod
	public void close()
	{
		driver.close();
	}

}
