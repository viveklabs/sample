package cookieHandling;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class storeCookies {
	
	
	public  void storeCookie() {
		
		
	
	// create file named Cookie to store username Information
	File file = new File("Cookie.data");
	
	try { // Delete if any old file exists
	file.delete();
	file.createNewFile();
	FileWriter fileWriter = new FileWriter(file);
	BufferedWriter bufferwrite = new BufferedWriter(fileWriter);
	Set<Cookie> cokie = TestBase.getDriver().manage().getCookies();
	for(Cookie cook : cokie){
		System.out.println(cook.getName()+": "+ cook.getValue());
	String writeup = cook.getName()+";"+cook.getValue()+";"+cook.getDomain()+";"+cook.getPath()+""
	+ ";"+cook.getExpiry()+";"+cook.isSecure();
	bufferwrite.write(writeup);
	System.out.println(writeup);
	bufferwrite.newLine();
	}
	
	bufferwrite.flush();bufferwrite.close();fileWriter.close();
	}catch(Exception exp){
	exp.printStackTrace();
	}

}
}

