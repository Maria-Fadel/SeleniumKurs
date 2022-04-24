package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumKursHomePage {
	
	
	// Eingabefelder
	private WebDriver driver;
	
	@FindBy(xpath="//div[@class='portalMessage info']")
	private WebElement statusMeldung;
	
	@FindBy(xpath="//i[@id='portaltab-burger-menu']")
	private WebElement btnMenu;
	
	@FindBy(xpath="//span[normalize-space()='Selenium Testapplikationen']")
	private WebElement seleniumTestApplikationen;

	public SeleniumKursHomePage(WebDriver driver) {
	
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public String statusMeldungAuslesen() {
		return statusMeldung.getText();
	}
	public void menuAusklappen() {
		btnMenu.click();
	}
	public void seleniumTestApplikationAnklicken() {
		seleniumTestApplikationen.click();
	}

	
	
	
	
}
