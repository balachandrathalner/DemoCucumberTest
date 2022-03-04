package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;
	
	
	//http://demowebshop.tricentis.com/
	
	@FindBy(id = "email")
	WebElement email;
	
	private By password=By.id("passwd");
	
	//private By forgotPwLink=By.linkText("Forgot your password?");
	
	@FindBy(linkText = "Forgot your password?")
	private WebElement fw;
	
	private By signinButton=By.id("SubmitLogin");
	
	
	private By contactUs=By.xpath("//a[@title='Contact us']");
	
	private By createAccountEmailId=By.id("email_create");
	
	private By SubmitCreate=By.name("SubmitCreate");
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
	
	}
	
	
	public String getLoginPageTitle() {
		
		return driver.getTitle();
	}
	
	public boolean isForgotPWdLinkExist() {
	
	// return driver.findElement(forgotPwLink).isDisplayed();
		
		return fw.isDisplayed();
	
	}
	
	public void enterUsername(String un) {
		
		email.sendKeys(un);
	}
	
	public void enterPw(String pw) {
		
		driver.findElement(password).sendKeys(pw);
	}
	
	public void clickOnSignIn() {
		driver.findElement(signinButton).click();
	}
	
	
	
	public AccountsPage doLogin(String un,String pw) {
		
		System.out.println("Login with username :"+un+ "and password :" +pw);
			email.sendKeys(un);
			driver.findElement(password).sendKeys(pw);
			driver.findElement(signinButton).click();
			return new AccountsPage(driver);
			
			
		
		
	}
	
	public void getContactUs() {
		
		driver.findElement(contactUs).click();
	}
	
	
	public void sendCreateAccountEmailId(String email) {
		
		 driver.findElement(createAccountEmailId).sendKeys(email);
		
		
	}
	public CreateAccountPage clickSubmitCreateAccountButton() {
		//driver.findElement(SubmitCreate).click();
		
		driver.findElement(SubmitCreate).click();
		return new CreateAccountPage(driver);
	}
}
