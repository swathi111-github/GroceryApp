package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AdminListingPage;
import elementRepository.AdminPage;
import elementRepository.LoginPage;
import elementRepository.ManageContactPage;

public class ManageContactTest extends BaseClass {

	LoginPage lp;// lp - object of Loginpage - method calling -lp.login (objname.methodname)
	AdminPage ap;
	AdminListingPage adminlp;
	ManageContactPage mp;

	@Test
	public void manageContactDetailPage() throws IOException {

		lp = new LoginPage(driver); // if this is not called , nullpointer exception would hit
		ap =lp.login(loginData(1,0),loginData(1,1));
		String text = ap.getManageContactText();
		System.out.println(text);
		mp=ap.clickOnmanageContactMoreInfo();
		String phoneField = mp.getPhoneField();
		String emailField = mp.getEmailField();
		String addressField = mp.getAddressField();
		String deliveryTimeField = mp.getDeliveryTimeField();
		String deliveryChargeLimitField = mp.getDeliveryChrageLimitField();
		System.out.println("Phone: " + phoneField + ", Email: " + emailField + ", Address :" + addressField
				+ ", Delivery_Time: " + deliveryTimeField + ", DeliveryChargeLimit: " + deliveryChargeLimitField + "");

	}

	@Test
	public void emailUpdation() throws IOException {

		lp = new LoginPage(driver); // if this is not called , nullpointer exception would hit
		ap =lp.login(loginData(1,0),loginData(1,1));
		mp=ap.clickOnmanageContactMoreInfo();
		mp.emailFieldUpdation();
		String actualMessage = mp.getAlertText();
		String expectedMessage = "×\nAlert!\nContact Updated Successfully";
		Assert.assertEquals(actualMessage, expectedMessage, Constant.mp_emailUpdation);
	}

	@Test
	public void resetMethod() throws IOException {

		lp = new LoginPage(driver); // if this is not called , nullpointer exception would hit
		ap =lp.login(loginData(1,0),loginData(1,1));
		mp=ap.clickOnmanageContactMoreInfo();
		mp.resetMethod();
		String currentURL = driver.getCurrentUrl();
		String expectedURL = "https://groceryapp.uniqassosiates.com/admin/list-contact";
		Assert.assertEquals(currentURL, expectedURL, Constant.mp_restMethod);
	}
}
