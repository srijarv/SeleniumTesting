package clipboardAutomationCodingChallenge;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import clipboardAutomationCodingChallenge.pageObject.AmazonHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("nav-hamburger-menu")).click();
		WebElement getAppliances = driver.findElement(By.xpath("//div[contains(text(),'TV, Appliances, Electronics')]"));
		js.executeScript("arguments[0].scrollIntoView();", getAppliances);
		getAppliances.click();	
		Thread.sleep(2000L);
		driver.findElement(By.xpath("//*[text()='Televisions']")).click();
		WebElement getBrands = driver.findElement(By.xpath("//*[text()='Brands']"));
		js.executeScript("arguments[0].scrollIntoView();", getBrands);
		List<WebElement> getFilterByOptions = driver.findElements(By.xpath("//body/div[@id='a-page']/div[2]/div[2]/div[2]/div[1]/div[1]/div[21]/ul[1]/li/span/a/span"));

		System.out.println(getFilterByOptions.size());
		for(WebElement option : getFilterByOptions) {
			if(option.getText().equalsIgnoreCase("LG")) {
				option.click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				break;
			}
		}
		
		driver.findElement(By.cssSelector("span[id='a-autoid-0'] span[class='a-button-inner']")).click();
		Thread.sleep(5000L);
		List<WebElement> sortOptions = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		System.out.println(sortOptions.size());
		for(int i = 0; i < sortOptions.size(); i++) {
			System.out.println(sortOptions.size());
			System.out.println(sortOptions.get(i).getText());
			if(sortOptions.get(i).getText().equalsIgnoreCase("Price: High to Low")) {
				sortOptions.get(i).click();
				Thread.sleep(3000L);
				break;
			}
		}
		
		driver.findElement(By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_2']")).click();
		ArrayList<String> it = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(it.get(1));
		System.out.println("First tab title: " + driver.getTitle());
		Thread.sleep(3000L);
		
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[text()=' About this item ']")));
		Assert.assertEquals(driver.findElement(By.xpath("//*[text()=' About this item ']")).getText(), "About this item");
		
		List<WebElement> productDescription = driver.findElements(By.xpath("//ul[@class='a-unordered-list a-vertical a-spacing-mini']/li"));
		for(int i = 0; i < productDescription.size(); i++) {
			System.out.println(productDescription.get(i).getText());
		}
		driver.quit();
	}
}
