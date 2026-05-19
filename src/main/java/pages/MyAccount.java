package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {
	private WebDriver driver;
	
	@FindBy(linkText = "My Account") private WebElement myAccountLink;
	@FindBy(linkText = "Register") private WebElement register;
	@FindBy(id = "input-firstname")private WebElement firstName;
	@FindBy(id = "input-lastname")private WebElement lastName;
	@FindBy(id = "input-email")private WebElement email;
	@FindBy(id = "input-telephone")private WebElement telephone;
	@FindBy(id = "input-password")private WebElement password;
	@FindBy(id = "input-confirm")private WebElement password_confirm;
	@FindBy(xpath = "//input[@name='newsletter' and @value='1']")private WebElement subscribe;
	@FindBy(name = "agree")private WebElement checkBox;
	@FindBy(xpath = "//input[@type='submit']")private WebElement continue_btn;
	@FindBy(xpath = "//div[@id='content']/p") private WebElement msg;
	
	public MyAccount(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickMyAccount() {
		myAccountLink.click();
	}
	
	public void clickRegister() {
		register.click();
	}
	
	public void createAccount(String fName, String lName, String emaill, String number, String pass) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		email.sendKeys(emaill);
		telephone.sendKeys(number);
		password.sendKeys(pass);
		password_confirm.sendKeys(pass);
	}
	public void clickBtns() {
		subscribe.click();
		checkBox.click();
		continue_btn.click();
	}
	
	public String getMsg() {
		return msg.getText();
	}
}
