package sample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getHTMLContent {

	public static void main(String[] args) throws IOException {
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		/*
		 * driver.manage().window().maximize(); driver.manage().deleteAllCookies();
		 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 * 
		 * driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		 */
		
		URL url;

			url = new URL("https://www.google.com/");
			URLConnection conn = url.openConnection();

			BufferedReader br = new BufferedReader(
                               new InputStreamReader(conn.getInputStream()));

			String inputLine;

			String fileName = "C:\\Users\\91821\\OneDrive\\Desktop\\My Workspace\\sample\\src\\test\\java\\test.html";
			File file = new File(fileName);

			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			while ((inputLine = br.readLine()) != null) {
				bw.write(inputLine);
			}

			bw.close();
			br.close();


		
		StringBuilder contentBuilder = new StringBuilder();
		try {
		    BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\91821\\OneDrive\\Desktop\\My Workspace\\sample\\src\\test\\java\\test.html"));
		    String str;
		    while ((str = in.readLine()) != null) {
		        contentBuilder.append(str);
		    }
		    in.close();
		} catch (IOException e) {
		}
		String content = contentBuilder.toString();
		
		System.out.println(content);
		
		String a = content.substring(content.indexOf("80th"), content.indexOf("#GoogleDoodle"));
		
		System.out.println("--------------------------");
		System.out.println(a);

	

	}

}
