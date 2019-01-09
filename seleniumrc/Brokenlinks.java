import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Brokenlinks {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException  {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Proportional Treaty\\Utilities\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.get("https://www.freecrm.com");
		driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		/*driver.findElement(By.name("username")).sendKeys("pankgupta20");
		driver.findElement(By.name("password")).sendKeys("Password@123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		driver.switchTo().frame("mainpanel");
		Thread.sleep(2000);*/
		
		List<WebElement> totlnklist = driver.findElements(By.tagName("a"));
		totlnklist.add(driver.findElement(By.tagName("img")));
		
		System.out.println("Total no. of active links are: "+totlnklist.size());
		
		List<WebElement> activelnklist = new ArrayList<WebElement>();
		
		for(int i=0; i<totlnklist.size();i++){
			System.out.println(totlnklist.get(i).getAttribute("href"));
			if(totlnklist.get(i).getAttribute("href")!= null && (! totlnklist.get(i).getAttribute("href").contains("javascript"))){
				activelnklist.add(totlnklist.get(i));
			}
			
			
		}
		System.out.println("Total no. of active links are: "+ activelnklist.size());
		
		for(int j=0;j<activelnklist.size();j++){
			HttpURLConnection connection = (HttpURLConnection) new URL(activelnklist.get(j).getAttribute("href")).openConnection();
			connection.connect();
			String response = connection.getResponseMessage();
			connection.disconnect();
			System.out.println(activelnklist.get(j).getAttribute("href")+"---->"+response);
			
		}
		
		driver.close();
		
	}

}
