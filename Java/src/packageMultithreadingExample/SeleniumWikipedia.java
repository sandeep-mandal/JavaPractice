package packageMultithreadingExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumWikipedia {

	WebDriver driver;

	public SeleniumWikipedia(WebDriver driver) {
		this.driver = driver;
	}

	public void Search(String Searchtext) {

		driver.get("https://www.wikipedia.org/");

		WebElement oSearchText = driver.findElement(By.id("searchInput"));
		oSearchText.sendKeys(Searchtext);

		WebElement oSearchButton = driver.findElement(By.xpath("//i[@class='sprite svg-search-icon']"));
		oSearchButton.click();
	}
}
