
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpiceJet {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\guptapa\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.get("http://spicejet.com/");
		driver.get("http://www.cricbuzz.com/live-cricket-scorecard/18630/akl-vs-wel-10th-match-super-smash-2017-18");
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scr, new File("C://Selenium//screen.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
/*		WebElement table = driver.findElement(By.cssSelector("div.cb-col.cb-col-67.cb-scrd-lft-col.html-refresh.ng-isolate-scope"));
		int rowcount = table.findElements(By.cssSelector("div.cb-col.cb-col-100.cb-scrd-itms")).size();
		
		String Result = table.findElement(By.cssSelector("div.cb-col.cb-scrcrd-status.cb-col-100.cb-text-complete.ng-scope")).getText();
		System.out.println("Result of match is: "+ Result);
		
		String Innings = table.findElement(By.cssSelector(".cb-col.cb-col-100.cb-scrd-hdr-rw>span")).getText();
		System.out.println("Innings name: "+ Innings);
		
		String startindex = "//*[@id='innings_1']/div[1]/div[";
		String endindex = "]/div[";*/
		
		int rcount = driver.findElements(By.xpath("//*[@id='innings_1']/div[1]/div")).size();
		System.out.println("Row count is: "+ rcount);
		
		for(int i=2;i<rcount-2;i++){
			
			int ccount = driver.findElements(By.xpath("//*[@id='innings_1']/div[1]/div["+i+"]/div")).size();
			for(int j=1;j<ccount;j++){
				
				String sval = driver.findElement(By.xpath("//*[@id='innings_1']/div[1]/div["+i+"]/div["+j+"]")).getText();
				
				System.out.print(sval);
				System.out.print("||");
				
			}
			System.out.println("");
		}
			
		
	}

}
