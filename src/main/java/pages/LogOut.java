package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOut {
	WebDriver driver;

	@FindBy(linkText = "My Account")
	private WebElement MyAccount;
	@FindBy(linkText = "Logout")
	private WebElement Logout;
	@FindBy(xpath = "//div[@id='content']/p")
	private WebElement logoutMsg;

	public LogOut(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void logOut() {
		MyAccount.click();
		Logout.click();
	}

	public String getLogOutMsg() {
		return logoutMsg.getText();
	}
}
