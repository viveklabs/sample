package sample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleSVGElements {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.flipkart.com");
		
		driver.findElement(By.xpath("//div[@class='_3Njdz7']/button")).click();
		
		driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).sendKeys("mobile");
		
		List<WebElement> svgList = driver.findElements(By.xpath("//*[name()='svg']//*[local-name()='g']//*[local-name()='path']"));
		
		for (WebElement ele : svgList) {
			String s = ele.getAttribute("d");
			System.out.println(s);
			
		}
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

}
