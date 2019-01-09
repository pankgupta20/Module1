import java.util.concurrent.TimeUnit;
import java.io.File;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;

public class ImrAuto{

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\guptapa\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.get("https://imrfof.xchanging.com/worksitemp/index.jsp");
		  driver.get("https://repository.xchanging.com/worksitemp/index.jsp");
		
		System.out.println("Start time: " + LocalDateTime.now());
		
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		
		/*driver.findElement(By.name("Domain")).sendKeys("lpci");
		driver.findElement(By.name("UserId")).sendKeys("ind963");
		driver.findElement(By.name("Password")).sendKeys("password");*/
		
		driver.findElement(By.name("UserId")).sendKeys("Xchangingadm");
		
		Thread.sleep(1000);
		driver.findElement(By.id("login")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(2000);
		//driver.findElement(By.id("login")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id='quickLinksMarker']")).click();
		//Thread.sleep(10000);
		
		
/*		WebElement marslink = driver.findElement(By.xpath("//*[@id='quickLinksData']/tbody/tr[2]/td/a"));
		marslink= Wait.until(ExpectedConditions.elementToBeClickable(marslink));
		marslink.click();*/
		
		
		
		//driver.findElement(By.xpath("//*[@id='quickLinksData']/tbody/tr[2]/td/a")).click();
		//prod--
		WebDriverWait wait=new WebDriverWait(driver,20);
		WebElement marslink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='quickLinksData']/tbody/tr[3]/td/a")));
		marslink.click();
		
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@id='quickLinksData']/tbody/tr[3]/td/a")).click();
		Thread.sleep(1000);
		
		File file = new File("C:\\CSRPProd\\IMR_Data.txt");
		FileReader fr=new FileReader(file);
		BufferedReader br= new BufferedReader(fr);
		String x="";
		 int counter = 1;
		try{
			
			while ((x=br.readLine()) != null)
			{
				
			System.out.println("Sequence of user is: " + counter);
			System.out.println("IMR user for updation: " + x +"\n");
			//driver.get(x);
			
			if (counter>1) {
				//driver.findElement(By.xpath("//*[@id='userSearchSectionImg']")).click();
				driver.findElement(By.xpath("//*[@id='menu_5']/tbody/tr/td[1]/span/a")).click();
			}
			
			Thread.sleep(1000);
			driver.findElement(By.id("xchangingID")).sendKeys(x);
			
			driver.findElement(By.id("search")).click();
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='lastRow']/td[1]/a")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//*[@id='pbsOnline']")).click();
			Thread.sleep(1000);
			
	/*		WebDriverWait wait=new WebDriverWait(driver,20);
			WebElement marslink = wait.until(ExpectedConditions.)));
			marslink.click();*/
			
			driver.findElement(By.xpath("//*[@id='SAVE']")).click();
			Thread.sleep(7000);
			
			counter=counter+1;
			}
			
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally{
			/*while ((x=br.readLine()) != null)
			{
				
			System.out.println("Sequence of user is: " + counter);
			System.out.println("IMR user for updation: " + x +"\n");
			//driver.get(x);
			
			if (counter>1) {
				//driver.findElement(By.xpath("//*[@id='userSearchSectionImg']")).click();
				driver.findElement(By.xpath("//*[@id='menu_5']/tbody/tr/td[1]/span/a")).click();
			}*/
/*			Thread.sleep(5000);
			driver.findElement(By.id("xchangingID")).clear();
			
			driver.findElement(By.id("xchangingID")).sendKeys(x);
			
			driver.findElement(By.id("search")).click();
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='lastRow']/td[1]/a")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//*[@id='pbsOnline']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='SAVE']")).click();
			Thread.sleep(10000);
			
			counter=counter+1;*/
		}
			
		System.out.println("End time: " + LocalDateTime.now());	
		
		br.close();	
		driver.close();
	}
	
	}


