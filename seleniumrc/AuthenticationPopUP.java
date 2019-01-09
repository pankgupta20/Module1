import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationPopUP {
	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\NisumTestExercise\\Utilities\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://store.demoqa.com/");

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// List<WebElement> ll =
		// driver.findElements(By.xpath("//a[contains(text(),'Product
		// Category')]/following-sibling::ul/li/a/span"));


		try {
			WebElement ele = driver.findElement(By.xpath("//a[contains(text(),'ProductCategory')]"));
			//driver.findElement(By.cssSelector("a:contains('Product Category')"));
				String screenShot = System.getProperty("user.dir") + "\\screenShot.png";
				System.out.println(System.getProperty("user.dir"));
				File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				Point p = ele.getLocation();
				
				int width = ele.getSize().getWidth();
				System.out.println(width);
				int height = ele.getSize().getHeight();
				System.out.println(height);
				BufferedImage img = ImageIO.read(srcFile);
				BufferedImage dest = img.getSubimage(p.getX(), p.getY(), width, height);
				ImageIO.write(dest, "png", srcFile);
				FileUtils.copyFile(srcFile, new File(screenShot));
			}catch(Exception e)
	{
		System.out.println(e.getMessage());
	}finally
	{
		driver.quit();
	}

}

}
