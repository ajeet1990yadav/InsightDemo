package Insight.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Base {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public static ExtentReports extent;
	public static ExtentTest log;
	//public static DesiredCapabilities cap;
	
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
	
	
	
	public static void initalization(String browser) throws MalformedURLException
	{
		
		//String browser=prop.getProperty("Browser");
		if (browser.equals("Chrome"))
		{
			//new DesiredCapabilities();
//			cap=new DesiredCapabilities();
//			cap.setBrowserName("chrome");
//			cap.setPlatform(Platform.WINDOWS);
			System.setProperty("webdriver.chrome.driver", "C:\\software\\Selenium\\ChromeDriver\\chromedriver.exe");
			//ChromeOptions options=new ChromeOptions();
			//options.merge(cap);
			driver=new ChromeDriver();
			//driver=new RemoteWebDriver(new URL("http://192.168.28.100:4444/wd/hub"),options);
		}
		else if (browser.equals("FF"))
		{
//			cap=new DesiredCapabilities();
//			cap.setBrowserName("firefox");
//			cap.setPlatform(Platform.WINDOWS);
			System.setProperty("webdriver.gecko.driver", "C:\\software\\Selenium\\GeckoDriver\\geckodriver.exe");
			//FirefoxOptions options=new FirefoxOptions();
			//options.merge(cap);
			driver=new FirefoxDriver();
			//driver=new RemoteWebDriver(new URL("http://192.168.28.100:4444/wd/hub"),options);
		}
	
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://dashboard.optimisemedia.com/");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	
	
	}
}
