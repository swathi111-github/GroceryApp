package elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FakerUtility;
import utilities.GeneralUtility;
import utilities.WaitUtility;

public class ManageContactPage {

	WebDriver driver;
	GeneralUtility gu = new GeneralUtility();
	FakerUtility fu = new FakerUtility();
	WaitUtility wu = new WaitUtility();

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory -@findby annotation to find elements
	}

	@FindBy(xpath = "//div[@class='card-body table-responsive p-0']//tbody//tr//td[1]")
	WebElement phone;
	@FindBy(xpath = "//div[@class='card-body table-responsive p-0']//tbody//tr//td[2]")
	WebElement email;
	@FindBy(xpath = "//div[@class='card-body table-responsive p-0']//tbody//tr//td[3]")
	WebElement address;
	@FindBy(xpath = "//div[@class='card-body table-responsive p-0']//tbody//tr//td[4]")
	WebElement deliveryTime;
	@FindBy(xpath = "//div[@class='card-body table-responsive p-0']//tbody//tr//td[5]")
	WebElement deliveryChargeLimit;
	@FindBy(xpath = "//div[@class='card-body table-responsive p-0']//tbody//tr//td[6]")
	WebElement editButton;
	@FindBy(name = "email")
	WebElement emailField;
	@FindBy(name = "Update")
	WebElement updateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertText;
	@FindBy(name = "del_limit")
	WebElement deliveryChargeLimitField;
	@FindBy(xpath = "//a[@class ='btn btn-default btn-fix']")
	WebElement resetButton;

	public String getPhoneField() {
		return phone.getText();
	}

	public String getEmailField() {
		return email.getText();
	}

	public String getAddressField() {
		return address.getText();
	}

	public String getDeliveryTimeField() {
		return deliveryTime.getText();
	}

	public String getDeliveryChrageLimitField() {
		return deliveryChargeLimit.getText();
	}

	public void emailFieldUpdation() {
		editButton.click();
		emailField.clear();
		emailField.sendKeys(fu.generateEmail());
		// WebElement element =updateButton; no need to use this line since updatebutton
		// element already declared before
		gu.scrollAndClick(updateButton, driver, 0, 500);
		// updateButton.click();
	}

	public String getAlertText() {
		return alertText.getText();
	}

	public void resetMethod() {
		editButton.click();
		gu.scrollAndClick(resetButton, driver, 0, 500);
	}

}
