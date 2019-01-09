import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFileReader{
    
	public static void main(String [] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\guptapa\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String fileName = "C:\\CSRPProd\\IMR_Data.txt";
		
		// Instantiating FileReader to read text file passed as parameter
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Wrapping FileReader in BufferedReader
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		//Stores one line of text
		String lineText = null;
		
		try {
			while((lineText = bufferedReader.readLine()) != null	) {
						driver.get(lineText);
				System.out.println(driver.getTitle());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Quit driver
		driver.quit();
		
		// Close BufferedReader
		try {
			bufferedReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			fileReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
	
}