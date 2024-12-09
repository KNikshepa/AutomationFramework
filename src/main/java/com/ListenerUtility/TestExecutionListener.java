package com.ListenerUtility;

import java.sql.SQLException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.DatabaseUtility.DatabaseConnection;
import com.DriverUtility.DriverUtility;

public class TestExecutionListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {

	}

	@Override
	public void onTestSuccess(ITestResult result) {

	}

	@Override
	public void onTestFailure(ITestResult result) {
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		// This will trigger the lazy creation of connection
		System.out.println("Test Suite Started.");
		DatabaseConnection.getConnection(); // This line ensures connection is established
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test Suite Finished.");
		try {
			// Close the connection after all tests finish
			DatabaseConnection.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
