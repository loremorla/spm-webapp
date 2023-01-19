package unicam.spmwebapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;


import java.time.Duration;

public class SeleniumTest {
	
	static WebDriver driver;
	
	/*@BeforeAll
	static void setUpBeforeClass() {
		String projectPath = System.getProperty("user.id");
		System.setProperty("webdriver.chrome.driver",projectPath+"/drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}*/
	
	 @BeforeEach
	 void setUp() throws Exception {
		 WebDriverManager.chromedriver().setup();
		 ChromeOptions options = new ChromeOptions();
		 driver = new ChromeDriver(options);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 }
	
	@Test
	@Tag("AcceptanceTest")
	public void checkProsSite() throws InterruptedException {
		String projectPath = System.getProperty("user.dir");
		
		//System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver.exe");
		//WebDriver driver = new ChromeDriver(); //istanciated the driver
		driver.get("http://localhost:8080/spm-webapp/");
		
		Thread.sleep(3000);
		
		String at = driver.getTitle();
		String et = "SPM 2022";
		
		Thread.sleep(4000);
		
		Assert.assertEquals(et, at);
		driver.close();
		driver.quit();
	}
	
	@Test
	@Tag("AcceptanceTest")
	public void checkProsSite2() throws InterruptedException {
		String projectPath = System.getProperty("user.dir");
		
		//System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver.exe");
		//WebDriver driver = new ChromeDriver(); //istanciated the driver
		driver.get("http://localhost:8080/maven-archetype-webapp/");
		
		Thread.sleep(3000);
		
		String at = driver.getTitle();
		String et = "SPM 2022";
		
		Thread.sleep(4000);
		
		Assert.assertEquals(et, at);
		driver.close();
		driver.quit();
	}

}
