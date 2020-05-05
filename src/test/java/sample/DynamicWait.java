package sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicWait {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91821\\OneDrive\\Desktop\\My Workspace\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// Dynamic Wait
		driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS); // page load timeout
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);  //implicit wait
		
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Add-Ons')]"));	
		clickOn(driver, element, 20);
		
	}
	
	public static void clickOn(WebDriver driver, WebElement locator, int timeout ) {  //explicit wait
		
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
			.until(ExpectedConditions.elementToBeClickable(locator));
		
		locator.click();
	}

}
