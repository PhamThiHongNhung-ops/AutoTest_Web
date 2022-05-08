package serenitybdd.Autotest.WebMyPham.steps.serenity;


import serenitybdd.Autotest.WebMyPham.pages.ContactPage;
import net.thucydides.core.annotations.Step;
import static org.junit.Assert.assertTrue;

public class ContactSteps {

    ContactPage page;

    @Step
	public void enter_name(String name) {
		page.enter_name(name);
		
	}
    @Step
	public void enter_email(String email) {
		page.enter_email(email);
		
	}
    @Step
	public void enter_content(String content) {
		page.enter_content(content);
		
	}
    @Step
	public void click_submit_button() {
		page.click_submit_button();
		
	}
    @Step
	public void check_send_contact_success() {
		assertTrue(page.check_send_contact_success());
		
	}
    @Step
	public void open_page() {
		page.open();
		
	}
    @Step
	public void check_send_contact_fail(String result) {
		assertTrue(page.check_send_contact_fail(result));
		
	}
    @Step
	public void check_name_fail(String result) {
    	assertTrue(page.check_name_fail(result));
		
	}
    @Step
	public void check_email_fail(String result) {
    	assertTrue(page.check_email_fail(result));
		
	}
    @Step
	public void check_content_fail(String result) {
    	assertTrue(page.check_content_fail(result));
		
	}
   
}