package serenitybdd.Autotest.WebMyPham.features.search;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.ClearCookiesPolicy;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Qualifier;
import serenitybdd.Autotest.WebMyPham.common.Util;
import serenitybdd.Autotest.WebMyPham.steps.serenity.CartSteps;
import serenitybdd.Autotest.WebMyPham.steps.serenity.LoginSteps;
import serenitybdd.Autotest.WebMyPham.steps.serenity.OrderSteps;

@RunWith(SerenityParameterizedRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@UseTestDataFrom(value="data/order.csv")
public class Order {

	@Managed(uniqueSession = true, clearCookies = ClearCookiesPolicy.Never)
	public WebDriver webdriver;

	String testcase,name,email,phone,address,method,note,result;
	
	@Qualifier
	public String qualifier() {
		return this.testcase;
	}
	
	@Steps
	public LoginSteps login;
	
	@Steps
	public CartSteps cart;
	
	@Steps
	public Search search;
	
	@Steps
	public OrderSteps order;

	@Test
    public void OderProduct() {
		String productName = "Son lì Maybelline Creamy Mattes MNU 09 Chili Nude";
		EnvironmentVariables variable = SystemEnvironmentVariables.createEnvironmentVariables();
		String username = variable.getProperty("project.username");
		String password = variable.getProperty("project.password");
		login.login(username, password);
		search.search_product(productName);
		Util.delay(2000);
		cart.click_product();
		cart.click_MuaNgay_button();
		cart.open_cart_page();
		cart.click_payment_button();
		enter_shipping_infomation();
		if(result.equals("sucess")) {
			order.check_order_sucess();
		} else if(name.equals("")) {
			order.check_name_fail(result);
		} else if(email.equals("") || !email.contains("@")) {
			order.check_email_fail(result);
		} else if(phone.equals("") || result.equals("Please match the requested format.")) {
			order.check_phone_fail(result);
		} else if(address.equals("")) {
			order.check_address_fail(result);
		} 
			
    }
	
	private void enter_shipping_infomation() {
		order.enter_name(name);
		order.enter_email(email);
		order.enter_phone(phone);
		order.enter_address(address);
		order.choose_payment_method(method);
		order.enter_note(note);
		order.click_order_button();
	}

}