package flower.pack;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class invoking {
	public static WebDriver driver = null;
	public static Properties prop = null;
	
	public void invokeBrowsers(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		/************* MAXIMIZE THE WINDOW *************/

		driver.manage().window().maximize();
		waitload(20);

		/********** GETTING THE DATA FROM THE PROPERTY FILE ***********/

		if (prop == null) {
			prop = new Properties();
			try {
				FileInputStream file = new FileInputStream(
						System.getProperty("user.dir") + "\\propertiesConfig.Properties");
				prop.load(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/*********** OPEN THE URL ***********/
	
	public void openURL(String WebsiteURL) {
		driver.get(prop.getProperty(WebsiteURL));
	}
	/******************* wait load **************************/
	public void waitload(int value) {
		driver.manage().timeouts().implicitlyWait(value, TimeUnit.SECONDS);
	}
@Test
	public void clickLogin() {
		
			invokeBrowsers("chrome");
			openURL("WebsiteURL");
			driver.quit();
}
}
