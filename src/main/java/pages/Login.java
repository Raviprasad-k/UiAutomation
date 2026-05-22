package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
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
	@FindBy(linkText = "Logout")
	private WebElement Logout;

	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loginPage(String mail, String pass) {
		myAccountLink.click();
		login.click();
		email.sendKeys(mail);
		password.sendKeys(pass);
		login_btn.click();
	}

	public void logout() {
		myAccountLink.click();
		Logout.click();
	}

}
