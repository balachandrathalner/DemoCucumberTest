package com.qa.util;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class SeleniumUtiles {

private WebDriver driver;

public SeleniumUtiles(WebDriver driver) {

	this.driver=driver;

}

	public List<String> getActualList(By element){
		
		List<String>actualList=new ArrayList<>();
		List<WebElement>li=driver.findElements(element);
		
		for(WebElement e:li) {
			
			String text=e.getText();
			System.out.println(text);
			actualList.add(text);
			
		
		}
		return actualList;
	
	}
	
	
}
