package clipboardAutomationCodingChallenge.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SortByPrice {
	WebDriver driver;
	
	public SortByPrice(WebDriver driver) {
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement sortBy = driver.findElement(By.cssSelector("span[id='a-autoid-0'] span[class='a-button-inner']"));
	@FindBy(css="span[id='a-autoid-0'] span[class='a-button-inner']")
	WebElement sortBy;
		
	//List<WebElement> sortOptions = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
	@FindBy(xpath="//ul[@role='listbox']/li")
	List<WebElement> sortOptions;
	
	public void sortByPrice(JavascriptExecutor js) throws InterruptedException {
		sortBy.click();
		Thread.sleep(5000L);
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
	}
	

}
