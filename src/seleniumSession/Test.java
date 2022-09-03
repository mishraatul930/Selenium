package seleniumSession;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Test {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\atul.mishra\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:9089/BrowserWeb/");
		driver.manage().window().maximize();
		File src1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src1,new File("C:\\Users\\atul.mishra\\eclipse-workspace\\SeleniumSessions\\src\\seleniumSession\\T24SS1.png"));
		driver.findElement(By.id("signOnName")).sendKeys("INPUTT");
		driver.findElement(By.id("password")).sendKeys("123456");
		File src2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src2,new File("C:\\Users\\atul.mishra\\eclipse-workspace\\SeleniumSessions\\src\\seleniumSession\\T24SS2.png"));
		driver.findElement(By.id("sign-in")).click();
		String title = driver.getTitle();
		System.out.println(title);
		if(title.equals("T24 - Model Bank")) {
			System.out.println("Correct Title");
		}
		else {
			System.out.println("Incorrect Title");
		}
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[contains(@id,'commandV')]")).sendKeys("SAWATQ.PARAMETER");
		Thread.sleep(3000);
		File src3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src3,new File("C:\\Users\\atul.mishra\\eclipse-workspace\\SeleniumSessions\\src\\seleniumSession\\T24SS3.png"));
		driver.findElement(By.xpath("//img[@id = 'cmdline_img']")).click();
		Thread.sleep(3000);
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		String parentWindowId = it.next();
		System.out.println(parentWindowId);
		String childWindowId = it.next();
		System.out.println(childWindowId);
		driver.switchTo().window(childWindowId);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='idbox idbox_SAWATQPARAMETER']")).sendKeys("SYSTEM");
		Thread.sleep(3000);
		//Screenshot
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src,new File("C:\\Users\\atul.mishra\\eclipse-workspace\\SeleniumSessions\\src\\seleniumSession\\T24SS4.png"));
		driver.close();
		driver.switchTo().window(parentWindowId);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//a[@title='Sign off']")).click();
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		driver.quit();
	}
}
