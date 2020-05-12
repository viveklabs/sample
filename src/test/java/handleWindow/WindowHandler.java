package handleWindow;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandler {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://seleniumpractise.blogspot.com/2017/07/multiple-window-examples.html");
		
		String parentWindow = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//a[contains(@href,'www.google.com')]")).click();
		driver.findElement(By.xpath("//a[contains(@href,'www.facebook.com')]")).click();
		driver.findElement(By.xpath("//a[contains(@href,'www.yahoo.com')]")).click();
		
		Set<String> allWindows = driver.getWindowHandles();
		
		for(String child : allWindows) {
			
			if(!child.equalsIgnoreCase(parentWindow)) {
				
				driver.switchTo().window(child);
				System.out.println(driver.getTitle());
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
	}
}
