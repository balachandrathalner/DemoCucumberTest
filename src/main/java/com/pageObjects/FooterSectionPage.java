package com.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.util.SeleniumUtiles;

public class FooterSectionPage {

	public  WebDriver driver;
	
	SeleniumUtiles u;
	
	private By informationSections=By.xpath("//section[@id='block_various_links_footer']//li/a");
	
	private By myAccountSections=By.xpath("//ul[@class='bullet']//li/a");
	
	private By storeInformation=By.xpath("//section[@id='block_contact_infos']//h4"); 
	
	private By Tot_storeInformation=By.xpath("(//ul[@class='toggle-footer'])[2]");
	
	private By followUs=By.id("social_block");
	
	private By followusLinks=By.xpath("//section[@id='social_block']//li/a");
	
	private By Footerlinks=By.xpath("//section[contains(@class,'footer-block')]//a");
	
	
	
	
	
	
	
	//section[contains(@class,'footer-block')]
	
	
	
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

	public List<String> getActualMyAccountSectionList() {
		
		u=new SeleniumUtiles(driver);
		return u.getActualList(myAccountSections);
		
		
	}
	
	
	public int getMyAccountSectionCount() {
		
		int InformationSectionCount=driver.findElements(myAccountSections).size();
		
		return InformationSectionCount;
	}
	
	public String getStoreInformationText() {
		
		u=new SeleniumUtiles(driver);
		return u.getText(storeInformation);
	
	}
	
	public boolean isgetStoreInformationDisplay() {

		
		System.out.println(u.getText(Tot_storeInformation));
		
		return u.verifyElementDisplayed(Tot_storeInformation);
		
		
	}

public String getfollowUpLinkText() {
		
		u=new SeleniumUtiles(driver);
		return u.getText(followUs);
	
	}
	
public boolean isFolloUsLinkBrokenOrNot() {
	
	
	u=new SeleniumUtiles(driver);
	return u.getBrockenLinks(followusLinks);
	
}

public int getCountFollowusLinks() {
	
	u=new SeleniumUtiles(driver);
	 return u.getActualListcount(followusLinks);
}


private Object getActualListcount(By followusLinks2) {
	// TODO Auto-generated method stub
	return null;
}
public boolean isAllfooterLinksBrocken() {
	
	
	u=new SeleniumUtiles(driver);
	return u.getBrockenLinks(Footerlinks);
	
}
	
public void waitForVisibilityOfElement() {
	

	u.waitForVisibilityOfElement(driver, followUs);
	
	
	
}

}
