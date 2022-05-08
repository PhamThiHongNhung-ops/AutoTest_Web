package serenitybdd.Autotest.WebMyPham.features.search;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
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
import serenitybdd.Autotest.WebMyPham.steps.serenity.ContactSteps;
import serenitybdd.Autotest.WebMyPham.steps.serenity.LoginSteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("data/contact.csv")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Contact {

	@Managed(uniqueSession = true, clearCookies = ClearCookiesPolicy.Never)
	public WebDriver webdriver;

	String testcase, name, email, content, result;

	@Qualifier
	public String qualifier() {
		return this.testcase;
	}

	@Steps
	public LoginSteps login;

	@Steps
	public ContactSteps contact;

	@Test
	public void ContactTestcase() {
		EnvironmentVariables variable = SystemEnvironmentVariables.createEnvironmentVariables();
		String username = variable.getProperty("project.username");
		String password = variable.getProperty("project.password");
		if (testcase.equals("Gửi liên hệ thành công khi đăng nhập")) {
			login.login(username, password);
		}
		contact.open_page();
		contact.enter_name(name);
		contact.enter_email(email);
		contact.enter_content(content);
		contact.click_submit_button();
		if(result.equals("success")) {
			contact.check_send_contact_success();
		} else if(name.equalsIgnoreCase("")) {
			contact.check_name_fail(result);
		} else if(email.equalsIgnoreCase("")) {
			contact.check_email_fail(result);
		}else if(content.equalsIgnoreCase("")) {
			contact.check_content_fail(result);
		}
	}

}