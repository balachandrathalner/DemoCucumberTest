package com.qa.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class SeleniumUtiles {

	
    public static final int TIME_OUT_LOAD = 30;

    SoftAssert aa =new SoftAssert();
    
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
	
	public int getActualListcount(By element){
		
		List<WebElement>count=driver.findElements(element);
		
		return count.size();
	
	}
	
	
	public boolean getBrockenLinks(By element) {
		
		boolean flag=true;
		String url = "";
		HttpURLConnection huc = null;
		int respCode = 200;

		//aa=new SoftAssert();
		String homePage="http://automationpractice.com";
			
			
		List<WebElement> links = driver.findElements(element);

		Iterator<WebElement> it = links.iterator();

		while(it.hasNext()){

		url = it.next().getAttribute("href");

		if(url.contains("mailto")) {
			
			System.out.println(url + " belongs to Email.so skiping*");
			continue;
		
		}
		System.out.println(url);

		
		if(url == null || url.isEmpty()){
			System.out.println("URL is either not configured for anchor tag or it is empty");
			continue;
			}
		
		if(!url.startsWith(homePage)){
			System.out.println("URL belongs to another domain");//, skipping it.
			//continue;
			}
		
		try {
			huc = (HttpURLConnection)(new URL(url).openConnection());

			huc.setRequestMethod("HEAD");

			huc.connect();

			respCode = huc.getResponseCode();

			
			
			if(respCode >= 400){
			System.out.println(url+" is a broken link and response code is :"+respCode);
		
			flag=false;
			
			aa.assertTrue(false,"Broken link");
			}
			else{
			System.out.println(url+" is a valid link and response code is :"+respCode);
			
			aa.assertTrue(true);
			
			}

			} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}

		System.out.println("====================================");
				
		}
		

		System.out.println("**************************");
		
		aa.assertAll();
		
		
		
		return flag;
		
	}
	
	public void getImplicitWait_VisibilityOfElement() {
		
			
		
	}
	
	
	
	


    public String getText(By selector) {
        try {
            return this.driver.findElement(selector).getText().trim();
        } catch (Exception e) {
          //  this.driver.log("caught iException", Level.FINE);
            e.printStackTrace();
        }
        return null;
    }
    public void moveToElementAndClickUsingAction(By selector){
        waitForVisibilityOfElement(this.driver,selector);
        try {
            Actions action = new Actions(this.driver);
            action.moveToElement(findElement(selector));
            action.click().build().perform();
        }catch (Exception e){
            System.out.println("met with exception" + e);
            e.printStackTrace();
        }
    }
    public void moveToElementUsingAction(By selector){
        waitForVisibilityOfElement(this.driver,selector);
        try {
            Actions action = new Actions(this.driver);
            action.moveToElement(findElement(selector));
            action.build().perform();
        }catch (Exception e){
            System.out.println("met with exception" + e);
            e.printStackTrace();
        }
    }

    public By getByFromElement(WebElement element) {
        By by = null;
        //[[ChromeDriver: chrome on XP (d85e7e220b2ec51b7faf42210816285e)] -> xpath: //input[@title='Search']]
        String[] pathVariables = (element.toString().split("->")[1].replaceFirst("(?s)(.*)\\]", "$1" + "")).split(":");

        String selector = pathVariables[0].trim();
        String value = pathVariables[1].trim();

        switch (selector) {
            case "id":
                by = By.id(value);
                break;
            case "className":
                by = By.className(value);
                break;
            case "tagName":
                by = By.tagName(value);
                break;
            case "xpath":
                by = By.xpath(value);
                break;
            case "cssSelector":
                by = By.cssSelector(value);
                break;
            case "linkText":
                by = By.linkText(value);
                break;
            case "name":
                by = By.name(value);
                break;
            case "partialLinkText":
                by = By.partialLinkText(value);
                break;
            default:
                throw new IllegalStateException("locator : " + selector + " not found!!!");
        }
        return by;
    }
/*
    public void waitForIFrameAndSwitchToIT(WebDriver driver, By element) {
        try {
            driver.switchTo().defaultContent();
            WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_LOAD);
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
        } catch (StaleElementReferenceException var4) {
            this.driver.getLogWriter().log("caught StaleElementReferenceException in enterText method", Level.FINE);
        } catch (InvalidElementStateException var5) {
            this.driver.getLogWriter().log("caught invalidElementStateException in enterText method", Level.FINE);
        }
    }

    public void windowsAlertAccept(){
        this.driver.switchTo().alert().accept();
    }
    public void waitForElementToBeDisplayed(WebDriver driver, By element) {
        List<WebElement> ele = driver.findElements(element);
        if (ele.size() > 0) {
            int itCount = this.getMaxAttempts();
            while (itCount > 0) {
                try {
                    FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                            .withTimeout(Duration.ofSeconds(getBrowser().getTimeout()))
                            .ignoring(org.openqa.selenium.NoSuchElementException.class)
                            .ignoring(StaleElementReferenceException.class)
                            .pollingEvery(Duration.ofMillis(1000));
                    wait.until(ExpectedConditions.visibilityOfElementLocated(element));
                    wait.until(ExpectedConditions.elementToBeClickable(element));
                    this.getBrowser().sleep(this.getBrowser().getTimeout() / 10);
                    break;
                } catch (Exception e) {
                    this.getBrowser().getLogWriter().log("Caught Exception" + Thread.currentThread().getStackTrace(), Level.FINE);
                    e.printStackTrace();
                    itCount--;
                }
            }
        }
    }
*/
    public void waitForInvisibilityOfElement(WebDriver driver, By element) {
        try {
            new WebDriverWait(driver, 10).pollingEvery(Duration.ofSeconds(1))
                    .until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOfElementLocated(element)));
        } catch (Exception e) {
            System.out.println("met with exception" + e);
            e.printStackTrace();
        }
    }

    @SuppressWarnings("deprecation")
	public void waitForVisibilityOfElement(WebDriver driver, By element) {
        try {
          
        	new WebDriverWait(driver, 15).pollingEvery(Duration.ofMillis(500))
                 .until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(element)));
            
        	
        	new WebDriverWait(driver, 20).pollingEvery(Duration.ofMillis(300))
                    .until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(element)));
        } catch (Exception e) {
            System.out.println("met with exception" + e);
            e.printStackTrace();
        }
    }

    public void waitForElementToBeClickable(WebDriver driver, By element) {
        try {
            new WebDriverWait(driver, 10).pollingEvery(Duration.ofSeconds(1))
                    .until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(element)));
            new WebDriverWait(driver, 10).pollingEvery(Duration.ofSeconds(1))
                    .until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
        } catch (Exception e) {
            System.out.println("met with exception" + e);
            e.printStackTrace();
        }
    }
/*
    public void waitForStalenessOfElement(WebDriver driver, By element) {
        List<WebElement> ele = driver.findElements(element);
        if (ele.size() > 0) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, 10, 500);
                wait.until(ExpectedConditions.stalenessOf(findElement(element)));
            } catch (StaleElementReferenceException var4) {
                this.getBrowser().getLogWriter().log("caught StaleElementReferenceException in enterText method", Level.FINE);
            } catch (InvalidElementStateException var5) {
                this.getBrowser().getLogWriter().log("caught invalidElementStateException in enterText method", Level.FINE);
            } catch (NoSuchElementException e) {
                System.out.println("no stale eleme");
            } catch (TimeoutException e) {
                System.out.println("no stale eleme");
            }
        }
    }
    */
    public WebElement findElement(By element) {
        return this.driver.findElement(element);
    }
/*
    public void sendKeys(WebDriver driver, By element, String text) {
        for (byte iterationCounter = 0; iterationCounter < this.getBrowser().getMaxAttempts(); this.getBrowser().sleep(this.getBrowser().getTimeout() / 10)) {
            try {
                findElement(element).sendKeys(text);
                break;
            } catch (StaleElementReferenceException var4) {
                this.getBrowser().getLogWriter().log("caught StaleElementReferenceException in enterText method", Level.FINE);
            } catch (InvalidElementStateException var5) {
                this.getBrowser().getLogWriter().log("caught invalidElementStateException in enterText method", Level.FINE);
            }
        }
    }
*/
    public List<WebElement> findElements(WebDriver driver, By element) {
        return driver.findElements(element);
    }

  /*
    public void clickElement(By element) {
        for (byte iterationCounter = 0; iterationCounter < this.getBrowser().getMaxAttempts(); this.getBrowser().sleep(this.getBrowser().getTimeout() / 10)) {
            try {
                waitForElementToBeDisplayed(this.driver, element);
                waitForElementToBeClickable(element);
                JavascriptExecutor executor = (JavascriptExecutor) this.getBrowser().getDriver();
                executor.executeScript("arguments[0].click();", this.getBrowser().getDriver().findElement(element));
               // findElement(element).click();
                break;
            } catch (StaleElementReferenceException var4) {
                this.getBrowser().getLogWriter().log("caught StaleElementReferenceException in enterText method", Level.FINE);
            } catch (InvalidElementStateException var5) {
                this.getBrowser().getLogWriter().log("caught invalidElementStateException in enterText method", Level.FINE);
            }
        }
    }

*/
    public String getAttributeValue(WebDriver driver, By element) {
        return driver.findElement(element).getAttribute("value");
    }

    public String generateRandomString(int length) {
        return "Auto" + RandomStringUtils.randomAlphabetic(length);
    }
    public String generateRandomSentence() {
        return "Auto" + RandomStringUtils.randomAlphabetic(5)+" "+RandomStringUtils.randomAlphabetic(5)
                +" "+RandomStringUtils.randomAlphabetic(5)+" "+RandomStringUtils.randomAlphabetic(5)+" "+RandomStringUtils.randomAlphabetic(5);
    }

    public String generateRandomAlphaNumeric(int length) {
        return "Auto" + RandomStringUtils.randomAlphanumeric(length);
    }

    public String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(10);
    }

    public LocalDate addDaysToCurrentDate(int addNoOfDays) {
        return LocalDate.now().plusDays(addNoOfDays);
    }

    public LocalDate MinusDaysToCurrentDate(int addNoOfDays) {
        return LocalDate.now().minusDays(addNoOfDays);
    }

    public Date convertToDateFromLocalDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }

    /*
    public void scrollToView(WebElement element) {
        try {
            JavascriptExecutor jse = (JavascriptExecutor) this.driver;
            jse.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'start' });", element);
            this.getBrowser().sleep(1000);
        } catch (Exception e) {
            this.getBrowser().getLogWriter().log("caught invalidElementStateException in enterText method", Level.FINE);
        }
    }

*/
    public boolean verifyElementDisplayed(By element) {
        try {
            return driver.findElement(element).isDisplayed();
        } catch (Exception var4) {
            return false;
        }
    }

  /*
    public void higlightEle(By ele) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) this.driver;
            js.executeScript("arguments[0].style.border='3px solid red'", this.driver.findElement(ele));
            this.getBrowser().sleep(800);
            js.executeScript("arguments[0].style.border=''", this.driver.findElement(ele));
        } catch (Exception e) {

        }
    }
    */
        public int randInt(int min, int max) {
            return new Random().nextInt((max - min) + 1) + min;
        }

	
}
