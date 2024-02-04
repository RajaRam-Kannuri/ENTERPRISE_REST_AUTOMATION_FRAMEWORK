package com.rest.apitest.businessLogics;

import java.lang.reflect.Method;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import com.rest.apitest.actions.EndPointMethods;
import com.rest.apitest.actions.ValidatorOperation;
import com.rest.apitest.baseAPI.Auth;
import com.rest.apitest.listeners.ExtentTestManager;

public class GetNextBirthday
{
	
	@Test
	public static void getNextBirthday(Method method)
	{
		  //Test 1 - Positive Test Case 
		  ExtentTestManager.startTest("As a User I should be able to get the Next Birthday Date by inputting the Date Of Birth Valid DOB");
		  Auth response = new Auth();
		  response.getNextBirthday(EndPointMethods.GET_NEXT_BIRTHDAY_POSITIVE_SCENARIO.toString());
		  System.out.println(response.getResponseString());
		  try {
			  ExtentTestManager.getTest().log(LogStatus.INFO, "URL is: " +response.url);
			  
			  //Verifying the Response Code
			  response.assertIt(200);
			  
			  //Provide the TagName to Verify it's Value 
			  response.assertIt("NextBirthday","2024-03-05",ValidatorOperation.EQUALS);
			  
			  ExtentTestManager.getTest().log(LogStatus.INFO, "Asserting response code:"+response.getStatusCode());
			    
		  }
		  catch(AssertionError e){
			  ExtentTestManager.getTest().log(LogStatus.FAIL,"Assertion Failure: " +e.getMessage());
		  }
		  
		  //Test2
		  ExtentTestManager.startTest("As a User I when I send the Inappropriate DOB in the Query String it should return 400 Error Message");
		  
		  response.getNextBirthday(EndPointMethods.GET_NEXT_BIRTHDAY_NEGATIVE_SCENARIO.toString());
		  System.out.println(response.getResponseString());
		  System.out.println(response.url);
		  try {
			  ExtentTestManager.getTest().log(LogStatus.INFO, "URL is: " +response.url);
			  
			  //Verifying the Response Code
			  response.assertIt(400);
			  
			  //Provide the TagName to Verify it's Value 
			  response.assertIt("error","Invalid date format and Date format Should be YYYY-MM-DD",ValidatorOperation.EQUALS);
			  
			  ExtentTestManager.getTest().log(LogStatus.INFO, "Asserting response code:"+response.getStatusCode());
			    
		  }
		  catch(AssertionError e){
			  ExtentTestManager.getTest().log(LogStatus.FAIL,"Assertion Failure: " +e.getMessage());
		  }
	}

}