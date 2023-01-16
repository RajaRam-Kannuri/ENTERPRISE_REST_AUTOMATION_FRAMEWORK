package com.rest.apitest.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {
	
	static FileWriter fileWritter;

	public static FileReader getFileReader(String path, String fileName) throws FileNotFoundException {
		System.out.println("=======getFileReader"+"==="+path+"==="+fileName);
		//Path resourceDirectory = Paths.get("src", "main", "resources", path, fileName);
		Path resourceDirectory = Paths.get(System.getProperty("user.dir"), path, fileName);
		String absolutePath = resourceDirectory.toFile().getAbsolutePath();
		FileReader fileReader = new FileReader(absolutePath);

		return fileReader;
	}
	public static void writeDataInToJsonFile(String data, String filePath) {
		//Path resourceDirectory = Paths.get("src", "main", "resources","service_data");
		Path resourceDirectory = Paths.get(System.getProperty("user.dir"),"service_data");
		try {
			fileWritter = new FileWriter(filePath);
			fileWritter.write(data);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally {
			try {
				fileWritter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static FileReader getFileReader(String path) throws FileNotFoundException {
		
		Path resourceDirectory = Paths.get(path);
		String absolutePath = resourceDirectory.toFile().getAbsolutePath();
		FileReader fileReader = new FileReader(absolutePath);

		return fileReader;
	}
}


