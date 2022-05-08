package serenitybdd.Autotest.WebMyPham.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.ClearCookiesPolicy;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.junit.annotations.Qualifier;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import serenitybdd.Autotest.WebMyPham.common.Util;
import serenitybdd.Autotest.WebMyPham.steps.serenity.AdminSteps;
import serenitybdd.Autotest.WebMyPham.steps.serenity.LoginSteps;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Admin {

	@Managed(uniqueSession = true, clearCookies = ClearCookiesPolicy.Never)
	public WebDriver webdriver;

	String testcase;
	
	static String productName;
	
	@Qualifier
	public String qualifier() {
		return this.testcase;
	}

	@Steps
	public LoginSteps login;
	
	@Steps
	public AdminSteps admin;

	@Test
    public void A1_Add_product() {
		testcase = "Thêm mới sản phẩm";
		productName ="Test Automation "+Util.getDateTimeNow();
		EnvironmentVariables variable = SystemEnvironmentVariables.createEnvironmentVariables();
		String username = variable.getProperty("user.admin");
		String password = variable.getProperty("pass.admin");
		login.login(username, password);
		admin.openPage();
		admin.click_add_product_button();
		admin.enter_product_name(productName);
		admin.select_product_type("Trang điểm");
		String filePath = System.getProperty("user.dir")+"\\data\\image.jpg";
		admin.upload_image(filePath);
		admin.enter_description("Test Automation");
		admin.enter_price("200000");
		admin.enter_percent_discount("10");
		admin.choose_product_rating("Sản phẩm mới");
		admin.choose_status("Hiển thị");
		admin.click_add_button();
		searchProduct(productName);
		admin.check_add_product_success();
    }
	
	@Test
	public void A2_Edit_product() {
		admin.click_edit_button();
		productName = "Edit "+productName;
		admin.enter_product_name(productName);
		admin.select_product_type("Trang điểm");
		admin.enter_description("Test Automation");
		admin.enter_price("300000");
		admin.enter_percent_discount("5");
		admin.choose_product_rating("Sản phẩm bán chạy");
		admin.choose_status("Không hiển thị");
		admin.click_update_button();
		searchProduct(productName);
		admin.check_add_product_success();
	}
	
	@Test
	public void A3_Delete_product() {
		admin.click_delete_button();
		searchProduct(productName);
		admin.check_delete_success();
	}

	private void searchProduct(String name) {
		admin.enter_search(name);
		
	}
	
}