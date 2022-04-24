package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import de.kiel.seleniumkurs.configuration.Config;
import de.kiel.seleniumkurs.configuration.DriverHelper;
import pages.SeleniumKursHomePage;
import pages.SeleniumKursLoginPage;
import pages.SeleniumKursTestApplikatioinenPage;
import pages.SeleniumKursTestForm1Page;

@RunWith(Parameterized.class)
public class TestForm1ParameterizedSeleniumChrome {

	WebDriver driver;

	String username;
	String password;
	String betreff;
	String name;
	String kursTitel;
	int[] firmenBox1;
	int[] firmenBox2;
	String assert1;
	String assert2;

	public TestForm1ParameterizedSeleniumChrome(String testName, String username, String password, String betreff,
			String name, String kursTitel, int[] firmenBox1, int[] firmenBox2, String assert1, String assert2) {

		this.username = username;
		this.password = password;
		this.betreff = betreff;
		this.name = name;
		this.kursTitel = kursTitel;
		this.firmenBox1 = firmenBox1;
		this.firmenBox2 = firmenBox2;
		this.assert1 = assert1;
		this.assert2 = assert2;
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("initialisiere Webdriver");
		driver = DriverHelper.getDriver(Config.getBrowserName("browser"));
		driver.get(Config.getBasURL());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

	}

	@After
	public void tearDown() throws Exception {

		System.out.println("Test abgeschlossen");
		// driver.close();
	}

	@Test
	public void test() {
		SeleniumKursLoginPage loginPage = new SeleniumKursLoginPage(driver);
		loginPage.zugangsdatenEingeben(username, password);
		loginPage.logingButtonAnkilcken();

		SeleniumKursHomePage homePage = new SeleniumKursHomePage(driver);
		homePage.menuAusklappen();
		homePage.seleniumTestApplikationAnklicken();
		SeleniumKursTestApplikatioinenPage testAppPage = new SeleniumKursTestApplikatioinenPage(driver);
		testAppPage.testForm1klicken();

		SeleniumKursTestForm1Page testForm1Page = new SeleniumKursTestForm1Page(driver);
		testForm1Page.betreffEingeben(betreff);
		testForm1Page.nameEingaben(name);
		testForm1Page.kursAuswaehlen(kursTitel);
		testForm1Page.firmaInbox1Auswaehlen(firmenBox1);
		testForm1Page.firmenUebernehmen();
		testForm1Page.firmaInbox2Auswaehlen(firmenBox2);
		testForm1Page.ausgewaehlteFirmenNachObenVereschieben();

		testForm1Page.formaularSpeichern();

		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement headline = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));

		String erfolgsmeldung = testForm1Page.statusMeldungsAuslesen();
		assertTrue(erfolgsmeldung.contains(assert1));
		String erstesElement = testForm1Page.erstesListenElementAuslesen();
		assertEquals(erstesElement, assert2);

	}

	@Parameters(name = "{0}")
	public static Collection<Object[]> provideTestData() throws Exception {

		Collection<Object[]> collection;

		Object[][] daten = { { "Test Form 1 Test 1 FireFox", "selenium102", "codingsolo", "Parametrisierter Test 1",
				"Dieter", "Java Grundlagen Kurs mit Dieter", new int[] { 2, 4, 6 }, new int[] { 2 },
				"Java Grundlagen Kurs", "Magazzini Alimentari Riuniti" } };

		List<Object[]> listObjects = Arrays.asList(daten);
		collection = new ArrayList<Object[]>(listObjects);

		return collection;
	}

}
