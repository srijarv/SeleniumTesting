package clipboardAutomationCodingChallenge.pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {
	WebDriver driver;
	
	public AmazonHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement hamBurgerIcon = driver.findElement(By.id("nav-hamburger-menu"));
	@FindBy(id="nav-hamburger-menu")
	WebElement hamBurgerIcon;
	
	//WebElement getAppliances = driver.findElement(By.xpath("//div[contains(text(),'TV, Appliances, Electronics')]"));
	@FindBy(xpath="//div[contains(text(),'TV, Appliances, Electronics')]")
	WebElement getAppliances;
	
	//WebElement televisionMenu = driver.findElement(By.xpath("//*[text()='Televisions']"));
	@FindBy(xpath="//*[text()='Televisions']")
	WebElement televisionMenu;
	
	
	public void goToAmazonHomePage() {
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void amazonHomePageAction(JavascriptExecutor js) {
		hamBurgerIcon.click();
		js.executeScript("arguments[0].scrollIntoView();", getAppliances);
		getAppliances.click();
		televisionMenu.click();
	}
	

}
