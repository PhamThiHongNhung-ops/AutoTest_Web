package serenitybdd.Autotest.WebMyPham.steps.serenity;

import serenitybdd.Autotest.WebMyPham.pages.HomePage;
import net.thucydides.core.annotations.Step;
import static org.junit.Assert.assertTrue;

public class HomeSteps {

    HomePage page;

    @Step
	public void openPage() {
		page.open();
		
	}

    @Step
	public void enterName(String name) {
		page.enterName(name);
		
	}

    @Step
	public void enterEmail(String email) {
		page.enterEmail(email);
		
	}

    @Step
	public void enterPhone(String phone) {
    	page.enterPhone(phone);
	}

    @Step
	public void enterPassword(String password) {
		page.enterPassword(password);
		
	}

    @Step
	public void clickSignUpButton() {
		page.clickSignUpButton();
		
	}

    @Step
	public void check_signup_sucsess(String result) {
		assertTrue(page.check_signup_sucsess(result));
		
	}

    @Step
	public void check_signup_fail(String result) {
		assertTrue(page.check_signup_fail(result));
		
	}

    @Step
	public void check_email_fail(String result) {
		assertTrue(page.check_email_fail(result));
		
	}
    
    @Step
	public void check_phone_fail(String result) {
		assertTrue(page.check_phone_fail(result));
		
	}
}