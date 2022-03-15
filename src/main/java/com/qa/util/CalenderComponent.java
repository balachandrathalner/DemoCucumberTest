package com.qa.util;

import org.openqa.selenium.By;
import org.w3c.dom.Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/*
public class CalenderComponent extends SeleniumUtils{

    private TextField month;
    private TextField year;

    public CalenderComponent(){
//        this.month = monthField;
//        this.year = yearField;
    }
    private By monthField = By.cssSelector("[id='monthSpinner'] input");
    private By yearField =By.cssSelector("[id='yearSpinner'] input");

    private CalenderComponent enterMonth(String MMM){
        sendKeys(getBrowser().getDriver(),monthField,MMM);
        return this;
      }
    private CalenderComponent enterYear(String Year){
        sendKeys(getBrowser().getDriver(),yearField,Year);
        return this;
    }
    private CalenderComponent enterDate(String dd){
        findElement(By.xpath("//*[@id='controlCalBody']//td/a[contains(text(),'"+dd+"')]")).click();
        return this;
    }
    public CalenderComponent enterDatMonthAndYear(String d,String MMM,String year){
        enterMonth(MMM);
        enterYear(year);
        enterDate(d);
        return this;
    }
    public String[] getDateInDDMMMYYYYFormat(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");
        String d= date.format(formatter);
        return d.split("-");
    }
    public String getDateInDDMMYYYYFormat(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }
    public String convertDateTodd_MM_YYY(String date) {
        SimpleDateFormat format1 = new SimpleDateFormat("d/MM/yyyy");
        SimpleDateFormat format2 = new SimpleDateFormat("dd-MM-yyyy");
        try {
            return format2.format(format1.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
*/