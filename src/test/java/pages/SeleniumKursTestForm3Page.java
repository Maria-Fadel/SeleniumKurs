package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SeleniumKursTestForm3Page {

	WebDriver driver;

	@FindBy(id = "form-widgets-bezeichnung")
	private WebElement inputBezeichnung;

	@FindBy(id = "form-widgets-kennung")
	private WebElement inputKennung;

	@FindBy(id = "form-widgets-anschrift")
	private WebElement inputAnschrift;

	@FindBy(id = "form-widgets-telefon")
	private WebElement inputTelefon;

	@FindBy(id = "form-widgets-str")
	private WebElement inputStrasse;

	@FindBy(id = "form-widgets-plz")
	private WebElement inputPlz;

	@FindBy(id = "form-widgets-ort")
	private WebElement inputOrt;

	// form-widgets-auswahl1 SELECT

	@FindBy(id = "form-widgets-auswahl1")
	private WebElement selectAuswahl1;

	@FindBy(id = "form-widgets-name")
	private WebElement inputName;

	@FindBy(id = "form-widgets-vorname")
	private WebElement inputVorname;

	@FindBy(id = "form-widgets-geburt")
	private WebElement inputGeburt;

	@FindBy(id = "form-widgets-telefonv")
	private WebElement inputTelefonPerson;

	@FindBy(id = "form-widgets-strv")
	private WebElement inputStrPerson;

	@FindBy(id = "form-widgets-plzv")
	private WebElement inputPlzPerson;

	@FindBy(id = "form-widgets-ortv")
	private WebElement inputOrtPerson;

	@FindBy(name = "form.buttons.speichern")
	private WebElement btn_speichern;

	@FindBy(id = "message")
	private WebElement textStatus1;

	@FindBy(xpath = "//*[@id='auswahl']//li[1]")
	private WebElement textStatus2;

	public SeleniumKursTestForm3Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String status1TextAuslesen() {
		return textStatus1.getText();
	}

	public String status2TextAuslesen() {
		return textStatus2.getText();
	}

	public void speichernAnklicken() {
		btn_speichern.click();
	}

	public void versicherungsBezeichnungEingeben(String bezeichnung) {
		this.inputBezeichnung.sendKeys(bezeichnung);
	}

	public void versicherungsKennungEingeben(String kennung) {
		this.inputKennung.sendKeys(kennung);
	}

	public void versicherungsAnschriftEingeben(String anschrift) {
		this.inputAnschrift.sendKeys(anschrift);
	}

	public void versicherungsTelefonNummerEingeben(String telefon) {
		this.inputTelefon.sendKeys(telefon);
	}

	public void versicherungsStrasseEingeben(String strasse) {
		this.inputStrasse.sendKeys(strasse);
	}

	public void versicherungsPostleitZahlEingeben(String plz) {
		this.inputPlz.sendKeys(plz);
	}

	public void versicherungsOrtEingeben(String ort) {
		this.inputOrt.sendKeys(ort);
	}

	public void auswahl1Eingeben(String auswahl) {
		Select auswahl1 = new Select(selectAuswahl1);
		auswahl1.selectByValue(auswahl);
	}

	public void personenNamenEingeben(String name) {
		this.inputName.sendKeys(name);
	}

	public void personenVornameEingeben(String vorname) {
		this.inputVorname.sendKeys(vorname);
	}

	public void personenGeburtsDatumEingeben(String geburtsdatum) {
		this.inputGeburt.sendKeys(geburtsdatum);
	}

	public void personenTelefonEingeben(String telefon) {
		this.inputTelefonPerson.sendKeys(telefon);
	}

	public void personenStrasseEingeben(String strasse) {
		this.inputStrPerson.sendKeys(strasse);
	}

	public void personenPostleitzahlEingeben(String plz) {
		this.inputPlzPerson.sendKeys(plz);
	}

	public void personenOrtEingeben(String ort) {
		this.inputOrtPerson.sendKeys(ort);
	}

}
