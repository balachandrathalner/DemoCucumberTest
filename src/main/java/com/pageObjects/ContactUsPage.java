package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class ContactUsPage {

	
	private WebDriver driver;
	
	
	
	By subjectHeading=By.id("id_contact");
	
	By email=By.id("email");
	
	By orderRef=By.id("id_order");
	
	By message=By.id("message");
	
	By submitMessage=By.id("submitMessage");

	By successMsg=By.xpath("//div[@id='center_column']/p");
	
	

	public ContactUsPage(WebDriver driver) {
	
	this.driver=driver;
	
	//PageFactory.initElements(driver, this);
	}


	public void getValues(String option,String emai,String ref,String msg) throws InterruptedException {
		Select sel=new Select(driver.findElement(subjectHeading));
		
		sel.selectByVisibleText(option);
		
		driver.findElement(email).sendKeys(emai);
		driver.findElement(orderRef).sendKeys(ref);
	
		driver.findElement(message).sendKeys(msg);
		
		Thread.sleep(2000);
		
	}
	
	public void clickSendmessage() {
		driver.findElement(submitMessage).click();;
	}
	
	public String getSuccessMsg() {
		
		return driver.findElement(successMsg).getText();
	}
}
