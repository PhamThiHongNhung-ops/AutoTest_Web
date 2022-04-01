package serenitybdd.Autotest.WebMyPham.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("/customer/dang-nhap")
public class LoginPage extends PageObject {


    @FindBy(id="customer_email")
    private WebElementFacade inputEmail;

    
    @FindBy(id="customer_password")
    private WebElementFacade inputPassword;
    
    @FindBy(xpath="//input[@value='Đăng nhập']")
    private WebElementFacade buttonLogin;

    @FindBy(xpath="//a[text()='Đăng xuất']")
    private WebElementFacade buttonLogout;

	public void enterEmail(String email) {
		inputEmail.type(email);
		
	}

	public void enterPassword(String password) {
		inputPassword.type(password);
		
	}


	public boolean check_login_sucsess(String result) {
		return buttonLogout.isDisplayed();
		
	}

	
	public boolean check_login_fail(String result) {
		return getDriver().findElement(By.xpath("//li[text()='"+result+"']")).isDisplayed();
	}

	
	public boolean check_email_fail(String result) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
		String s =(String) jsExecutor.executeScript("return arguments[0].validationMessage;", inputEmail);
		return s.equalsIgnoreCase(result);
	}


	public void clickLoginButton() {
		buttonLogin.click();
		
	}


}