import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Singleton {

	private static Singleton instance_driver= null;
	private WebDriver driver;

	
	private Singleton(){
		
	}
	
	public WebDriver openBrowser(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\guptapa\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
	
	
	public static Singleton getInstance(){
		if(instance_driver==null)
			instance_driver = new Singleton();
			return instance_driver;		
	}
	
	
	
}
