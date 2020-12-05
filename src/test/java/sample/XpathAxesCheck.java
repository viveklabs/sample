package sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathAxesCheck {
	
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		driver.get("https://www.guru99.com/");
		
		driver.findElement(By.xpath("//div[@class='canvas-middle']/a[@href='/unix-linux-tutorial.html']/ancestor::div[@class='g-block box4 size-17 hidden-tablet']/"
				+ "parent::div[@class='g-grid']//div/descendant::div[@class='canvas-middle']/a[@href='/bigdata-tutorials.html']/i")).click();
		
		

	}

}
