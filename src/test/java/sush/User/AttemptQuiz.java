package sush.User;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LoginPage;
import sush.Admin.BaseClass;

public class AttemptQuiz extends BaseClass {
	
	@BeforeTest
	public void launchBrowser() {
		driver = initializeDriver();
		driver.get(prop.getProperty("studentUrl"));
	}

	@Test(priority = 1)
	public void checkLogin() {
		String actultitle = driver.getTitle();
		String searchPageTitle = "Qualicoach: Administration: Search";
		if (!(actultitle.equalsIgnoreCase(searchPageTitle))) {
			LoginPage loginPage = new LoginPage(driver);
			loginPage.getUsername().sendKeys(prop.getProperty("studentUsername"));
			loginPage.getPassword().sendKeys(prop.getProperty("studentPass"));
			loginPage.loginBtn().click();
		}
	}
	
	@Test(priority = 2)
	public void attempt() {
		
	}

}
