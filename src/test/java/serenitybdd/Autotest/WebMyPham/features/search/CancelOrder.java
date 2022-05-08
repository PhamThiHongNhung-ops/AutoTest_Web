package serenitybdd.Autotest.WebMyPham.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.ClearCookiesPolicy;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

import java.sql.Driver;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import serenitybdd.Autotest.WebMyPham.common.Util;
import serenitybdd.Autotest.WebMyPham.steps.serenity.CartSteps;
import serenitybdd.Autotest.WebMyPham.steps.serenity.LoginSteps;
import serenitybdd.Autotest.WebMyPham.steps.serenity.OrderSteps;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CancelOrder {

	@Managed(uniqueSession = true, clearCookies = ClearCookiesPolicy.Never)
	public WebDriver webdriver;

	
	@Steps
	public LoginSteps login;
	
	@Steps
	public CartSteps cart;
	
	@Steps
	public Search search;
	
	@Steps
	public OrderSteps order;

	@Test
    public void CancelOrder1_unsucessful_click_cancel() {
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
		order.click_cancel_order();
		order.click_cancel_button();
		order.check_cancel_order_fail();
    }
	
	@Test
	public void CancelOrder2_unsucessful_click_cancel_icon() {
		order.click_cancel_order();
		order.click_cancel_icon();
		order.check_cancel_order_fail();
	}
	
	@Test
	public void CancelOrder3_unsucessful_click_cancel_in_popup() {
		order.click_cancel_order();
		order.enter_reason("Hủy");
		order.click_save_button();
//		order.click_save_button();
		Util.pause(3000);
//		WebDriverWait wait = new WebDriverWait(webdriver, 10);
//	    wait.until(ExpectedConditions.alertIsPresent());
		order.click_cancel_popup();
//		Util.pause(2000);
		order.click_cancel_icon();
//		Util.pause(2000);
//		order.check_cancel_order_fail();
	}
	
	@Test
	public void CancelOrder4_sucessful() {
//		webdriver.navigate().refresh();
		order.click_cancel_order();
		order.enter_reason("Hủy");
		order.click_save_button();
		order.click_save_button();
		Util.pause(10000);
//		WebDriverWait wait = new WebDriverWait(webdriver, 5);
//	    wait.until(ExpectedConditions.alertIsPresent());
		order.click_OK_popup();
		order.check_cancel_order_success();
	}
	
	
	private void enter_shipping_infomation() {
		order.enter_name("Test");
		order.enter_email("test@gmail.com");
		order.enter_phone("0123456789");
		order.enter_address("abc");
		order.choose_payment_method("Thanh toán khi nhận hàng");
		order.enter_note("Ghi chú");
		order.click_order_button();
	}

}