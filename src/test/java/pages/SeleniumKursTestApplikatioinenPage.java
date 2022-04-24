package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumKursTestApplikatioinenPage {

	WebDriver driver;

	@FindBy(xpath = "//i[@id='portaltab-burger-menu']")
	private WebElement btnMenu;

	@FindBy(linkText = "Selenium Test Form1")
	private WebElement seleiumTestFrom1;

	// Link Drag and Drop Beispiel
	@FindBy(linkText = "Drag and Drop Beispiel")
	private WebElement linkDragDrop;

	// Link IFrame Test
	@FindBy(linkText = "IFrame Beispiel")
	private WebElement linkIframeTest;

	// Link Web Element Beispiele
	@FindBy(linkText = "Web Elemente")
	private WebElement linkWebElemente;

	// Link Katzensuche Testseite (AJAX)
	@FindBy(linkText = "Katzensuche Testseite (AJAX)")
	private WebElement linkKatzenSuche;

	// Link TestForm3 Data Driven
	@FindBy(linkText = "Testform3 DataDriven")
	private WebElement linkTestForm3;

	public SeleniumKursTestApplikatioinenPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void menuAusklappen() {
		btnMenu.click();
	}

	public void testForm1klicken() {
		seleiumTestFrom1.click();
	}

	public void dragAndDropTestAnklicken() {
		linkDragDrop.click();
	}

	public void iframeTestAnklicken() {
		linkIframeTest.click();
	}

	public void webElementeBeispielAnklicken() {
		linkWebElemente.click();
	}

	public void katzenSucheBeispielAnklicken() {
		linkKatzenSuche.click();
	}

	public void testForm3Anklicken() {
		linkTestForm3.click();
	}
}
