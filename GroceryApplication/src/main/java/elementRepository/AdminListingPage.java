package elementRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.FakerUtility;
import utilities.GeneralUtility;
import utilities.WaitUtility;

public class AdminListingPage {

	WebDriver driver;
	GeneralUtility gu = new GeneralUtility();//object creation -then calling with this obj in another method
	FakerUtility fu = new FakerUtility();
	WaitUtility wu = new WaitUtility();

	public AdminListingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory -@findby annotation to find elements
	}

	@FindBy(xpath = "//div[@class='col-sm-12']//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(id = "username")
	WebElement userName;
	@FindBy(id = "password")
	WebElement passWord;
	@FindBy(id = "user_type")
	WebElement dropDown;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertText;
	@FindBy(xpath = "//div[@class='col-sm-12']//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	@FindBy(id = "un")
	WebElement searchUserName;
	@FindBy(name = "Search")
	WebElement finalSearchButton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]")
	WebElement tableElementName;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[5]//i[@class='fas fa-edit']")
	WebElement firstRowEditButton;
	@FindBy(name = "Update")
	WebElement update;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[5]//i[@class='fas fa-trash-alt']")
	WebElement firstRowDeleteButton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[5]//i[@class='fas fa-trash-alt']")
	WebElement firstRowDeleteAlertButton;

	public void newUserCreation(String password) {
		newButton.click();
		userName.sendKeys(fu.generateName()); // generte unique name every time(dummy values)
		// userName.sendKeys("Amala" +gu.generateCurrentDateAndTime());
		// userName.sendKeys("Amala" +gu.randon(50));
		passWord.sendKeys(password);

	}

	public void dropDown(String text) {
		wu.WaitUntilWebElementClickable(driver, dropDown, 10);
		gu.selectDropdownWithValue(dropDown, text);
	}

	public void clickSaveButton() {
		saveButton.click();
		// gu.clickJavaScriptExecutor(saveButton, driver);
	}

	public String getAlertText() {
		return alertText.getText();
	}

	public void clickSearchButton() {
		searchButton.click();
	}

	public String getAdminUserTableElementText(int row, int column) {
		String path = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + row + "]//td["
				+ column + "]";
		WebElement element = driver.findElement(By.xpath(path));
		return element.getText();
	}

	public void searchUserNameField(String userName) {
		searchUserName.sendKeys(userName);
	}

	public void finalSearchButton() {
		finalSearchButton.click();
	}

	public String returnFirstRowname() {
		WebElement firstRowName = driver.findElement(
				By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]"));
		return firstRowName.getText();
	}

	public void editMethod() throws InterruptedException {
		gu.clickJavaScriptExecutor(firstRowEditButton, driver);
		// firstRowEditButton.click();
		userName.clear();
		userName.sendKeys(fu.generateName());
		update.click();
	}

	public void deleteMethod() {
		firstRowDeleteButton.click();
		String alertText = driver.switchTo().alert().getText();
		System.out.println(alertText);
		driver.switchTo().alert().accept();
	}

	public String resultNotFound() {
		WebElement element = driver
				.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td"));
		return element.getText();
	}
}
