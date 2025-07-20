package cookkiee;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingCoookiee {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		
		  Set<Cookie> allCookie = driver.manage().getCookies();
		  System.out.println(allCookie.size()); 
		  
		  for (Cookie cook : allCookie) {
		  
		  cook.equals(allCookie);
		  
		  System.out.println(cook.toJson());
		  }
		  
		  driver.manage().deleteAllCookies(); 
		  
		  Set<Cookie> xyz =driver.manage().getCookies();
		  
		  System.out.println(xyz.size()); Thread.sleep(5000);
		  driver.manage().getCookies();
		 
 Cookie asas = driver.manage().getCookieNamed("OMGSession");
 
 System.out.println(asas);
	
//	  System.out.println(allCookie.size()); for (Cookie cook1 : allCookie1) {
	  
//	  System.out.println(cook1.getValue());
	  
	  //System.out.println(cook.toJson()); }
	 
		driver.quit();

	}
}
