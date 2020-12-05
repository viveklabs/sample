package sample;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PopupTest {

	static Set<String> windowIds;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		// driver.manage().timeouts().setScriptTimeout(3, TimeUnit.SECONDS);

		driver.get("http://popuptest.com/");

		String parentWindowID = driver.getWindowHandle();
		System.out.println("Parent Window ID is: " + parentWindowID);
		System.out.println("Parent window Page title: " + driver.getTitle());

		driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[1]/font[3]/b/a")).click();

		while (true) {
			windowIds = driver.getWindowHandles();

			if (windowIds.size() > 1) {
				break;
			}
		}
		Iterator<String> it = windowIds.iterator();

		for (String child : windowIds) {

			if (!child.equalsIgnoreCase(parentWindowID)) {

				driver.switchTo().window(child);
				System.out.println("Parent Window ID is: " + child);
				System.out.println("Child window Page title: " + driver.getTitle());
				driver.close();
			}
		}

		driver.switchTo().window(parentWindowID);
		System.out.println("parent window URL: " + driver.getCurrentUrl());

	}
}

