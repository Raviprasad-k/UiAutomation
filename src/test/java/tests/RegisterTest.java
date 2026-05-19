package tests;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InvalidLogin;
import pages.LogOut;
import pages.Login;
import pages.MyAccount;
import utils.ConfigReader;
import utils.ReportManager;

public class RegisterTest extends BaseTest {

	String fname = ConfigReader.get("firstName");
	String lname = ConfigReader.get("lastName");
	String mail = ConfigReader.get("email");
	String number = ConfigReader.get("telephone");
	String pass = ConfigReader.get("password");
	String wpass = ConfigReader.get("Wrong_Password");

	@Test(priority = 0)
	public void registerAccount() {

		String expected_msg = "Congratulations! Your new account has been successfully created!";
		log.info("Executing Scenario 1 registerAccount...");
		MyAccount ma = new MyAccount(driver);
		ma.clickMyAccount();
		log.info("Clicked on My account...");
		ma.clickRegister();
		log.info("Clicked on Register...");
		ma.createAccount(fname, lname, mail, number, pass);
		log.info("Filling the details");
		ma.clickBtns();

		String msg = ma.getMsg();
		Assert.assertEquals(msg, expected_msg);
		log.info("Scenario 1 is now completed...");

	}

	@Test(priority = 1, dependsOnMethods = "registerAccount")
	public void loggingOut() {

		log.info("Executing Scenario 2 registerAccount...");
		LogOut lo = new LogOut(driver);
		lo.logOut();
		String msg = lo.getLogOutMsg();

		Assert.assertEquals(msg, "You have been logged off your account. It is now safe to leave the computer.");

	}

	@Test(priority = 2)
	public void loggingIn() {
		log.info("Executing Scenario 3 registerAccount...");
		Login l = new Login(driver);
		l.loginPage(mail, pass);

		loggingOut();
	}

	@Test(priority = 3)
	public void invalidLogin() {
		log.info("Executing Scenario 4 registerAccount...");
		InvalidLogin il = new InvalidLogin(driver);
		il.iloginPage(mail, wpass);

	}

	@Test(retryAnalyzer = utils.RetryAnalyzer.class)
	public void testMethod() {
		Assert.assertTrue(false);
	}

	@AfterSuite
	public void flushReport() {
		ReportManager.flushReports();
	}
}
