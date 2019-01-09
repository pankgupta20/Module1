import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class PropFile {

	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, IOException  {
		
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("C:/Selenium/Module 1/seleniumrc/Screenshots/config.properties");
		prop.load(ip);
		
		
		String url = (prop.getProperty("url"));
		System.out.println(url);
		
		String browval = prop.getProperty("browser");
		System.out.println(browval);
		
		if(browval.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\guptapa\\Downloads\\chromedriver_win32\\chromedriver.exe");
			 driver = new ChromeDriver();
		}else if(browval.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\guptapa\\Downloads\\geckodriver-v0.19.1-win64\\geckodriver.exe");
			 driver = new FirefoxDriver();
		}else if(browval.equals("htmlunit")){
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\guptapa\\Downloads\\chromedriver_win32\\chromedriver.exe");
				 driver = new HtmlUnitDriver();
		}
		
/*		System.setProperty("webdriver.chrome.driver", "C:\\Users\\guptapa\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "https://www.freecrm.com/index.html";*/
				 
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//driver.findElement(By.name("username")).sendKeys(prop.getProperty("uname"));
		//driver.findElement(By.name("password")).sendKeys(prop.getProperty("pwd"));
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		WebElement loginbtn = driver.findElement(By.xpath("//input[@value='Login']"));
		Thread.sleep(5000);
		//flash(loginbtn,driver);
		drawBorder(loginbtn,driver);
		//clickbyjs(loginbtn,driver);
		//System.out.println(driver.getTitle());
		WebElement scrobj = driver.findElement(By.xpath("//a[contains(text(),'Forgot')]"));
		scrollbyview(scrobj,driver);
		scrobj.click();
		Thread.sleep(5000);
		driver.close();
	}

		public static void flash(WebElement element, WebDriver driver) throws InterruptedException{
			@SuppressWarnings("unused")
			JavascriptExecutor js = ((JavascriptExecutor)driver);
			String bgcolor = element.getCssValue("backgroundColor");
			for(int i=0;i<10;i++){
				changeColor("rgb(0,200,0))" ,element,driver);
				Thread.sleep(3000);
				changeColor(bgcolor ,element,driver);
			}
			
		}
	
		public static void changeColor(String color, WebElement element, WebDriver driver){
			JavascriptExecutor js = ((JavascriptExecutor)driver);
			js.executeScript("arguments[0].style.backgroundcolor= " +color+ "'", element);
			
			try{
				Thread.sleep(20);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
				 
		}	
			
		
		public static void drawBorder(WebElement element, WebDriver driver){
			JavascriptExecutor js = ((JavascriptExecutor)driver);
			js.executeScript("arguments[0].style.border='3px solid red'", element);
		}
		
		public static void clickbyjs(WebElement element, WebDriver driver){
			JavascriptExecutor js = ((JavascriptExecutor)driver);
			js.executeScript("arguments[0].click();",element);
		}
		
		public static void scrollbyview(WebElement element, WebDriver driver){
			JavascriptExecutor js = ((JavascriptExecutor)driver);
			js.executeScript("arguments[0].scrollIntoView(true);",element);
		}
		
}
