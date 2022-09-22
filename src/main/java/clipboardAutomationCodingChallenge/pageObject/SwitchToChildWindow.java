package clipboardAutomationCodingChallenge.pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwitchToChildWindow {
	WebDriver driver;
	
	public SwitchToChildWindow(WebDriver driver) {
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}
	
	public void switchToChildWindow(JavascriptExecutor js, ArrayList<String> it) throws InterruptedException {
		driver.switchTo().window(it.get(1));
		System.out.println("First tab title: " + driver.getTitle());
		Thread.sleep(3000L);		
	}
}
