import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Bootstraps{

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\guptapa\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//FirefoxDriver driver = new FirefoxDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size=1400,800");
		options.addArguments("headless");
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.jquery-az.com/jquery/demo.php?ex=167.0_1");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//button[contains(@class,'dropdown')]")).click();
		
		driver.findElement(By.xpath("//input[@type = 'text' and @class='form-control']")).sendKeys("java");
		
		List<WebElement> list =  driver.findElements(By.xpath("//ul[contains(@class,'dropdown-menu inner')]//li"));
		System.out.println(list.size());
		
		Thread.sleep(2000);
		
		 
		
		for(int i=0; i<list.size();i++){
			System.out.println(list.get(i).getText());
			
			if(list.get(i).getText().contains("Java")){
				list.get(i).click();
				break;
				
			}
			/*String classval = list.get(i).getClass().getCanonicalName();
			System.out.println("Class of element is: " + classval);*/
			
		}
		
		driver.close();
	}

}
