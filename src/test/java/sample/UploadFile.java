package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFile {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91821\\OneDrive\\Desktop\\My Workspace\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://html.com/input-type-file/");
		
		// Inspect Choose FIle element and using send keys enter the path of the file to upload
		driver.findElement(By.id("fileupload")).sendKeys("C:\\Users\\91821\\OneDrive\\Pictures\\Camera Roll\\sampleIMG.jpg");


	}

}
