package com.TestCases;

import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DockerTest {

	public static void main(String[] args) throws Exception {
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
		driver.manage().window().maximize();

		driver.get("https://the-internet.herokuapp.com/");

		System.out.println(driver.getTitle());

		driver.quit();
	}
}
