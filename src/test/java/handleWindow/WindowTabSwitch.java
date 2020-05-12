package handleWindow;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowTabSwitch {
	
	static String title = null;
	static String pageTitle1 ;
	static Map<String, String> windowMap = new HashMap<String,String>();

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://seleniumpractise.blogspot.com/2017/07/multiple-window-examples.html");
		
		String parentWindow = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//a[contains(@href,'www.google.com')]")).click();
		driver.findElement(By.xpath("//a[contains(@href,'www.facebook.com')]")).click();
		driver.findElement(By.xpath("//a[contains(@href,'www.yahoo.com')]")).click();
		
		driver.switchTo().window(parentWindow);
		
		Set<String> allWindows = driver.getWindowHandles();
		
		for(String child : allWindows) {
			
			if(!child.equalsIgnoreCase(parentWindow)) {
				
				 driver.switchTo().window(child); 
				 title = driver.getTitle();
				 windowMap.put(title, child);
			}
		}
		driver.switchTo().window(parentWindow);
		
		for (String pageTitle : windowMap.keySet()) {
						
			pageTitle1 = pageTitle.toLowerCase();
			
			if (pageTitle1.contains("facebook")) {
				driver.switchTo().window(windowMap.get(pageTitle));
				System.out.println(driver.getTitle());
			}
		}
		
	}
}
