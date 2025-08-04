package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory -@findby annotation to find elements
	}
	
	//LoginPage(WebDriver driver) -constructor with parameter
	
	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement userNameField;
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement passWordField;
	@FindBy(xpath="//button[text()='Sign In']")
	WebElement signIn;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']//h5[text()=' Alert!']")
	WebElement alertMessage;
	
	public AdminPage login(String userName, String password)
	{
		userNameField.sendKeys(userName);
		passWordField.sendKeys(password);
		signIn.click();
		return new AdminPage(driver);
	}
	
	public String getAlertText()
	{
		return alertMessage.getText();
	}


}
