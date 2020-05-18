package cookieHandling;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestCasesTest extends TestBase{
	
	TestBase base = new TestBase();
	HandleCookies handleCookies = new HandleCookies();
	storeCookies store = new storeCookies();
	
	
	@BeforeTest
	public void setup1() {
		base.setup();
		
	}
	
	@Test(enabled = false)
	public void login() {
		
		/*
		 * TestBase.getDriver().get("https://www.facebook.com");
		 * TestBase.getDriver().findElement(By.xpath("//input[@id = 'email']")).sendKeys
		 * ("vivek_iter@india.com");
		 * TestBase.getDriver().findElement(By.xpath("//input[@id = 'pass']")).sendKeys(
		 * "Facebook@6204");
		 * TestBase.getDriver().findElement(By.xpath("//input[@type = 'submit']")).click
		 * ();
		 */
		
		TestBase.getDriver().get("http://demo.guru99.com/test/cookie/selenium_aut.php");
		TestBase.getDriver().findElement(By.name("username")).sendKeys("abc123");							
		TestBase.getDriver().findElement(By.name("password")).sendKeys("123xyz");							
		TestBase.getDriver().findElement(By.name("submit")).click();
		
		store.storeCookie();
		
		/*
		 * Set<Cookie> cokie = base.getDriver().manage().getCookies(); for (Cookie c1 :
		 * cokie) { System.out.println(c1.getName()+": "+ c1.getValue()); }
		 */
	}
	
	
	@Test(priority = 1)
	public void verifyNameWithCookie() {
		
		TestBase.getDriver().get("http://demo.guru99.com/test/cookie/selenium_aut.php");
		handleCookies.injectCookies();
		TestBase.getDriver().navigate().refresh();
		//TestBase.getDriver().get("http://demo.guru99.com/test/cookie/selenium_aut.php");
	}
	
	@Test(priority = 2)
	public void verifyName() {
		
		
		String s = TestBase.getDriver().findElement(By.xpath("//center[contains(text(),'You are logged In')]")).getText();
		System.out.println(s);
	
	}
	

}
