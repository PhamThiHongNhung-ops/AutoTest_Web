package serenitybdd.Autotest.WebMyPham.steps.serenity;

import serenitybdd.Autotest.WebMyPham.pages.OrderPage;
import net.thucydides.core.annotations.Step;
import static org.junit.Assert.assertTrue;

public class OrderSteps {

    OrderPage page;

    @Step
	public void enter_name(String name) {
		page.enter_name(name);
		
	}
    @Step
	public void enter_email(String email) {
		page.enter_email(email);
		
	}
    @Step
	public void enter_phone(String phone) {
		page.enter_phone(phone);
		
	}
    @Step
	public void enter_address(String address) {
		page.enter_address(address);
		
	}
    @Step
	public void choose_payment_method(String method) {
		page.choose_payment_method(method);
		
	}
    @Step
	public void enter_note(String note) {
		page.enter_note(note);
		
	}
    @Step
	public void click_order_button() {
		page.click_order_button();
		
	}
    @Step
	public void check_order_sucess() {
		assertTrue(page.check_order_sucess());
	
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
	public void check_phone_fail(String result) {
    	assertTrue(page.check_phone_fail(result));
		
	}
    @Step
	public void check_address_fail(String result) {
    	assertTrue(page.check_address_fail(result));
		
	}
    
    @Step
	public void click_cancel_order() {
		page.click_cancel_order();
		
	}
    
    @Step
	public void click_cancel_button() {
		page.click_cancel_button();
		
	}
    @Step
	public void click_cancel_icon() {
		page.click_cancel_icon();
		
	}
    @Step
	public void enter_reason(String string) {
		page.enter_reason(string);
		
	}
    @Step
	public void click_save_button() {
		page.click_save_button();
		
	}
    @Step
	public void click_cancel_popup() {
		page.click_cancel_popup();
		
	}
    @Step
	public void click_OK_popup() {
		page.click_OK_popup();
		
	}
    @Step
	public void check_cancel_order_fail() {
		assertTrue(page.check_cancel_order_fail());
		
	}
    @Step
	public void check_cancel_order_success() {
    	assertTrue(page.check_cancel_order_success());
		
	}

   
}