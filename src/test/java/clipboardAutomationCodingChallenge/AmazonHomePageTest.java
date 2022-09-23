package clipboardAutomationCodingChallenge;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import clipboardAutomationCodingChallenge.pageObject.AboutThisItem;
import clipboardAutomationCodingChallenge.pageObject.AmazonHomePage;
import clipboardAutomationCodingChallenge.pageObject.FilterByBrand;
import clipboardAutomationCodingChallenge.pageObject.Search2ndHighestItem;
import clipboardAutomationCodingChallenge.pageObject.SortByPrice;
import clipboardAutomationCodingChallenge.pageObject.SwitchToChildWindow;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonHomePageTest {

	WebDriver driver;
	JavascriptExecutor js;
	AmazonHomePage amazonHomePage;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		js = (JavascriptExecutor) driver;
	}
	
	@Test
	public void validateProductDescription() throws InterruptedException {
		amazonHomePage = new AmazonHomePage(driver);
		amazonHomePage.goToAmazonHomePage();
		amazonHomePage.amazonHomePageAction(js);
				
		new FilterByBrand(driver).televisionPageAction(js);
		new SortByPrice(driver).sortByPrice(js);
		new Search2ndHighestItem(driver).sortByPrice(js);
		SwitchToChildWindow switchToChildWindow = new SwitchToChildWindow(driver);
		ArrayList<String> it = new ArrayList<String>(driver.getWindowHandles());
		switchToChildWindow.switchToChildWindow(js, it);
		
		new AboutThisItem(driver).validateAboutThisItemAndLog(js);
	}
	
	@AfterClass
	public void destroy() {
		driver.quit();
	}
	
}
