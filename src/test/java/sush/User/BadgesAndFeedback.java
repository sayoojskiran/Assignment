package sush.User;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LoginPage;
import sush.Admin.BaseClass;

public class BadgesAndFeedback extends BaseClass {
	
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());

	@BeforeTest
	public void launchBrowser() {
		driver = initializeDriver();
		driver.get(prop.getProperty("tempUrl"));
	}

	@Test(priority = 1)
	public void Login() {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.getUsername().sendKeys(prop.getProperty("studentUsername"));
		loginPage.getPassword().sendKeys(prop.getProperty("studentPass"));
		loginPage.loginBtn().click();

	}

	@Test(priority = 2)
	public void showBadges() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[contains(text(),'Badge and Feedback')]")).click();
		driver.findElement(By.xpath("//a[div[contains(text(),'Click here to claim your')]]")).click(); //Viewing badge
		Thread.sleep(3000);
		log.info("Badge is Viewed");
		
		log.info(driver.findElement(By.xpath("//div[@class='box generalbox center clearfix']//h3/b")).getText());
		log.info("Got the badge user has got");
		
		driver.findElement(By.xpath("//a[contains(text(),'Course Certification')]")).click(); //course certificate ISTQB Certificate
		driver.findElement(By.xpath("//a[div[contains(text(),'ISTQB Certificate')]]")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click(); // downloading certificate
		Thread.sleep(5000);
		log.info("Certificate is downloaded");

	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
