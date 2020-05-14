package Demo;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScopeLinks {

	public static void main(String[] args) throws InterruptedException {
		// Calculating the links of the scope..
		
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Count the entire page link...
		System.out.println("Number of Total links: " +driver.findElements(By.tagName("a")).size());
		
		//Count the Entire links of the Footer Link only..
		//This is called Limiting the driver...
		WebElement FooterDriver = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
		System.out.println("Number of footer links: " +FooterDriver.findElements(By.tagName("a")).size());
		
		//Count the 1st section link of the footer driver...
		WebElement Section1 = FooterDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println("Number of footer Section 1 links: " +Section1.findElements(By.tagName("a")).size());
		
		
		//Click on each footer section 1 links and open it in the another tab..
		//Using Forloops..
		
		for(int i=1; i<Section1.findElements(By.tagName("a")).size(); i++) 
		{
			
			//Press control keyt so that it will get open into the newtab..
			String Clickoneachlinks = Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			//Getting i so that it is common for every links...
			//For every Keyboard events we have to use sendkeys method..
			Section1.findElements(By.tagName("a")).get(i).sendKeys(Clickoneachlinks); 
			Thread.sleep(4000);
			
		}
		
		Set<String> abc=driver.getWindowHandles();//4
		Iterator<String> it=abc.iterator();
		
		while(it.hasNext()) //it.hasnext() it will search if there are any index present or not...
		{
			
		   driver.switchTo().window(it.next()); //it.next() will move to another tab...
		   System.out.println(driver.getTitle());
		
		}
		
		driver.quit();
		

	}

}
