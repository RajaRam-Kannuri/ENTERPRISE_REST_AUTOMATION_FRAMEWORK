package com.rest.apitest.baseAPI;

import org.apache.http.params.CoreConnectionPNames;

import com.rest.apitest.actions.HttpOperation;
import com.rest.apitest.restassuredFuntions.API;
import com.rest.apitest.utilities.Constants;
import com.rest.apitest.utilities.EndPointReader;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;

public class Auth extends API{
	

	public  EndPointReader reader = new EndPointReader(Constants.ENDPOINT_JSON_FILEPATH);
    public Auth(){}
      
    /**
     * Creates a new auth token to use for access to the PUT and DELETE /booking
     * 
     * */
    private void createToken(String userName, String passWord) {
		initBase("Host");
		init("/auth", HttpOperation.POST);
		setHeader("Content-Type","application/json");
		setBody("{ \"username\" : \""+userName+"\", \"password\" : \""+passWord+"\"}");
	}
	

	/**
	 * @param	userName (Username string value for the restful bokker application) 			
	 * 			passWord (password string value for the restful bokker application)
	 * 
	 * @return 	returns login token
	 * */
	public String getLoginToken(String userName, String passWord) {
		createToken(userName, passWord);
		String response = callIt();
		//System.out.println(response);
		return response;
	}
	
	public String getUnixTimeStamp(String method)
	{
		initBase("Host");
		init(reader.getURI(method).toString(), reader.getHttpMethod(method).toString());
		setHeader("User-Agent","Rest-Assured/4.3.0");
//		setHeader("Content-Type", "application/json");
//        setHeader("accept","*/*");
		String response = callIt();
		return response;
	}
	public String getNextBirthday(String method)
	{
		initBase("Host");
		init(reader.getURI(method).toString(), reader.getHttpMethod(method).toString());
		System.out.println(reader.getURI(method).toString());
		setHeader("User-Agent","Rest-Assured/4.3.0");
//		setHeader("Content-Type", "application/json");
//        setHeader("accept","*/*");
		String response = callIt();
		return response;
	}

	
	
}
