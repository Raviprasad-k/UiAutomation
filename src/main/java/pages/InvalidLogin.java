package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class InvalidLogin {
	WebDriver driver;

	@FindBy(linkText = "My Account")
	private WebElement myAccountLink;
	@FindBy(linkText = "Login")
	private WebElement login;
	@FindBy(id = "input-email")
	private WebElement email;
	@FindBy(id = "input-password")
	private WebElement password;
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement login_btn;
	@FindBy(xpath = "//div[contains(@class,'alert-danger')]")
	private WebElement loginErrorMessage;
	@FindBy(xpath = "//div[contains(text(),'Warning')]")
	private WebElement msg;

	public InvalidLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void invalidLoginPage(String mail, String pass) {
		myAccountLink.click();
		login.click();
		email.sendKeys(mail);
		password.sendKeys(pass);
		login_btn.click();
		String emsg = loginErrorMessage.getText();

	}

	public String getMsg() {
		return msg.getText();
	}

}
