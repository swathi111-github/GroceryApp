package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtility {

	public void selectDropdownWithValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
	}

	public void alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void mouseRightClick(WebDriver driver, WebElement element) {
		Actions actObject = new Actions(driver);
		actObject.contextClick(element).perform();
	}

	public String getAttributeValueOfElement(WebElement element, String attribute) {
		return element.getAttribute(attribute);

	}

	public void clickJavaScriptExecutor(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	public String generateCurrentDateAndTime() {

		Date date = new Date();

		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmmss");

		return formatter.format(date);

	}

	public int randon(int limit) {

		Random random = new Random();

		int randomNumber = random.nextInt(limit);

		return randomNumber;

	}

	public void scrollAndClick(WebElement element, WebDriver driver, int horizontal , int vertical) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+horizontal+","+vertical+")");
		js.executeScript("arguments[0].click();", element);
	}

}
