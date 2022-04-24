package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumKursLoginPage {

	
	// Eingabefelder
	private WebDriver driver;
	
	@FindBy(xpath = "//input[@id='__ac_name']")
	private WebElement inputBenutzername;

	@FindBy(xpath = "//input[@id='__ac_password']")
	private WebElement inputPassword;
	
	@FindBy(xpath ="//input[@name='buttons.login']")
	private WebElement btnAnmeldung; 
	
	
	// Statusmeldung

	@FindBy(xpath= "//h1[@class='documentFirstHeading']")
	private WebElement statusMeldung;
	
	// initialize 
	
	// Constructor
	public SeleniumKursLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // um be able to use @FindBy
	}

	// Methode
	public void zugangsdatenEingeben(String beuntzername, String password) {
		inputBenutzername.sendKeys(beuntzername);
		System.out.println("Benutzername erfolgreich");
		inputPassword.sendKeys(password);
		System.out.println("Password erfolgreich");
	}
	public void logingButtonAnkilcken() {
		btnAnmeldung.click();
	}
	public String statusMeldungAuslesen() {
		return statusMeldung.getText();
	}

}
