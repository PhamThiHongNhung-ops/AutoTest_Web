package serenitybdd.Autotest.WebMyPham.steps.serenity;

import serenitybdd.Autotest.WebMyPham.pages.AdminPage;
import serenitybdd.Autotest.WebMyPham.pages.HomePage;
import net.thucydides.core.annotations.Step;
import static org.junit.Assert.assertTrue;

public class AdminSteps {

    AdminPage page;

    @Step
	public void openPage() {
		page.open();
		
	}
    @Step
	public void click_add_product_button() {
		page.click_add_product_button();
		
	}
    @Step
	public void enter_product_name(String productName) {
		page.enter_product_name(productName);
		
	}
    @Step
	public void select_product_type(String string) {
		page.select_product_type(string);
		
	}
    @Step
	public void upload_image(String string) {
		page.upload_image(string);
		
	}
    @Step
	public void enter_description(String string) {
		page.enter_description(string);
		
	}
    @Step
	public void enter_price(String string) {
		page.enter_price(string);
		
	}
    @Step
	public void enter_percent_discount(String string) {
		page.enter_percent_discount(string);
		
	}
    @Step
	public void choose_product_rating(String string) {
		page.choose_product_rating(string);
		
	}
    @Step
	public void choose_status(String string) {
		page.choose_status(string);
		
	}
    @Step
	public void click_add_button() {
    	page.click_add_button();
		
	}
    @Step
	public void enter_search(String name) {
		page.enter_search(name);
		
	}
    @Step
	public void check_add_product_success() {
		assertTrue(page.check_add_product_success());
		
	}
    @Step
	public void click_edit_button() {
		page.click_edit_button();
		
	}
    @Step
	public void click_update_button() {
		page.click_update_button();
		
	}
    @Step
	public void click_delete_button() {
		page.click_delete_button();
		
	}
    @Step
	public void check_delete_success() {
		assertTrue(page.check_delete_success());
	}

   
}