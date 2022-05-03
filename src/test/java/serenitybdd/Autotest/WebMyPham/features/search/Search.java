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

import serenitybdd.Autotest.WebMyPham.steps.serenity.CartSteps;
import serenitybdd.Autotest.WebMyPham.steps.serenity.LoginSteps;
import serenitybdd.Autotest.WebMyPham.steps.serenity.SearchSteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("data/search.csv")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Search {

	@Managed(uniqueSession = true, clearCookies = ClearCookiesPolicy.Never)
	public WebDriver webdriver;

	String testcase,product,result;
	
	@Qualifier
	public String qualifier() {
		return this.testcase;
	}

	@Steps
	public LoginSteps login;
	
	@Steps
	public SearchSteps search;

	@Test
    public void SearchTestcase() {
		EnvironmentVariables variable = SystemEnvironmentVariables.createEnvironmentVariables();
		String username = variable.getProperty("project.username");
		String password = variable.getProperty("project.password");
		login.login(username, password);
		search_product(product);
		search.check_search_success(product);
    }

	public void search_product(String productName) {
		search.enter_search_texbox(productName);
		search.click_search_button();
	}
}