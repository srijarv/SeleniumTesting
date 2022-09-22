package clipboardAutomationCodingChallenge.pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilterByBrand {
	WebDriver driver;
	
	public FilterByBrand(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement getBrands = driver.findElement(By.xpath("//*[text()='Brands']"));
	@FindBy(xpath="//*[text()='Brands']")
	WebElement getBrands;
	
	//List<WebElement> getFilterByOptions = driver.findElements(By.xpath("//body/div[@id='a-page']/div[2]/div[2]/div[2]/div[1]/div[1]/div[21]/ul[1]/li/span/a/span"));
	@FindBy(xpath="//body/div[@id='a-page']/div[2]/div[2]/div[2]/div[1]/div[1]/div[21]/ul[1]/li/span/a/span")
	List<WebElement> getFilterByOptions;
	
	
	public void televisionPageAction(JavascriptExecutor js) {
		js.executeScript("arguments[0].scrollIntoView();", getBrands);
		System.out.println(getFilterByOptions.size());
		for(WebElement option : getFilterByOptions) {
			if(option.getText().equalsIgnoreCase("LG")) {
				option.click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				break;
			}
		}
	}	
}
