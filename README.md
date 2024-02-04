# Steps to follow to setup Enterprise Rest Assured API automation Framework in local system:

**Install Java: [Skip this step if already installed]**
- Check if Java is installed.
  - In terminal enter java -version to check if java is installed in the system.
  - In terminal enter javac -version to check if java compiler is installed in the system.
  - Any version of java greater than 1.8 is supported.
  - Install java development kit if not available.

**Install Eclipse : [Skip this step if already installed]** 
  - Download eclipse installer.
  - Run eclipse installer.
  - Select install eclipse for java developers.
  - Open workbench.

**Setup project in Eclipse:** 
  - File -> Open Project from File System -> Browse the folder and open the cloned project.
  - Open -> Help -> Eclipse Marketplace -> Search testng -> Install Testng for eclipse plugin -> Restart eclipse.
  - Maven will be available by default, with eclipse. To check, right click on project -> should have an option called maven.
```
Possible issues:
In case of error in pom.xml file ->Cannot read lifecycle mapping metadata for artifact org.apache.maven.plugins:mav
  - In terminal open Users/<profile_name>/.m2
  - Run rm -r repository
  - Right click on project -> Update project
In case of error in all import statements
  - Click on src/main/java folder -> build path -> remove from build path
  - Click on src -> main -> java ->right click -> build path -> use as source folder
  - Refresh the project
````
**Set up verification**
  - In business logic package -> Right click on any java file -> run as testng test.

  
**HTML Report**
> Test Reports can be found in `workingDir/ExtentReports/ExtentReportResults.html`
**Test Summary**
![alt text](https://github.com/RajaRam-Kannuri/ENTERPRISE_REST_AUTOMATION_FRAMEWORK/blob/main/ExtentReports/reports%20sample%20img1.png?raw=true)

**Specific Test details**
![alt text](https://github.com/RajaRam-Kannuri/ENTERPRISE_REST_AUTOMATION_FRAMEWORK/blob/main/ExtentReports/reports%20sample%20img2.png?raw=true)
![alt text](https://github.com/RajaRam-Kannuri/ENTERPRISE_REST_AUTOMATION_FRAMEWORK/blob/main/ExtentReports/reports%20sample%20img3.png?raw=true)