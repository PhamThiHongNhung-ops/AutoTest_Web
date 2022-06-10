package serenitybdd.Autotest.WebMyPham.pages;

import net.thucydides.core.annotations.DefaultUrl;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import serenitybdd.Autotest.WebMyPham.common.Util;

@DefaultUrl("/thanh-toan")
public class OrderPage extends PageObject {

	@FindBy(id="checkout_full_name")
    private WebElementFacade inputName;

	public void enter_name(String name) {
		inputName.type(name);
		
	}

	@FindBy(id="checkout_email")
    private WebElementFacade inputEmail;
	public void enter_email(String email) {
		inputEmail.type(email);
		
	}

	@FindBy(id="checkout_phone")
    private WebElementFacade inputPhone;
	public void enter_phone(String phone) {
		inputPhone.type(phone);
		
	}

	@FindBy(id="checkout_address")
    private WebElementFacade inputAddress;
	public void enter_address(String address) {
		inputAddress.type(address);
		
	}

	@FindBy(id="checkout_payment")
    private WebElementFacade inputMethod;
	public void choose_payment_method(String method) {
		inputMethod.selectByValue(method);
		
	}

	@FindBy(id="checkout_note")
    private WebElementFacade inputNote;
	public void enter_note(String note) {
		inputNote.type(note);
		
	}

	@FindBy(xpath="//button[@title='Đặt hàng']")
    private WebElementFacade buttonOrder;
	public void click_order_button() {
		buttonOrder.click();
		
	}
	@FindBy(xpath="//p[contains(text(),'Đặt hàng thành công!')]")
    private WebElementFacade elementOrderSucess;
	public boolean check_order_sucess() {
		return elementOrderSucess.isDisplayed();
		
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
	
	public boolean check_phone_fail(String result) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
		String s =(String) jsExecutor.executeScript("return arguments[0].validationMessage;", inputPhone);
		System.out.println(s);
		return s.equalsIgnoreCase(result);
		
	}
	
	public boolean check_address_fail(String result) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
		String s =(String) jsExecutor.executeScript("return arguments[0].validationMessage;", inputAddress);
		System.out.println(s);
		return s.equalsIgnoreCase(result);
		
	}

	@FindBy(xpath="//a[text()='Hủy đơn hàng']")
    private WebElementFacade elementCancelOrder;
	public void click_cancel_order() {
		elementCancelOrder.click();
		
	}
	
	@FindBy(xpath="//button[text()='Hủy']")
    private WebElementFacade buttonCancel;
	public void click_cancel_button() {
		buttonCancel.click();
		
	}

	@FindBy(xpath="//span[text()='×']")
    private WebElementFacade iconCancel;
	public void click_cancel_icon() {
		iconCancel.click();
		
	}

	@FindBy(id="reason_destroy")
    private WebElementFacade inputReason;
	public void enter_reason(String string) {
		inputReason.type(string);
		
	}

	@FindBy(xpath="//button[contains(text(),'Lưu')]")
    private WebElementFacade buttonSave;
	public void click_save_button() {
		buttonSave.click();
	}
	


	
	public void click_cancel_popup() {
		buttonSave.click();
		getDriver().switchTo().alert().dismiss();
		
	}

	public void click_OK_popup() {
		buttonSave.click();
		getDriver().switchTo().alert().accept();
		
	}

	public boolean check_cancel_order_fail() {
		return elementOrderSucess.isDisplayed();
	}

	@FindBy(xpath = "//p[contains(text(),'Hủy đơn hàng thành công!')]")
	private WebElementFacade cancelOrderSuccess;
	public boolean check_cancel_order_success() {
		return cancelOrderSuccess.isDisplayed();
	}

	
	

    
}