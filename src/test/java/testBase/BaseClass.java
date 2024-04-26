package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	static public WebDriver driver;
	public Properties p;
	
	@BeforeTest
	@Parameters({"browser"})	
	public void setUp(String br) throws InterruptedException, IOException {
		
		
		 FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		 p=new Properties();
		 p.load(file);
		
		switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			System.out.println("Chrome is Launched.");
			break;
 
		case "edge":
			driver = new EdgeDriver();
			System.out.println("Edge is Launched");
			break;
 
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
        String url=p.getProperty("url");
        driver.navigate().to(url);
		Thread.sleep(3000);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
