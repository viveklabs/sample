package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrames {

	public static void main(String[] args) {
		

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91821\\OneDrive\\Desktop\\My Workspace\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("file:///C:/Users/91821/3D%20Objects/frames.htm");
		
		driver.switchTo().frame("iframe_a");
		
		System.out.println(driver.findElement(By.xpath("//p[contains(text(),'Learn HTML Code, Tags & CSS')]")).getText());
		
		driver.switchTo().defaultContent(); // This line is for returning the focus to main window so that below element can be tracked
		
		System.out.println(driver.findElement(By.xpath("//p[contains(text(),'Part of webpage')]")).getText());
		
	

	}

}
