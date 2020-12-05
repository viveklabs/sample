package sample;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StoreAppInfo {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		driver.get("https://play.google.com/store/apps/details?id=com.whatsapp");
		// driver.get("https://play.google.com/store/apps/details?id=com.tencent.iglite");

		Map<String, String> addInfoDetails = new HashMap<String, String>();

		List<WebElement> addInfoKey = driver.findElements(By.xpath(
				"//c-wiz[@jsrenderer='HEOg8']//div/descendant::div[@class='JHTxhe IQ1z0d']/div[@class='IxB2fe']//descendant::div[@class='hAyfc']/descendant::div[@class='BgcNfc']"));

		List<WebElement> addInfoValue = driver.findElements(By.xpath(
				"//c-wiz[@jsrenderer='HEOg8']//div/descendant::div[@class='JHTxhe IQ1z0d']/div[@class='IxB2fe']//descendant::div[@class='hAyfc']"
						+ "/descendant::div[@class='BgcNfc']/parent::*//span/descendant::span"));

		for (int i = 0; i < addInfoKey.size(); i++) {
			addInfoDetails.put(addInfoKey.get(i).getText(), addInfoValue.get(i).getText());
		}

		for (Map.Entry<String, String> entry : addInfoDetails.entrySet())
			System.out.println(entry.getKey() + " = " + entry.getValue());

	}

}
