package serenitybdd.Autotest.WebMyPham.pages;

import net.thucydides.core.annotations.DefaultUrl;

import java.util.List;


import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("")
public class SearchPage extends PageObject {

	@FindBy(xpath="//input[@name='search']")
    private WebElementFacade inputSearch;

	public void enter_search_texbox(String product) {
		inputSearch.type(product);
		
	}

	@FindBy(xpath="//input[@name='search']/ancestor::form//button[@type='submit']")
    private WebElementFacade buttonSearch;
	public void click_search_button() {
		buttonSearch.click();
		
	}

	@FindBy(xpath = "//div[@id='allproduct']//div[@class='simpleCart_shelfItem item_product_main']")
	private List<WebElementFacade> listProduct;
	public boolean check_search_success() {		
		return listProduct.size()==1;
	}

	
	

    
}