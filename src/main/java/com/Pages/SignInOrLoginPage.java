package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ActionUtility.ActionsEngine;

public class SignInOrLoginPage extends ActionsEngine{

	private WebDriver driver;
	
	public SignInOrLoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='name']")
	WebElement userName;
	
	@FindBy(xpath="//input[@name='email'][@data-qa='login-email']")
	WebElement emailId;
	
	@FindBy(xpath="//button[text()='Signup']")
	WebElement signUpLink;
	
	public void signUpAsNewUser(String userNm,String emailAddress) throws InterruptedException
	{
		sendKeys_Custom(userName, userNm, "User Name");
		sendKeys_Custom(emailId, emailAddress, "Email Address");
		Thread.sleep(2000);
		click_Custom(signUpLink, "Sign Up Hyperlink");
		Thread.sleep(2000);
	}	
}
