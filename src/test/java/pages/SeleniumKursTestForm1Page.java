package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumKursTestForm1Page {

	private WebDriver driver;
	private WebDriverWait wait;

	public SeleniumKursTestForm1Page(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,5);
		PageFactory.initElements(driver, this);
	}

	@FindBy(tagName = "h1")
	private WebElement testFormHeadline;

	@FindBy(id = "form-widgets-betreff")
	private WebElement inputBetreff;

	@FindBy(id = "form-widgets-name")
	private WebElement inputName;

	@FindBy(id = "form-widgets-auswahl1")
	private WebElement selectKurs;

	@FindBy(id = "form-widgets-auswahl2-from")
	private WebElement selectFirmaBox1;

	@FindBy(name = "from2toButton")
	private WebElement btnAuswahlFirmaBox1;

	@FindBy(id = "form-widgets-auswahl2-to")
	private WebElement selectFirmaBox2;

	@FindBy(name = "upButton")
	private WebElement btnAuswahlObenBox2;

	@FindBy(name = "form.buttons.speichern")
	private WebElement btnSpeicherDokument;

	@FindBy(id = "message")
	private WebElement statusMeldung;

	@FindBy(css = "section[id='portal-content'] li:nth-child(1)")
	private WebElement textErstElementListeFirma;

	
	
	
	
	public void betreffEingeben(String betreff) {
		inputBetreff.sendKeys(betreff);

	}
	public void nameEingaben(String name) {
		inputName.sendKeys(name);
	}
	public void kursAuswaehlen(String kursName) { // how to use select
		Select selectKurs = new Select(this.selectKurs);
		selectKurs.selectByVisibleText(kursName);
	}
	public void firmaInbox1Auswaehlen(int[] auswahl) {
		Select selectFirma = new Select(this.selectFirmaBox1);
		for (int i : auswahl) {
			selectFirma.selectByIndex(i);
		}
	}
	public void firmenUebernehmen() {
		btnAuswahlFirmaBox1.click();
	}
	public void firmaInbox2Auswaehlen(int[] auswahl) {
		Select selectFirma = new Select(this.selectFirmaBox2);
		for (int i : auswahl) {
			selectFirma.selectByIndex(i);
		}
	}
	public void ausgewaehlteFirmenNachObenVereschieben() {
		btnAuswahlObenBox2.click();
	}
	public void formaularSpeichern() {
		btnSpeicherDokument.click();
	}
	public String statusMeldungsAuslesen() {
		return statusMeldung.getText();
	}
	public String erstesListenElementAuslesen() {
		return textErstElementListeFirma.getText();
	}
	public String ueberschriftAuslesen() {
		return testFormHeadline.getText();
	}
	
	
}
