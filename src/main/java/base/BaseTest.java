package base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;
import utils.ReportManager;

public class BaseTest {
	public static WebDriver driver;
	public static final Logger log = LogManager.getLogger(BaseTest.class);

	@BeforeTest
	public void setUp() {

		ReportManager.initReports();

		log.info("Starting Test Execution...");
		String browser = ConfigReader.get("browser");
		log.info("Browser identified from config: " + browser);
		String url = ConfigReader.get("baseUrl");

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}

		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		log.info("Navigating to the URL: " + url);
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			log.info("Quitting the browser to complete Execution.....");
			driver.quit();
		}
	}
}
