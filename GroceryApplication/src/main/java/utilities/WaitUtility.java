package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	
	public void waitForElement(WebDriver driver, WebElement element, String attribute, String attributeValue,
			int total) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(total))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.attributeContains(element, attribute, attributeValue));
	}
	
	public void WaitUntilWebElementClickable(WebDriver driver, WebElement element, int duration) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForAlertPresent(WebDriver driver,int total) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(total))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void waitUntilElementVisible(WebDriver driver, WebElement element, int timeoutInSeconds) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	    wait.until(ExpectedConditions.visibilityOf(element));
	}    
	    
	    public void waitUntilElementSelected(WebDriver driver, WebElement element, int timeoutInSeconds) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	        wait.until(ExpectedConditions.elementToBeSelected(element));
	        	
	}
}
