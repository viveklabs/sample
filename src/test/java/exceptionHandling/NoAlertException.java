package exceptionHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NoAlertException {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		Thread.sleep(2000);
		
		try {
		driver.switchTo().alert().accept();
		
		} catch (Exception e) {
			
			System.out.println();
			System.out.println("----------------------------------");
			System.out.println("Exception is: " +e);
			System.out.println("----------------------------------");
			System.out.println("Exception handled");
		}
		
		System.out.println("----------------------------------");
		System.out.println("rest of the code");
		
	}

	}


