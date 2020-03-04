package com.stepdefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.base.Base;
import com.pages.BookHotel;
import com.pages.ConfirmationPage;
import com.pages.LoginPage;
import com.pages.SearchHotel;
import com.pages.SelectHotel;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class StepDefiniton extends Base {
	WebDriver driver;
	LoginPage page;
	SearchHotel hotel;
	SelectHotel select;
	BookHotel book;
	ConfirmationPage confirm;

	@Given("User is on the Adactin homepage")
	public void user_is_on_the_Adactin_homepage() {
		driver = getDriver();
		loadURL("https://adactin.com/HotelApp/");
		screenShot();
	}

	@When("User enters his details")
	public void user_enters_his_details(io.cucumber.datatable.DataTable data) {
		page = new LoginPage();
		List<Map<String, String>> emp = data.asMaps();
		String s1 = emp.get(0).get("userName");
		WebElement txtUser = page.getTxtUser();
		fill(txtUser, s1);
		Assert.assertEquals("Verify Username", s1,getAttValue(txtUser));
		String s2 = emp.get(0).get("password");
		WebElement txtPass = page.getTxtPass();
		fill(txtPass, s2);
		Assert.assertEquals("Verify Username", s2,getAttValue(txtPass));
	}

	@When("User clicks the login button")
	public void user_clicks_the_login_button() {
		WebElement btn = page.getBtnlog();
		btnClick(btn);
		screenShot();
	}

	@When("User should verify the message")
	public void user_should_verify_the_message() {
		System.out.println("Mesage Verifyied With The User");
		//Assert.assertEquals("Verify Title", getTitle().contains("Welcome to AdactIn Group of Hotels"));
	}

	@When("User should search hotel")
	public void user_should_search_hotel(io.cucumber.datatable.DataTable data) {
		hotel = new SearchHotel();
		select = new SelectHotel();
		List<Map<String, String>> emp = data.asMaps();
		String s3 = emp.get(0).get("location");
		WebElement l = hotel.getLoc();
		fill(l, s3);
		String s4 = emp.get(0).get("Hotels");
		WebElement h = hotel.getHotels();
		fill(h, s4);
		String s5 = emp.get(0).get("roomtypes");
		WebElement r = hotel.getRoomType();
		fill(r, s5);
		String s6 = emp.get(0).get("numberofrooms");
		WebElement n = hotel.getRoomNos();
		fill(n, s6);
		String s7 = emp.get(0).get("adultsperroom");
		WebElement a = hotel.getAdult();
		fill(a, s7);
		String s8 = emp.get(0).get("childrenperroom");
		WebElement ch = hotel.getChild();
		fill(ch, s8);
		WebElement btn = hotel.getSubmit();
		btnClick(btn);
		screenShot();
		WebElement btn1 = select.getRadio();
		btnClick(btn1);
		WebElement btnCon = select.getCnt();
		btnClick(btnCon);
		screenShot();

	}

	@When("User enters payment")
	public void user_enters_payment(io.cucumber.datatable.DataTable data) {
		book = new BookHotel();
		List<Map<String, String>> emp = data.asMaps();
		String s9 = emp.get(0).get("firstname");
		WebElement f = book.getFirstName();
		fill(f, s9);
		String s10 = emp.get(0).get("lastname");
		WebElement l = book.getLastName();
		fill(l, s10);
		String s11 = emp.get(0).get("billingaddress");
		WebElement a = book.getAddress();
		fill(a, s11);
		String s12 = emp.get(0).get("creditcardnumber");
		WebElement c = book.getCreditnum();
		fill(c, s12);
		String s13 = emp.get(0).get("creditcardtype");
		WebElement n = book.getCreditTyp();
		fill(n, s13);
		String s14 = emp.get(0).get("expirymonth");
		WebElement m = book.getExpMonth();
		fill(m, s14);
		String s15 = emp.get(0).get("expiryyear");
		WebElement y = book.getExpYear();
		fill(y, s15);
		String s16 = emp.get(0).get("cvvnumber");
		WebElement v = book.getCvv();
		v.sendKeys("4568");
	}

	@When("User gets orderid")
	public void user_gets_orderid() throws AWTException {
		book = new BookHotel();
		confirm = new ConfirmationPage();
		WebElement btnCon = book.getBookNow();
		btnClick(btnCon);
		screenShot();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement order = confirm.getOrdNo();
		String txt = order.getAttribute("value");
		System.out.println(txt);
		WebElement it = confirm.getMyIt();
		btnClick(it);
		screenShot();
		WebElement txtOrder = driver.findElement(By.xpath("//input[@value='" + txt + "']/parent::td/preceding-sibling::td"));
		btnClick(txtOrder);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement ord = confirm.getCancel();
		btnClick(ord);
		Alert a= driver.switchTo().alert();
		a.accept();
			}

	@Then("User has canceled the booking")
	public void user_has_canceled_the_booking() throws AWTException {
		System.out.println("Booking Cancelled");
	
	}

}
