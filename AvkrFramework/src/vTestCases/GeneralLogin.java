package vTestCases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.Test;

import vReusableMethods.ReusableMethods;

//import vReusableMethods.ReusableMethods;

public class GeneralLogin extends ReusableMethods {

	@Test
	public void loginApplication() throws IOException{
		
    	chromeBrowser();
    	driver.get(getProperties("url"));
    	
    	perform("name@@Name",getProperties("name"),"send");
    	perform("name@@Email",getProperties("email"),"send");
    	perform("name@@Submit","none","click");

    	

		
	}

}
