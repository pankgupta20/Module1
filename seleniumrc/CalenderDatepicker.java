import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalenderDatepicker {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\guptapa\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.freecrm.com");
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys("pankgupta20");
		driver.findElement(By.name("password")).sendKeys("Password@123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		driver.switchTo().frame("mainpanel");
		
		String reqdate = "24-October-2018";
		String[] temp;
		String delimiter = "-";
		temp = reqdate.split(delimiter);
		
		for(int i=0;i<temp.length;i++){
			System.out.println("Value of reqdate fields are: "+ temp[i]);
		}
		
		Select oMonth = new Select(driver.findElement(By.name("slctMonth")));
		oMonth.selectByVisibleText(temp[1]);
		
		Select oYear = new Select(driver.findElement(By.name("slctYear")));
		oYear.selectByVisibleText(temp[2]);
		
		WebElement dateWidget = driver.findElement(By.xpath("//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody"));
		List<WebElement> rows = dateWidget.findElements(By.tagName("tr"));
		System.out.println("Total row are: " + rows.size());
		List<WebElement> columns = dateWidget.findElements(By.tagName("td"));
		System.out.println("Total columns are: " + columns.size());
		
		for(WebElement cell : columns){
			if(cell.getText().equals(temp[0])){
				cell.findElement(By.partialLinkText(temp[0])).click();
				break;
			}
		}
		
		Thread.sleep(3000);
		driver.close();
	}

}
