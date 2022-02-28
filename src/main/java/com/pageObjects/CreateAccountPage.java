package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage {

	private WebDriver driver;
	
	By pageSubTitle=By.xpath("//form[@id='account-creation_form']/div[1]/h3");
	
	By firstname=By.id("customer_firstname");
	
	By lastname=By.id("customer_lastname");
	
	By password=By.id("passwd");
	
	By days=By.id("days");
	
	By months=By.id("months");
	
	By years=By.id("years");
	
	By company=By.id("company");
	
	By address1=By.id("address1");
	
	By address2=By.id("address2");
	
	By city=By.id("city");
	
	By state=By.id("id_state");
	
	By zip=By.id("postcode");
	
	By country=By.id("id_country");
	
	By info=By.id("other");
	
	By homePhone=By.id("phone");
	
	By mobPhone=By.id("phone_mobile");
	
	By alias=By.id("alias");
	
	By register=By.id("submitAccount");
	
	By errorMsg=By.xpath("//div[@class='alert alert-danger']");
	public CreateAccountPage(WebDriver driver) {
	
		this.driver=driver;
	
	}
	
	
	public String getPageSubTitle() {
		return driver.findElement(pageSubTitle).getText();
	}
	public void sendPersonalInformations(String firstnam,String lastnam,String pw,String day,String mont,String year,String companyy,String adrss1,String Addrss2,String cityy,String stat,String zp,String cntry,String ifo,String Hphone,String Mphone,String aliass) {
		
		Select selDay=new Select(driver.findElement(days));
		
		Select selMonth=new Select(driver.findElement(months));
		
		Select selYear=new Select(driver.findElement(years));
		driver.findElement(firstname).sendKeys(firstnam);
		
		driver.findElement(lastname).sendKeys(lastnam);
		
		driver.findElement(password).sendKeys(pw);
		
		selDay.selectByValue(day);
		
		selMonth.selectByValue(mont);
		
		selYear.selectByValue(year);
		
		driver.findElement(company).sendKeys(companyy);
		
		driver.findElement(address1).sendKeys(adrss1);
		
		driver.findElement(address2).sendKeys(Addrss2);
		
		driver.findElement(city).sendKeys(cityy);
		
		Select selState=new Select(driver.findElement(state));
		
		selState.selectByVisibleText(stat);
		
		driver.findElement(zip).sendKeys(zp);
		
		Select selCountry=new Select(driver.findElement(country));
		
		selCountry.selectByVisibleText(cntry);
		
		driver.findElement(info).sendKeys(ifo);
		
		driver.findElement(homePhone).sendKeys(Hphone);
		
		driver.findElement(mobPhone).sendKeys(Mphone);
		
		driver.findElement(alias).sendKeys(aliass);
		
		
		
		
		
	}
	
	public void clickRegisterButton() {
		driver.findElement(register).click();;
	}
	
	public boolean isErrorMsgDisplay() {
		
		return driver.findElement(errorMsg).isDisplayed();
	}

	public String getErrorMsg() {
		
		return driver.findElement(errorMsg).getText();
	}
}
