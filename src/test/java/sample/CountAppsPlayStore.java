package sample;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CountAppsPlayStore {

	static WebDriver driver;
	static Map<String, String> allAppMap = new HashMap<String, String>();

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		driver.get(
				"https://play.google.com/store/apps/collection/cluster?clp=ogoKCAEqAggBUgIIAQ%3D%3D:S:ANO1ljJG6Aw&gsr=Cg2iCgoIASoCCAFSAggB:S:ANO1ljLKNqE&hl=en");

		for (int i = 10; i >= 0; i--) {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			// Wait to load the scrolled page
			Thread.sleep(1000);
		}

		List<WebElement> totalNoOfApps = driver.findElements(By.xpath(
				"//h2[contains(text(),'Recommended for you')]/parent::div[@class = 'xwY9Zc']/parent::div[@class='Z3lOXb']"
						+ "/following-sibling::div[@class='ZmHEEd ']//div/descendant::div[@class='uzcko']"));

		System.out.println("Total Apps in page: " + totalNoOfApps.size());

		List<WebElement> allAppName = driver.findElements(By.xpath(
				"//h2[contains(text(),'Recommended for you')]/parent::div[@class = 'xwY9Zc']/parent::div[@class='Z3lOXb']"
						+ "/following-sibling::div[@class='ZmHEEd ']//div/descendant::div[@class='uzcko']/following-sibling::div[@class='RZEgze']//div/descendant::div[@class='WsMG1c nnK0zc']"));

		List<WebElement> allAppLink = driver.findElements(By.xpath(
				"//h2[contains(text(),'Recommended for you')]/parent::div[@class = 'xwY9Zc']/parent::div[@class='Z3lOXb']"
						+ "/following-sibling::div[@class='ZmHEEd ']//div/descendant::div[@class='uzcko']/following-sibling::div[@class='RZEgze']//div/descendant::div[@class='WsMG1c nnK0zc']/parent::a"));

		Iterator<WebElement> i1 = allAppName.iterator();
		Iterator<WebElement> i2 = allAppLink.iterator();

		while (i1.hasNext() || i2.hasNext()) {
			allAppMap.put(i1.next().getText(), i2.next().getAttribute("href"));
		}

		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * 
		 * for (Map.Entry<String, WebElement> entry : allAppMap.entrySet()) {
		 * System.out.println(entry.getKey()); System.out.println("--------------");
		 * 
		 * if (entry.getKey().equalsIgnoreCase("Instagram")) {
		 * js.executeScript("arguments[0].click();", entry.getValue()); }
		 * 
		 * }
		 */

		for (Map.Entry<String, String> entry : allAppMap.entrySet()) {

			System.out.println(entry.getKey() + " = " + entry.getValue());
			System.out.println("------------------------------------------------");

		}

	}

}
