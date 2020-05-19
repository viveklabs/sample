package exceptionHandling;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NoFrameException {


	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		Thread.sleep(2000);
		
		try {
		driver.switchTo().frame(0);
		
		} catch (Exception e) {
			
			System.out.println();
			System.out.println("----------------------------------");
			System.out.println("Exception is: " +e);
			System.out.println("----------------------------------");
			System.out.println("Exception handled");
			throw(e); // even if the exception is handled it will
			// throw the exception
		}
		
		finally {
		System.out.println("----------------------------------");
		System.out.println("rest of the code");
		}

	}

	}


