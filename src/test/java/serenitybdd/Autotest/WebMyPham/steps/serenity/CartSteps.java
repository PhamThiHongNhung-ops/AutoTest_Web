package serenitybdd.Autotest.WebMyPham.steps.serenity;

import serenitybdd.Autotest.WebMyPham.pages.CartPage;
import net.thucydides.core.annotations.Step;
import static org.junit.Assert.assertTrue;

public class CartSteps {

    CartPage page;

    @Step
	public void click_product() {
		page.click_product();
		
	}
    @Step
	public void click_MuaNgay_button() {
		page.click_MuaNgay_button();
		
	}
    @Step
	public void open_cart_page() {
		page.open();
		
	}
    @Step
	public void check_add_product_to_cart_success(String s) {
		assertTrue(page.check_add_product_to_cart_success(s));
		
	}
    @Step
	public void click_payment_button() {
		page.click_payment_button();
		
	}

   
}