package com.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

	private WebDriver driver;
	
	private By accountssections=By.cssSelector("div[id='center_column'] span");
	
	private By accountpageHeading=By.cssSelector("h1[class='page-heading']");
	
	
	
	public AccountsPage(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	public int getAccountSectionsCount() {
		
		return driver.findElements(accountssections).size();
		
	}
	public List<String> getAccountsSectionsList() {
		
		List<String>accountList=new ArrayList<>();
		List<WebElement>accountsHeaderList=driver.findElements(accountssections);
		
		for(WebElement e:accountsHeaderList) {
			
			String text=e.getText();
			System.out.println(text);
			accountList.add(text);
			
		
		}
		return accountList;
	}
	
	public String getAccoutsPageTitle() {
		return driver.getTitle();
	}
	public String getAccountpageHeading() {
		
		return driver.findElement(accountpageHeading).getText();
		
	}
}
