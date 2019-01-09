import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WebTable {

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
		Thread.sleep(2000);
		
		Select monthval = new Select(driver.findElement(By.name("slctMonth")));
		monthval.selectByVisibleText("December");
		Thread.sleep(2000);
		Select yearval = new Select(driver.findElement(By.name("slctYear")));
		yearval.selectByVisibleText("2016");
		Thread.sleep(2000);
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[3]/td[3]
		
		String beforepath = "//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
		String afterpath = "]/td[";
		
		boolean flag = false;
		
		for (int row=2; row<=6; row++){
			for (int col=1;col<=7;col++){
				String getdate = driver.findElement(By.xpath(beforepath+row+afterpath+col+"]")).getText();
				//System.out.println("Date in the calender is: " + getdate);
				
				if(getdate.equals("18")){
					driver.findElement(By.xpath(beforepath+row+afterpath+col+"]")).click();
					System.out.println("Selected date is: " + getdate);
					System.out.println("Day on selected date is: " + (driver.findElement(By.xpath(beforepath+"1"+afterpath+col+"]")).getText()));
					flag = true;
					break;
				}
							
			}
			
			if (flag){
				break;
			}
		}

	}
}
	

