import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class JavaScript {
static WebDriver driver;
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\NisumTestExercise\\Utilities\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.get("http://store.demoqa.com/");

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		JavascriptExecutor JS = (JavascriptExecutor) driver;
		String title = (String) JS.executeScript("return document.title");
		System.out.println(title);
		
		driver.quit();

	}

}
