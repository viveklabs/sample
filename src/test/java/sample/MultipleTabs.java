package sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleTabs {

	static ArrayList<String> windowMap = new ArrayList<String>();

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.qafox.com/selenium/selenium-practice/");

		String parentWindow = driver.getWindowHandle();

		List<WebElement> allLinks = driver.findElements(By.xpath("//a[contains(text(),'Click here')]"));

		for (WebElement e : allLinks) {
			e.click();
		}
		driver.switchTo().window(parentWindow);

		Set<String> allWindows = driver.getWindowHandles();

		for (String child : allWindows) {

			if (!child.equalsIgnoreCase(parentWindow)) {

				windowMap.add(child);
			}
		}

		/*
		 * for (int i = windowMap.size() - 1; i >= 0; i--) {
		 * driver.switchTo().window(windowMap.get(i)); driver.close(); }
		 */
		
		 for (int i = 0; i<windowMap.size(); i++)  // to close the window in descending order
		 {
		 driver.switchTo().window(windowMap.get(i)); 
		 driver.close();
		 }
	}
}
