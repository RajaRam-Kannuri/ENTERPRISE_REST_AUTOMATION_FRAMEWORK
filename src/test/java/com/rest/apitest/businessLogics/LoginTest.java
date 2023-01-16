package com.rest.apitest.businessLogics;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.rest.apitest.actions.ValidatorOperation;
import com.rest.apitest.baseAPI.Auth;
import com.rest.apitest.listeners.ExtentTestManager;



public class LoginTest {
	
  String response;


  @Test(enabled=false)
  public void validLoginTest(Method method) {
	  
	  ExtentTestManager.startTest(method.getName(), "Description: Valid Login Scenario with username and password.");
	  System.out.println(method.getName());
	  Auth response = new Auth();
	  response.getLoginToken("admin", "password123");
	  
	  try {
		  //ExtentTestManager.getTest().log(LogStatus.INFO, "URL is: " +response.url)
		  response.assertIt(200);
		  ExtentTestManager.getTest().log(LogStatus.INFO, "Asserting response code");
		    
		  response.assertIt("token",null,ValidatorOperation.NOT_EMPTY);
		  ExtentTestManager.getTest().log(LogStatus.INFO, "Asserting response value not empty case");
		  
		  response.assertIt("token",null,ValidatorOperation.NOT_NULL);
		  ExtentTestManager.getTest().log(LogStatus.INFO, "Asserting response value not null case");
	  }
	  catch(AssertionError e){
		  ExtentTestManager.getTest().log(LogStatus.FAIL,"Assertion Failure: " +e.getMessage());
	  }
	  
	  
	 }
  
  @Test(enabled=false)
  public void invalidLoginTest(Method method) {
	  
	  ExtentTestManager.startTest(method.getName(), "Description: InValid Login Scenario with username and password.");
	  Auth response = new Auth();
	  response.getLoginToken("dummy", "dummypassword123");
	  
	  try {
		//ExtentTestManager.getTest().log(LogStatus.INFO, "URL is: " +response.url);		 
		  response.assertIt(200);
		  ExtentTestManager.getTest().log(LogStatus.INFO, "Asserting response code");
		  
		  response.assertIt("reason","Bad credentials",ValidatorOperation.EQUALS);
		  ExtentTestManager.getTest().log(LogStatus.INFO, "Asserting response value == Bad credentials");

	  }
	  catch(AssertionError e){
		  ExtentTestManager.getTest().log(LogStatus.FAIL,"Assertion Failure: " +e.getMessage());
	  }	 
	  
	 }

}
