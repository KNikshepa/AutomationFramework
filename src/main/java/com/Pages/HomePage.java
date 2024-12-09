package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ActionUtility.ActionsEngine;

public class HomePage extends ActionsEngine{

	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[text()=' Signup / Login']")
	WebElement signInAndLogin;
	
	@FindBy(xpath="//a[text()=' Test Cases']")
	WebElement testCaseLink;
	
	public String getHomePageTitle()
	{
		String actualTitle=getTitle_Custom();
		return actualTitle;
	}
	
	public void clickOnSignInAndLogin()
	{
		click_Custom(signInAndLogin, "Sign In and Login Hyperlink");
	}
	
	public void clickOnTestCase()
	{
		click_Custom(testCaseLink, "Test Case Link");
	}
}
