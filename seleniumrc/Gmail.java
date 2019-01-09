
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Gmail {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.gecko.driver", "C:\\DRIVERS\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\guptapa\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//FirefoxDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.get("http://gmail.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Thread.sleep(5000);
		driver.findElement(By.id("identifierId")).sendKeys("pankgupta20");
		//Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='identifierNext']/content/span")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='passwordNext']/content/span")).click();
		Thread.sleep(3000);
		
		String text = driver.findElement(By.xpath("//div[@class='dEOOab RxsGPe']")).getText();
		System.out.println(text);
		
		
		if(text.equals("Enter a password")){
			System.out.println("Enter the password for user");
			driver.findElement(By.name("password")).sendKeys("cogniZant");
			Thread.sleep(3000);
			driver.findElement(By.xpath(".//*[@id='passwordNext']/content/span")).click();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			
			driver.findElement(By.xpath("//span[@class='gb_bb gbii']")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("gb_71")).click();
			Thread.sleep(3000);
		}
		else{
			System.out.println("No need to enter password");
		}
		driver.close();
	}

}
