package com.TestCases;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.BaseTest.BaseTest;
import com.DatabaseUtility.DatabaseConnection;
import com.DriverUtility.DriverManager;
import com.Enum.EnumForConfigFile;
import com.Pages.HomePage;
import com.Pages.SignInOrLoginPage;
import com.PropertyFileReader.ReadPropertyFile;

public class TestCase1 extends BaseTest{

	@Test
	public void validateHomePage() throws InterruptedException
	{
		WebDriver driver=DriverManager.getInstance().getDriver();
		driver.get(ReadPropertyFile.getValue(EnumForConfigFile.practiseWebsite1));
		HomePage homePage=new HomePage(driver);
		String expectedTitle="Automation Exercise";
		String actualTitle=homePage.getHomePageTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		homePage.clickOnSignInAndLogin();
		Thread.sleep(2000);
	}
	
	@Test
	public void testCaseLink() throws InterruptedException
	{
		WebDriver driver=DriverManager.getInstance().getDriver();
		driver.get(ReadPropertyFile.getValue(EnumForConfigFile.practiseWebsite1));
		HomePage homePage=new HomePage(driver);
		homePage.clickOnTestCase();
		Thread.sleep(2000);
	}
	
	//@Test
	public void dbdataValidation() throws SQLException, InterruptedException
	{
		WebDriver driver=DriverManager.getInstance().getDriver();
		driver.get(ReadPropertyFile.getValue(EnumForConfigFile.practiseWebsite1));
		HomePage homePage=new HomePage(driver);
		String expectedTitle="Automation Exercise";
		String actualTitle=homePage.getHomePageTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		homePage.clickOnSignInAndLogin();
		
		SignInOrLoginPage signIn=new SignInOrLoginPage(driver);
		 // Accessing the connection triggers lazy initialization of the connection
        ResultSet rs = DatabaseConnection.getUserData();
        String username = null;
        String email = null;
        // Process the ResultSet
        while (rs.next()) {
        	username = rs.getString("username");
        	email= rs.getString("email_address");
            System.out.println("Username: " + username + ", Email: " + email);
        }
		signIn.signUpAsNewUser(username, email);	
	}
	
	@Test
	public void mvnDataParameterCheck() throws InterruptedException
	{
		WebDriver driver=DriverManager.getInstance().getDriver();
		driver.get(ReadPropertyFile.getValue(EnumForConfigFile.practiseWebsite1));
		HomePage homePage=new HomePage(driver);
		String expectedTitle="Automation Exercise";
		String actualTitle=homePage.getHomePageTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		homePage.clickOnSignInAndLogin();
		Thread.sleep(2000);
		
		String username=System.getProperty("username");
		String emailId=System.getProperty("emailId");
		SignInOrLoginPage signIn=new SignInOrLoginPage(driver);
		signIn.signUpAsNewUser(username, emailId);
	}
	
	public void usingDataProvider() throws InterruptedException
	{
		WebDriver driver=DriverManager.getInstance().getDriver();
		driver.get(ReadPropertyFile.getValue(EnumForConfigFile.practiseWebsite1));
		HomePage homePage=new HomePage(driver);
		String expectedTitle="Automation Exercise";
		String actualTitle=homePage.getHomePageTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		homePage.clickOnSignInAndLogin();
		Thread.sleep(2000);
		
		
	}
}
