import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Googlesearchtext {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\guptapa\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.uk");
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.className("gsfi")).sendKeys("testing");
		Thread.sleep(2000);
		List<WebElement> list = driver.findElements(By.xpath("//ul[@class='sbsb_b']//li//descendant::div[@class='sbqs_c']"));
		System.out.println(list.size());
		
		for(int i=0; i<list.size();i++){
			System.out.println("Suggested value is==> " + list.get(i).getText());
			
			if(list.get(i).getText().equals("testing eggs")){
				System.out.println("Required value is==> " + list.get(i).getText());
				list.get(i).click();
				//Thread.sleep(2000);
				break;
			}
			
		}
		driver.close();
	}

}
