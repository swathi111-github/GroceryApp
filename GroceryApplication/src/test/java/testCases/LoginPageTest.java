package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AdminListingPage;
import elementRepository.AdminPage;
import elementRepository.LoginPage;

public class LoginPageTest extends BaseClass{
	
	LoginPage lp;// lp - object of Loginpage - method calling -lp.login (objname.methodname)
	AdminPage ap;
	AdminListingPage adminlp;
  @Test(groups="Smoke")
  public void verifyDashBoardTextWhileloginWithValidCredentials() throws IOException {
	  
	  lp = new LoginPage(driver); //if this is not called , nullpointer exception would hit
	  adminlp = new AdminListingPage(driver);
	  ap =lp.login(loginData(1,0),loginData(1,1));//chaining
	  String actual = ap.getDashBoardText();
	  String expected =Constant.lp_dashboardExpectedMessage;   //to check assertion replace with dashboard1 & check
	  Assert.assertEquals(actual, expected,Constant.lp_verifyDashBoardTextWhileloginWithValidCredentialsDashboard);
	  String actualMsg = ap.getAdminUserText();
	  String expectedMsg = Constant.lp_adminUsersExpectedMessage;
	  Assert.assertEquals(actualMsg, expectedMsg, Constant.lp_verifyDashBoardTextWhileloginWithValidCredentialsAdminUsers); 	  
	  //Hard assertion - used here. if error comes, execution will stop
	  //soft assertion - if error comes, not interrupt the project flow. execution will continue
	  
  }


@Test(dataProvider="loginCheck", groups="Smoke")
 public void verifyAlertWhileLoginWithInValidCredentials(String userName ,String password)
 {
	 lp = new LoginPage(driver);
	 lp.login(userName,password);
	 String actualMessage = lp.getAlertText();
	 String expectedMessage = Constant.lp_invalidLoginAlertExpectedMessage;
	 Assert.assertEquals(actualMessage, expectedMessage, Constant.lp_verifyAlertWhileLoginWithInValidCredentials);
 }

@DataProvider(name = "loginCheck") // DataProvider -one method can be used multiple times
public Object[][] loginDataProvider() {
	return new Object[][]
			{ { "paul", "admin" }, 
		      { "admin", "567" } };
}

}
//this is testng class. calling the functions in the login java class in this testng class
