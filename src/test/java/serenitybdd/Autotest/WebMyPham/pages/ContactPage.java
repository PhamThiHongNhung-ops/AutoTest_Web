package serenitybdd.Autotest.WebMyPham.pages;

import net.thucydides.core.annotations.DefaultUrl;


import net.serenitybdd.core.pages.WebElementFacade;

import org.openqa.selenium.JavascriptExecutor;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("/lien-he")
public class ContactPage extends PageObject {

	@FindBy(name="name")
    private WebElementFacade inputName;
	
	@FindBy(name="email")
    private WebElementFacade inputEmail;
	
	@FindBy(name="content")
    private WebElementFacade inputContent;
	
	@FindBy(xpath="//button[@type='submit' and contains(text(),'Gửi ngay')]")
    private WebElementFacade buttonSubmit;

	public void enter_name(String name) {
		inputName.type(name);
		
	}

	public void enter_email(String email) {
		inputEmail.type(email);
		
	}

	public void enter_content(String content) {
		inputContent.type(content);
		
	}

	public void click_submit_button() {
		buttonSubmit.click();
		
	}

	@FindBy(xpath="//div[@class='success']")
    private WebElementFacade sendContectSuccess;
	public boolean check_send_contact_success() {
		return sendContectSuccess.isDisplayed();
	}

	public boolean check_send_contact_fail(String result) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
		String s =(String) jsExecutor.executeScript("return arguments[0].validationMessage;", result);
		return s.equalsIgnoreCase(result);
	}

	public boolean check_name_fail(String result) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
		String s =(String) jsExecutor.executeScript("return arguments[0].validationMessage;", inputName);
		System.out.println(s);
		return s.equalsIgnoreCase(result);
	}

	public boolean check_email_fail(String result) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
		String s =(String) jsExecutor.executeScript("return arguments[0].validationMessage;", inputEmail);
		System.out.println(s);
		return s.equalsIgnoreCase(result);
	}

	public boolean check_content_fail(String result) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
		String s =(String) jsExecutor.executeScript("return arguments[0].validationMessage;", inputContent);
		System.out.println(s);
		return s.equalsIgnoreCase(result);
	}



	

	
	

    
}