package sample;

import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsConcept {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91821\\OneDrive\\Desktop\\My Workspace\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com");

		List<WebElement> linklist = driver.findElements(By.tagName("a")); // using findElements to get all links present in page with "a" tag
		
		System.out.println(linklist.size()); // getting the size of list
		
		Iterator<WebElement> it = linklist.iterator(); // traversing the list
		
		while (it.hasNext()) {
			
			WebElement element = it.next();
			System.out.println(element.getText());			
		}

	}

}
