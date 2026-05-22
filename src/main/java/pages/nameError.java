package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class nameError {
	
	@Test
	public void name() {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		/*driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.name("lastname")).sendKeys("kumar");
		driver.findElement(By.name("email")).sendKeys("testu@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("949465342");
		driver.findElement(By.name("password")).sendKeys("Pass@1234");
		driver.findElement(By.name("confirm")).sendKeys("Pass@1234");
		
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String expected = "First Name must be between 1 and 32 characters!";
		String actual = driver.findElement(By.xpath("//div[text()='First Name must be between 1 and 32 characters!']")).getText();
		Assert.assertEquals(expected, actual);*/
		
		List<WebElement> pages = driver.findElements(By.xpath("//ul[@id='pagination']//a"));
        int totalPages = pages.size();

        // 2. Loop through all pages
        for (int p = 1; p <= totalPages; p++) {
            
            // Navigate to page 'p' using a dynamic XPath text locator
            WebElement pageLink = driver.findElement(By.xpath("//ul[@id='pagination']//a[text()='" + p + "']"));
            pageLink.click();
            
            // Brief pause for the JavaScript pagination function to refresh the table
            

            // 3. Search for target checkboxes matching "Laptop" or "Router" on the current page
            List<WebElement> targetCheckboxes = driver.findElements(By.xpath(
                "//table[@id='productTable']//tr[td[text()='Laptop' or text()='Router']]//input[@type='checkbox']"
            ));

            // 4. If any matches are found on this page, click them
            for (WebElement checkbox : targetCheckboxes) {
                if (!checkbox.isSelected()) {
                    checkbox.click();
                    System.out.println("Successfully selected a target item checkbox on page " + p);
                }
            }
        }

        // Keep browser open briefly for visual confirmation
        
		
	}

}
