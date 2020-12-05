package sample;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	static WebDriver driver;

	public static void main(String[] args) {
		
		//In the below line of code, we will pass the path of chromedriver file we downloaded
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Users\\91821\\OneDrive\\Desktop\\My Workspace\\chromedriver_win32\\chromedriver.exe"
		 * );
		 * 
		 * WebDriver driver = new ChromeDriver();
		 */
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("file:///C:/Users/91821/OneDrive/Desktop/dd.html");
		
		// To get browser title
		String title = driver.getTitle();
		System.out.println("Title of page is: " + title);
		ArrayList<String> allPatternsEdition = new ArrayList<String>();
		
		List<WebElement> patternEdition = driver.findElements(By.xpath("//*[@class='gw-ListView--table-wrapper']//descendant::td[contains(@id, 'Edition_Cell')]//descendant::div[contains(@class,'gw-value-readonly-wrapper')]"));
		for (WebElement tempAllEdition : patternEdition) {
			if (tempAllEdition.getText().isEmpty()) {
				allPatternsEdition.add("blank");
			}else {
			allPatternsEdition.add(tempAllEdition.getText());
			}
		}
		
		System.out.println(allPatternsEdition.size());
		System.out.println(allPatternsEdition);
				

	}

}
