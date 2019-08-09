package Insight.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Base {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public static ExtentReports extent;
	public static ExtentTest log;
	
	@BeforeSuite
	public void beforesuite()
	{
		extent = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults.html", true);
	}
	
	@AfterSuite
	public void aftersuite()
	{
		extent.flush();
		extent.close();
	}
	
	public Base() throws IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\pankaj.sethi\\eclipse-workspace\\Insight\\Config.properties");
		prop=new Properties();
		prop.load(fis);
		
		
				
		
	}
	
	
	
	public static void initalization()
	{
		
		String browser=prop.getProperty("Browser");
		if (browser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\software\\Selenium\\ChromeDriver\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if (browser.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\software\\Selenium\\GeckoDriver\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
	
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://dashboard.optimisemedia.com/");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	
	
	}
}
