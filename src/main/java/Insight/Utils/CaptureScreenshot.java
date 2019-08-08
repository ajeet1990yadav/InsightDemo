package Insight.Utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import Insight.Base.Base;

public class CaptureScreenshot extends Base{

	public CaptureScreenshot() throws IOException {
		super();
	}
	
	@Test
	public static String capture()
	{
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		File Dest = new File("src/../test/" + System.currentTimeMillis()+ ".png");
		
		String errflpath = Dest.getAbsolutePath();
		
		try {
			FileUtils.copyFile(scrFile, Dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(errflpath);
		return errflpath;

	}
	
	

}
