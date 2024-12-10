package com.ScreenshotUtility;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.DriverUtility.DriverManager;

public class ScreenshotUtility {

	public static File captureFullScreen()
	{
		File src=((TakesScreenshot)DriverManager.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
		Robot robot=null;
		
		try {
			robot=new Robot();
		}catch (AWTException e) {
			e.printStackTrace();
		}
		
		Rectangle screenRectangle=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage screenCapture=robot.createScreenCapture(screenRectangle);
		String timestamp=new SimpleDateFormat("yyyy-mm-dd_HH-mm-ss").format(new Date());
		
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+timestamp+".png";
		File destination=new File(screenshotPath);
		try {
			try {
				ImageIO.write(screenCapture, "png", destination);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return destination;
	}
}
