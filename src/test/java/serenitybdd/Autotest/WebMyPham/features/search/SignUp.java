package serenitybdd.Autotest.WebMyPham.features.search;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.ClearCookiesPolicy;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import serenitybdd.Autotest.WebMyPham.common.Util;
import serenitybdd.Autotest.WebMyPham.steps.serenity.HomeSteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("data/signup.csv")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SignUp {

	@Managed(uniqueSession = true, clearCookies = ClearCookiesPolicy.Never)
	public WebDriver webdriver;

	String testcase, name, email, phone, password, result;

	@Qualifier
	public String qualifier() {
		return this.testcase;
	}

	@Steps
	public HomeSteps home;

	@Test
    public void SignUp_testcase() {
		if(!email.equalsIgnoreCase("") && !testcase.equalsIgnoreCase("Đăng ký không thành công do nhập không đúng định dạng email"))
			email = email+ Util.getDateTimeNow()+"@gmail.com";
    	home.openPage();
        home.enterName(name);
        home.enterEmail(email);
        home.enterPhone(phone);
        home.enterPassword(password);
        home.clickSignUpButton();
        if(name.equalsIgnoreCase("") || email.equalsIgnoreCase("") || phone.equalsIgnoreCase("") || password.equalsIgnoreCase("")){
        	home.check_signup_fail(result);
        }
        else if(!email.equalsIgnoreCase("") && !email.contains("@")) {
        	home.check_email_fail(result);
        }
        else if(result.equalsIgnoreCase("Please match the requested format.")) {
        	home.check_phone_fail(result);
        }
        else {
        	home.check_signup_sucsess(result);
        }
    }

}