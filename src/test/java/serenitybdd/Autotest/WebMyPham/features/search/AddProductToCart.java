package serenitybdd.Autotest.WebMyPham.features.search;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.ClearCookiesPolicy;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import serenitybdd.Autotest.WebMyPham.common.Util;
import serenitybdd.Autotest.WebMyPham.steps.serenity.CartSteps;
import serenitybdd.Autotest.WebMyPham.steps.serenity.LoginSteps;
import serenitybdd.Autotest.WebMyPham.steps.serenity.SearchSteps;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddProductToCart {

	@Managed(uniqueSession = true, clearCookies = ClearCookiesPolicy.Never)
	public WebDriver webdriver;



	@Steps
	public LoginSteps login;
	
	@Steps
	public CartSteps cart;
	@Steps
	public Search search;

	@Test
    public void AddCart() {
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
		cart.check_add_product_to_cart_success(productName);
    }

}