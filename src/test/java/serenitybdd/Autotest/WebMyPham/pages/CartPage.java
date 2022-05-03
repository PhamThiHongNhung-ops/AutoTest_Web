package serenitybdd.Autotest.WebMyPham.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import serenitybdd.Autotest.WebMyPham.common.Util;

@DefaultUrl("/gio-hang")
public class CartPage extends PageObject {

	@FindBy(xpath="//button[contains(@class,'btn-cart item_add')]")
    private WebElementFacade byNowButton;

	
	public void click_product() {
		WebElement element = getDriver().findElement(By.xpath("//div[@id='allproduct']//div[@class='simpleCart_shelfItem item_product_main']//h3"));
//		Util.clickUsingJavascript(getDriver(), element);
		element.click();
	}

	public void click_MuaNgay_button() {
		byNowButton.click();
		Util.delay(2000);
		
	}

	public boolean check_add_product_to_cart_success(String s) {
		
		return getDriver().findElement(By.xpath("//div[contains(@class,'simpleCart_items')]//*[contains(text(),'"+s+"')]")).isDisplayed();
		
	}

    
}