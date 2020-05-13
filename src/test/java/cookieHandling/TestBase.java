package cookieHandling;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	private  static WebDriver driver;

	
	public  void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		setDriver(driver);
	}
	

	public static WebDriver getDriver() {
		return driver;
	}

	public  void setDriver(WebDriver driver) {
		this.driver = driver;
	}

}
