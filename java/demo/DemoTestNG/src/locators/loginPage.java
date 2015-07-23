package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
    // Here's the element
    public static WebElement loginBtn;

    public static void LoginBtn(WebDriver driver) {
        loginBtn = driver.findElement(By.xpath("//button[contains(.,'Login')]"));
        loginBtn.click();
    }
} 
