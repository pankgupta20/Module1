import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Popuptest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\guptapa\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.popuptest.com/goodpopups.html");
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("html/body/table[2]/tbody/tr/td/font/b/a[3]")).click();
		
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		
		String parentwindow = it.next();
		System.out.println("Parent ID is: "+ parentwindow);
		
		String childwindow = it.next();
		System.out.println("Child ID is: "+ childwindow);
		
		driver.switchTo().window(childwindow);
		System.out.println("Child title is: "+ driver.getTitle());
		
		driver.close();
		Thread.sleep(2000);
		
		driver.switchTo().window(parentwindow);
		System.out.println("Child title is: "+ driver.getTitle());
		
		driver.close();

	}

}
