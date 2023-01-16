package com.rest.apitest.businessLogics;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.rest.apitest.actions.EndPointMethods;
import com.rest.apitest.actions.ValidatorOperation;
import com.rest.apitest.baseAPI.Auth;
import com.rest.apitest.listeners.ExtentTestManager;

public class UnixTimeStamp {
	
	
	@Test
	public static void getTimeStampforDate(Method method)
	{
		ExtentTestManager.startTest(method.getName(), "Description: As a User I should be able to convert the Date String to Unix Time");
		  System.out.println(method.getName());
		  Auth response = new Auth();
		  response.getUnixTimeStamp(EndPointMethods.DATE_STRING_TO_UNIX.toString());
		  System.out.println(response.getResponseString());
		  System.out.println(response.url);
		  try {
			  ExtentTestManager.getTest().log(LogStatus.INFO, "URL is: " +response.url);
			  response.assertIt(200);
			  response.assertIt("2016-01-01 02:03:22",ValidatorOperation.EQUALS_WITH_QUOTES);
			  ExtentTestManager.getTest().log(LogStatus.INFO, "Asserting response code");
			    
//			  response.assertIt("token",null,ValidatorOperation.NOT_EMPTY);
//			  ExtentTestManager.getTest().log(LogStatus.INFO, "Asserting response value not empty case");
//			  
//			  response.assertIt("token",null,ValidatorOperation.NOT_NULL);
//			  ExtentTestManager.getTest().log(LogStatus.INFO, "Asserting response value not null case");
		  }
		  catch(AssertionError e){
			  ExtentTestManager.getTest().log(LogStatus.FAIL,"Assertion Failure: " +e.getMessage());
		  }
	}

}
