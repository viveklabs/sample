package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookRegister {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91821\\OneDrive\\Desktop\\My Workspace\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com");
		
		// To get browser title
		String title = driver.getTitle();
		System.out.println("Title of page is: " + title);
		
		//Enter First Name in required test box using XPATH
		driver.findElement(By.xpath("//input[@name = 'firstname']")).sendKeys("Vivek");
		
		//Enter Surname in required test box using ID
		driver.findElement(By.id("u_0_o")).sendKeys("Prasad");
		
		//Enter Email address using CCS Selector
		driver.findElement(By.cssSelector("input#email")).sendKeys("abc@gmail.com");
		
		//Get the text of link using LinkText
		String forgotPasswordText = driver.findElement(By.linkText("Forgotten account?")).getText();
		System.out.println(forgotPasswordText);
		
		//Enter password using Name
		driver.findElement(By.name("reg_passwd__")).sendKeys("test123");
		
		//Get the link name using Partial Link Text
		System.out.println(driver.findElement(By.partialLinkText("Data")).getText());
		
		
				
		

	}

}
