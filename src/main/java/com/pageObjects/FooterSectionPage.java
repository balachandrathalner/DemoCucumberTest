package com.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.util.SeleniumUtiles;

public class FooterSectionPage {

	public  WebDriver driver;
	
	SeleniumUtiles u;
	
	
	private By informationSections=By.xpath("//section[@id='block_various_links_footer']//li/a");
	
	
	
	public FooterSectionPage(WebDriver driver) {
	
	this.driver=driver;
	
	}
	
	
	public List<String> getActualInformationSectionList() {
		
		u=new SeleniumUtiles(driver);
		return u.getActualList(informationSections);
		
		
	}
	
	public int getInformationSectionCount() {
		
		int InformationSectionCount=driver.findElements(informationSections).size();
		
		return InformationSectionCount;
	}
	
	
	
}
