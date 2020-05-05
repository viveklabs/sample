package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovement {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91821\\OneDrive\\Desktop\\My Workspace\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.spicejet.com/");
		
		Thread.sleep(4000);
		Actions action = new Actions(driver);
		
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Add-Ons')]"))).build().perform();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[contains(text(),'SpiceMax')]")).click();
	
	}

}
