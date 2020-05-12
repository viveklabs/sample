package handleWindow;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windowpopup {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.naukri.com/");
		
		String parentWindow = driver.getWindowHandle();
		
		Set<String> allWindows = driver.getWindowHandles();
		
		for(String child : allWindows) {
			
			if(!child.equalsIgnoreCase(parentWindow)) {
				
				driver.switchTo().window(child);
				System.out.println(driver.getTitle());
				driver.close();
			}
		}
	}
}
