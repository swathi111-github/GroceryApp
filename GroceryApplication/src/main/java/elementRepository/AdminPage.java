package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {
WebDriver driver;
	
	public AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory -@findby annotation to find elements
	}
	
	@FindBy(xpath = "//a[@class='nav-link']//p[contains(text(),'Dashboard')]")
	WebElement dashBoard;
	@FindBy(xpath = "//div[@class='small-box bg-info']//p[text()='Admin Users']")
	WebElement adminUsers;
	@FindBy(xpath = "//div[@class='small-box bg-info']//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	WebElement adminUserMoreInfo;
	@FindBy(xpath = "//div[@class='inner']//p[text()='Manage Contact']")
	WebElement manageContact;
	@FindBy(xpath = "//div[@class='small-box bg-info']//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']")
	WebElement manageContactMoreInfo;
	
	public AdminListingPage clickOnAdminUserMoreInfo()
	{
		adminUserMoreInfo.click();
		return new AdminListingPage(driver);
	}
	
	public String getDashBoardText()
	{
		return dashBoard.getText();
	}
	
	public String getAdminUserText()
	{
		return adminUsers.getText();
	}
     
	public String getManageContactText()
	{
		return manageContact.getText();
	}
	public ManageContactPage clickOnmanageContactMoreInfo()
	{
		manageContactMoreInfo.click();
		return new ManageContactPage(driver);
	}
}
