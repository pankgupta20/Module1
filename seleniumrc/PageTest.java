import org.openqa.selenium.WebDriver;

public class PageTest {
	
	 WebDriver driver;
	
	 public void setUp(){
		Singleton instaceDriver = Singleton.getInstance();
		driver = instaceDriver.openBrowser();
	 }
	
	 public void testMethod(){
		 driver.get("http://www.google.com");
		 System.out.println(driver.getTitle());
		 driver.close();
	 }
	 
	public static void main(String[] args) {
		PageTest pt = new PageTest();
		pt.setUp();
		pt.testMethod();

	}

}
