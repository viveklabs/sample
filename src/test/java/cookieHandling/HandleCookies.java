package cookieHandling;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCookies extends TestBase{
	
	Cookie ck;
	

	public void injectCookies() {
		try{
			File file = new File("Cookie.data");
			FileReader fileReader = new FileReader(file);
			BufferedReader Buffreader = new BufferedReader(fileReader);
			String strline;
			while((strline=Buffreader.readLine())!=null){
			StringTokenizer token = new StringTokenizer(strline,";");
			while(token.hasMoreTokens()){
			String name = token.nextToken();String value = token.nextToken();
			String domain = token.nextToken();String path = token.nextToken();
			Date expiry = null;
			String val = token.nextToken();
			System.out.println(val);
			DateFormat formatter = new SimpleDateFormat("E MMM dd hh:mm:ss Z yyyy");
			
			
			if(!(val.equals("null"))){
			expiry = formatter.parse(val);
			}
			
			Boolean isSecure = new Boolean(token.nextToken()).booleanValue();
			ck = new Cookie(name,value,domain,path,expiry,isSecure);
			TestBase.getDriver().manage().addCookie(ck); // This will add the stored cookie to our current session
			System.out.println("injection done");
			}
			}
			}catch(Exception ex){
			ex.printStackTrace();
			}

	}

	}

