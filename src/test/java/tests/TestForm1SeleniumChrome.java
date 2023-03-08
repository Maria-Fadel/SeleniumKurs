package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.SeleniumKursHomePage;
import pages.SeleniumKursLoginPage;
import pages.SeleniumKursTestApplikatioinenPage;
import pages.SeleniumKursTestForm1Page;

import de.kiel.seleniumkurs.configuration.Config;
import de.kiel.seleniumkurs.configuration.DriverHelper;

public class TestForm1SeleniumChrome {

	WebDriver driver;

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
		loginPage.zugangsdatenEingeben("selenium42", "R5vxI0j60");
		loginPage.logingButtonAnkilcken();
		
		SeleniumKursHomePage homePage = new SeleniumKursHomePage(driver);
		homePage.menuAusklappen();
		homePage.seleniumTestApplikationAnklicken();
		SeleniumKursTestApplikatioinenPage testAppPage = new SeleniumKursTestApplikatioinenPage(driver);
		testAppPage.testForm1klicken();
		
		SeleniumKursTestForm1Page testForm1Page = new SeleniumKursTestForm1Page(driver);
		testForm1Page.betreffEingeben("Automatishcer Test");
		testForm1Page.nameEingaben("Fadel");
		testForm1Page.kursAuswaehlen("Java Grundlagen Kurs mit Dieter");
		testForm1Page.firmaInbox1Auswaehlen(new int[] {2,4,6});
		testForm1Page.firmenUebernehmen();
		testForm1Page.firmaInbox2Auswaehlen(new int[] {2,});
		testForm1Page.ausgewaehlteFirmenNachObenVereschieben();
		
		testForm1Page.formaularSpeichern();
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement headline = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
		
		String erfolgsmeldung  = testForm1Page.statusMeldungsAuslesen();
		assertTrue(erfolgsmeldung.contains("Java Grundlagen Kurs"));
		String erstesElement = testForm1Page.erstesListenElementAuslesen();
		assertEquals(erstesElement,"Magazzini Alimentari Riuniti");
							
	}

}
