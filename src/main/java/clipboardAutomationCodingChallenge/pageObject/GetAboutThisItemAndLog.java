package clipboardAutomationCodingChallenge.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GetAboutThisItemAndLog {
	WebDriver driver;
	
	public GetAboutThisItemAndLog(WebDriver driver) {
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement aboutThisItem = driver.findElement(By.xpath("//*[text()=' About this item ']"));
	@FindBy(xpath="//*[text()=' About this item ']")
	WebElement aboutThisItem;
	
	
	//List<WebElement> productDescription = driver.findElements(By.xpath("//ul[@class='a-unordered-list a-vertical a-spacing-mini']/li"));
	@FindBy(xpath="//ul[@class='a-unordered-list a-vertical a-spacing-mini']/li")
	List<WebElement> productDescription;
	
	public void getAboutThisItemAndLog(JavascriptExecutor js) throws InterruptedException {
		js.executeScript("arguments[0].scrollIntoView();", aboutThisItem);
		Assert.assertEquals(aboutThisItem.getText(), "About this item");
		for(int i = 0; i < productDescription.size(); i++) {
			System.out.println(productDescription.get(i).getText());
		}
	}
	

}
