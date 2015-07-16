package search_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchHelper {
	public static void enterSearchTerm(WebDriver driver, String searchTerm,
			String resultText) throws Exception {
		driver.get("http://www.google.com");
		// new WebDriverWait(driver, 90).until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		driver.findElement(By.name("q")).sendKeys(searchTerm);
		driver.findElement(By.name("btnG")).click();
		Thread.sleep(3000);
		String outputText = driver.findElement(By.id("resultStats")).getText();
		if (outputText.contains(resultText)) {
			System.out.println("Strings Matched");

		} else {
			System.out.println("Different Result displayed: actual: "
					+ outputText + "expected: " + resultText);
		}
	}
}
