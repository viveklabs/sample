package sample;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DebugGoogleSearchCode {

	public static void main(String[] args) {
				
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.MILLISECONDS);
				//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.manage().deleteAllCookies();
				//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.MILLISECONDS);
				
				driver.get("https://www.google.com");
				
				//driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("testing");
				
				driver.findElement(By.name("q")).sendKeys("Selenium");
				
				
				List<WebElement> searchList = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbl1']"));
				
				System.out.println("Total Search Suggestion : "+ searchList.size());
				
				for (int i=0; i<searchList.size();i++) {
					
					if (searchList.get(i).getText().contains("question")) {
						searchList.get(i).click();
						break;
					}
				}
				
				//driver.quit();

			}



	}

