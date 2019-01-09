import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageSimulation {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\guptapa\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.uk");
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:/Selenium/Module 1/seleniumrc/Screenshots/PageSimulation.png"));
		
		driver.navigate().to("https://www.amazon.co.uk");
		System.out.println("Title of current page: " + driver.getTitle());
		Thread.sleep(2000);
		File src1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src1, new File("C:/Selenium/Module 1/seleniumrc/Screenshots/PageSimulation1.png"));
		
		driver.navigate().back();
		System.out.println("Title of current page: " + driver.getTitle());
		Thread.sleep(2000);
		File src2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src2, new File("C:/Selenium/Module 1/seleniumrc/Screenshots/PageSimulation2.png"));
		
		driver.navigate().forward();
		System.out.println("Title of current page: " + driver.getTitle());
		Thread.sleep(2000);
		File src3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src3, new File("C:/Selenium/Module 1/seleniumrc/Screenshots/PageSimulation3.png"));
		
		driver.findElement(By.id("exit_click")).click();
		Thread.sleep(2000);
		
		
		driver.close();
	}

}
