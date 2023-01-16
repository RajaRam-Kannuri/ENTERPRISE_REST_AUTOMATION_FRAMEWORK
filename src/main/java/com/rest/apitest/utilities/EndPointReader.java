package com.rest.apitest.utilities;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.Map;
public class EndPointReader {
	

		
		public EndPointReader(String path){
			this.jsonObject=readJson(path);
		}
		JSONObject jsonObject;
		private static JSONObject jsonFromFile;
		
		private static JSONObject readJson(String path) {
			 	
			JSONParser parser = new JSONParser();
			try {
				 jsonFromFile = (JSONObject)parser.parse(FileUtils.getFileReader(path));
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return jsonFromFile;
		}

		public Map<String, JSONObject> getEndpoints() {
			return (JSONObject) jsonObject.get("endpoints");
		}
		public Map<String, JSONObject> getPath(String path) {
			JSONObject pathObject = null;
			if (getEndpoints().containsKey(path)) {
				pathObject = (JSONObject) getEndpoints().get(path);
			} else {
				throw new RuntimeException(path + " is not available");
			}

			return pathObject;
		}

		public Object getAuth(String methodName){
			return getPath(methodName).get("authentication");
		}

		public Object getURI(String methodName){
			return getPath(methodName).get("uri");
		}
		public Object getHttpMethod(String methodName){
			return getPath(methodName).get("method");
		}
		

	}

