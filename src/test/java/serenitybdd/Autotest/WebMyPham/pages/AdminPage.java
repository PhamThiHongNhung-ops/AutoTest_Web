package serenitybdd.Autotest.WebMyPham.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.serenitybdd.core.pages.WebElementFacade;

import org.openqa.selenium.Keys;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import serenitybdd.Autotest.WebMyPham.common.Util;

@DefaultUrl("/dashboard")
public class AdminPage extends PageObject {

    @FindBy(xpath="//a[contains(@class,'btnAddNew')]")
    private WebElementFacade buttonAddProduct;

    @FindBy(name="name")
    private WebElementFacade inputProductName;

    
    @FindBy(name="category")
    private WebElementFacade selectProductType;
    
    @FindBy(xpath="//input[@name='image']")
    private WebElementFacade inputImage;
    
    @FindBy(xpath="//body[contains(@class,'cke_editable cke_editable_themed')]")
    private WebElementFacade inputDescription;

    @FindBy(id="price")
    private WebElementFacade inputPrice;
    
    @FindBy(name="rank")
    private WebElementFacade selectProductRating;
    
    @FindBy(name="status")
    private WebElementFacade selectStatus;
    
    @FindBy(xpath="//button[text()='Add']")
    private WebElementFacade buttonAdd;
    
    @FindBy(name="sale")
    private WebElementFacade inputPercentDiscount;
    
    public void click_add_product_button() {
    	buttonAddProduct.click();
		
	}

	public void enter_product_name(String productName) {
		inputProductName.type(productName);
		
	}

	public void select_product_type(String string) {
		selectProductType.selectByVisibleText(string);
		
	}

	public void upload_image(String string) {
		inputImage.sendKeys(string);
		
	}

	public void enter_description(String string) {
		getDriver().switchTo().frame(0);
		inputDescription.type(string);
		getDriver().switchTo().defaultContent();
	}

	public void enter_price(String string) {
		inputPrice.type(string);
		
	}

	public void choose_product_rating(String string) {
		selectProductRating.selectByVisibleText(string);
		
	}

	public void choose_status(String string) {
		selectStatus.selectByVisibleText(string);
		
	}

	public void click_add_button() {
		buttonAdd.click();
		Util.pause(2000);
		
	}

	public void enter_percent_discount(String string) {
		inputPercentDiscount.type(string);
		
	}

	@FindBy(xpath="//input[contains(@type,'search')]")
	private WebElementFacade inputSearch;
	public void enter_search(String name) {
		inputSearch.type(name);
		inputSearch.sendKeys(Keys.ENTER);
		
	}

	@FindBy(xpath="//div[contains(text(),'Showing 1 to 1')]")
	private WebElementFacade elementSuccess;
	public boolean check_add_product_success() {
		return elementSuccess.isPresent();
	}

	@FindBy(xpath="//a[contains(text(),'Cập nhật')]")
	private WebElementFacade buttonEdit;
	public void click_edit_button() {
		buttonEdit.click();
		
	}

	@FindBy(xpath="//form[contains(@action,'product')]//button[contains(text(),'Update')]")
	private WebElementFacade buttonUpdate;
	public void click_update_button() {
//		buttonUpdate.click();
		Util.clickElementFacade(getDriver(), buttonUpdate);
		Util.pause(2000);
		
	}

	@FindBy(name="actiondelete")
	private WebElementFacade buttonDelete;
	public void click_delete_button() {
		buttonDelete.click();
		Util.pause(2000);
		getDriver().switchTo().alert().accept();
		
	}

	@FindBy(xpath="//div[contains(text(),'Showing 0 to 0')]")
	private WebElementFacade elementDeleteSuccess;
	public boolean check_delete_success() {
		return elementDeleteSuccess.isPresent();
		
	}

}