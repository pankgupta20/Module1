import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\guptapa\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://pbstsd.xchanging.com/");
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='txtUserID']")).sendKeys("MATTEST_T1");
		driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("punjab@21");
		driver.findElement(By.xpath("//*[@id='sub']")).click();
		
		if(driver.findElement(By.xpath("//input[@id='UMR']")).isEnabled()){
			driver.findElement(By.xpath("//input[@id='UMR']")).sendKeys("B0001GGNUMRD87750");
			Thread.sleep(2000);			
		}
		else{
			driver.findElement(By.xpath("//*[@id='menu-1511272020476']/li[1]/a/span/span")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='UMR']")).sendKeys("B0001GGNUMRD87750");
			Thread.sleep(2000);			
	}
		
		
		
		driver.findElement(By.name("ShowAdvancedSearch_AdvancedSearchPage_217")).click();
		Thread.sleep(2000);
		
		//*[@id='$PpgRepPgSubSectionShowAdvancedSearchBBBB$ppxResults$l1']/td[1]/div/span/a
		
		clickOn(driver, driver.findElement(By.xpath("//*[@id='RULE_KEY']/div/div/div/div/div/div/span/a")),30);		
	}
	
	
	public static void clickOn(WebDriver driver, WebElement locator, int timeout){
		new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}
	

}
