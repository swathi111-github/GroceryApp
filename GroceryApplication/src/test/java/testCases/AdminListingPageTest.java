package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AdminListingPage;
import elementRepository.AdminPage;
import elementRepository.LoginPage;

public class AdminListingPageTest extends BaseClass {

	LoginPage lp;// lp - object of Loginpage - method calling -lp.login (objname.methodname)
	AdminPage ap;
	AdminListingPage adminlp;

	@Test
	public void newUserCreation() throws IOException {

		lp = new LoginPage(driver); // if this is not called , nullpointer exception would hit
		ap =lp.login(loginData(1,0),loginData(1,1));
		adminlp=ap.clickOnAdminUserMoreInfo();
		adminlp.newUserCreation("Smith01");
		adminlp.dropDown("Admin");
		adminlp.clickSaveButton();
		String actualMessage = adminlp.getAlertText();
		String expectedMessage = Constant.alp_newUserCreationExpectedMessage;
		Assert.assertEquals(actualMessage, expectedMessage,Constant.alp_newUserCreation);
	}

	@Test
	public void searchUser() throws IOException {
		lp = new LoginPage(driver); // if this is not called , nullpointer exception would hit
		ap =lp.login(loginData(1,0),loginData(1,1));
		adminlp=ap.clickOnAdminUserMoreInfo();
		ap.clickOnAdminUserMoreInfo();
		adminlp.clickSearchButton();
		String userName = adminlp.getAdminUserTableElementText(3, 1);
		adminlp.searchUserNameField(userName);
		adminlp.finalSearchButton();
		String actualName = userName;
		String expectedName = adminlp.returnFirstRowname();
		Assert.assertEquals(actualName, expectedName, Constant.alp_searchUser);
	}

	@Test
	public void updateUser() throws InterruptedException, IOException {
		lp = new LoginPage(driver); // if this is not called , nullpointer exception would hit
		ap =lp.login(loginData(1,0),loginData(1,1));
		adminlp=ap.clickOnAdminUserMoreInfo();
		adminlp.clickSearchButton();
		adminlp.editMethod();
		String actualMessage = adminlp.getAlertText();
		String expectedMessage = Constant.alp_updateUserExpectedMessage;
		Assert.assertEquals(actualMessage, expectedMessage, Constant.alp_updateUser);
	}

	@Test
	public void deleteUser() throws IOException {
		lp = new LoginPage(driver); // if this is not called , nullpointer exception would hit
		ap =lp.login(loginData(1,0),loginData(1,1));
		adminlp=ap.clickOnAdminUserMoreInfo();
		String deletedUserName = adminlp.returnFirstRowname(); // storing original userName before Deletion
		adminlp.deleteMethod();
		adminlp.clickSearchButton();
		String actualMessage = adminlp.getAlertText();
		String expectedMessage = Constant.alp_deleteUserExpectedMessage;
		Assert.assertEquals(actualMessage, expectedMessage, Constant.alp_deleteUser);
		adminlp.searchUserNameField(deletedUserName);
		adminlp.finalSearchButton();
		String searchResult = adminlp.resultNotFound();
		String expectedSearchResult =Constant.alp_deleteUserUserNotFoundExpectedMessage;
		Assert.assertEquals(searchResult, expectedSearchResult, Constant.alp_deleteUserStillListed);
	}
}
