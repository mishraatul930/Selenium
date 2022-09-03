package seleniumSession;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ReadPropFile {
	
	static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		//To read the properties file we need to create object of Properties Class in Java
		Properties prop = new Properties();
		//to define the config file path or connect to the config file
		FileInputStream fip = new FileInputStream("C:\\Users\\atul.mishra\\eclipse-workspace\\SeleniumSessions\\src\\seleniumSession\\config.properties");
		//To load the Config file
		prop.load(fip);
		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("age"));
		System.out.println(prop.getProperty("browser"));
		//if a data is commented in property file it will show null
		String url = prop.getProperty("URL");
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\atul.mishra\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		}
	    driver.get(url);
	    driver.manage().window().maximize();
		driver.findElement(By.id(prop.getProperty("IDUsername"))).sendKeys(prop.getProperty("Username"));
		driver.findElement(By.id(prop.getProperty("IDPassword"))).sendKeys(prop.getProperty("password"));
		File srcImg = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcImg,new File("C:\\Users\\atul.mishra\\eclipse-workspace\\SeleniumSessions\\src\\seleniumSession\\LoginPage.png"));
		driver.findElement(By.id(prop.getProperty("IDSubmitBtn"))).click();
		Thread.sleep(3000);
		File srcImg1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcImg1,new File("C:\\Users\\atul.mishra\\eclipse-workspace\\SeleniumSessions\\src\\seleniumSession\\HomePage.png"));
		Thread.sleep(1000);
		driver.close();
	}

}
