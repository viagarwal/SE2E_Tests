package com.paypal.utils;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

@Listeners({ com.paypal.utils.WebDriverListener.class})
public class Driver {

	public static WebDriver driver;
	public static EventFiringWebDriver eventFiringWebDriver ;
	private static String chromeDriverPath = "D:\\chromedriver\\";
	private static String internetExplorerDriverPath = "D:\\iedriver\\";
	final static Logger logger = Logger.getLogger("Test");
	public static ExtentReports extent  = null;
	public static ExtentTest test = null;
	public static String description = null;

	private void setDriver(String browserType, String appURL) throws UnknownHostException {
		switch (browserType) {
		case "chrome":
			driver = initChromeDriver(appURL);
			break;
		case "firefox":
			driver = initFirefoxDriver(appURL);
			break;
		case "ie":
			driver = initInternetExplorerDriver(appURL);
			break;
		default:
			System.out.println("browser : " + browserType
					+ " is invalid, Launching Firefox as browser of choice..");
			logger.info("browser : " + browserType
					+ " is invalid, Launching Firefox as browser of choice..");
			driver = initFirefoxDriver(appURL);
		}
		eventFiringWebDriver = new EventFiringWebDriver(driver);
		eventFiringWebDriver.register(new WebDriverListener());
		extent =  new ExtentReports(System.getProperty("user.dir")+"\\ExtentReport.html", true);
		extent.config().documentTitle("Automation Report").reportName("Regression").reportHeadline("");
		extent.addSystemInfo("Selenium Version", "2.46");
		extent.addSystemInfo("Environment", "QA");
		extent.addSystemInfo("User Name", System.getProperty("user.name"));
		extent.addSystemInfo("OS", System.getProperty("os.name"));
		extent.addSystemInfo("Java Version", System.getProperty("java.version"));
		extent.addSystemInfo("Host Name", InetAddress.getLocalHost().getHostName());
		String css = "body, .test .right span, .collapsible-header { background: #333; color: #fff; }" +
                "nav, .tab, .card-panel { background: #000 !important; }" +
                "table { border: 1px solid #555 !important; }" +
                "pre { background: #333; border: 1px solid #777 !important; color: #eee !important; }" +
                ".select-dropdown { background: #333; border-bottom: 1px solid #777 !important; }" +
                ".select-dropdown li:hover, .select-dropdown li.active { background: #555; }" +
                "table.bordered > thead > tr, table.bordered > tbody > tr, th, td { border-bottom: 1px solid #555 !important; }" +
                "th, td, .test-name, .test-desc, .test .right span { color: #fff !important; }" +
                ".test-body .collapsible > li { border: 1px solid #777; }";

extent.config().insertCustomStyles(css);

	}

	private static WebDriver initChromeDriver(String appURL) {
		System.out.println("Launching google chrome with new profile..");
		System.setProperty("webdriver.chrome.driver", chromeDriverPath
				+ "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	private static WebDriver initFirefoxDriver(String appURL) {
		System.out.println("Launching Firefox browser..");
//		File file = new File("firebug-1.8.1.xpi");
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		driver = new FirefoxDriver(firefoxProfile);
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	private static WebDriver initInternetExplorerDriver(String appURL) {
		
		System.out.println("Launching internet explorer browser..");
		System.setProperty("webdriver.ie.driver", internetExplorerDriverPath +"IEDriverServer.exe");

		DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
		ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		driver = new InternetExplorerDriver(ieCapabilities);
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}
	
	
	@Parameters({ "browserType", "appURL" })
	@BeforeSuite
	public void initializeTestBaseSetup(String browserType, String appURL) {
		try {
			setDriver(browserType, appURL);
		} catch (Exception e) {
			System.out.println("Error....." + e.getStackTrace());
		}
	}

	public static String takeScreenShot(String fileName) throws IOException{
		File scrFile = ((TakesScreenshot)eventFiringWebDriver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		FileUtils.copyFile(scrFile, new File("src/test/resources/"+fileName+".png"));
		return fileName+".png";
	}
//	@AfterSuite
//	public void tearDown() {
//		driver.quit();
//	}


}