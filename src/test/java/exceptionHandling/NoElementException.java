package exceptionHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NoElementException {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		Thread.sleep(2000);
		
		try {
		driver.findElement(By.name("fake")).click(); // This line will throw 
		//NoSuchElementException as this element is not present in 
		//Google web page
		
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
