package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;

public class ConfirmationPage extends Base {
	public ConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="order_no")
	private WebElement ordNo;
	@FindBy(id="my_itinerary")
	private WebElement myIt;
	@FindBy(xpath="//input[@value='Cancel Selected']")
	private WebElement cancel;
	public WebElement getOrdNo() {
		return ordNo;
	}
	public WebElement getMyIt() {
		return myIt;
	}
	public WebElement getCancel() {
		return cancel;
	}
}
