import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StaleElementException {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		//options.addArguments("--headless");
		cap.setCapability(ChromeOptions.CAPABILITY, options);

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\NisumTestExercise\\Utilities\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.get("https://www.google.com/");

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Thread.sleep(2000);
		driver.findElement(By.name("q")).sendKeys(Keys.F5);

		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='2px solid red'", driver.findElement(By.name("q")));
		driver.findElement(By.name("q")).sendKeys("selenium");
		//waitForElement(By.name("btnK"), 10);
		
		
		
		if(waitForElement(By.name("btnk"))){
			driver.findElement(By.name("btnK")).click();
		}
	
		driver.quit();
	}

/*		public static void waitForElement(By by, int timeout){
			WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class);
			wait.until(new ExpectedCondition<Boolean>(){

				@Override
				public Boolean apply(WebDriver driver) {
					WebElement ele = driver.findElement(by);
					return ele!=null && ele.isDisplayed();
				}				
			});	*/
	
	public static boolean waitForElement(By by){
		int maxretrycount=3;
		int retry=1;
		boolean result = false;
		while(retry<maxretrycount){
			
		try{
			WebElement ele = driver.findElement(by);
			if(ele.isDisplayed()){
				result = true;
				break;
			}
		} catch(Exception e){
		}
		retry++;
		}
		return result;
	}

	/*
	 * public static void staleElement(String name) { for (int i = 1; i < 5;
	 * i++) { try { WebElement ele = driver.findElement(By.name(name));
	 * ele.click(); break; } catch (Exception e) {
	 * System.out.println(e.getMessage()); }
	 * 
	 * } }
	 */

}
