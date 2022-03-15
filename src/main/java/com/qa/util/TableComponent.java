package com.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/*
public class TableComponent extends SeleniumUtiles {

    public List<String> getTableHeading(By TableEle) {
        WebElement headerRow = this.getBrowser().getElementWhenReady(TableEle).findElement(By.cssSelector("tr[class*='cellCont']"));
        List<WebElement> headerCell = headerRow.findElements(By.tagName("th"));
        List<String> headerTextList = new ArrayList();
        Iterator var5 = headerCell.iterator();

        while(var5.hasNext()) {
            WebElement cell = (WebElement)var5.next();
            String headerText = cell.getText().trim();
            if (!headerText.isEmpty() && !headerText.equals("")) {
                headerTextList.add(headerText);
            }
        }

        return headerTextList;
    }

    public String getCellValue(By tableEle, int rowNumber, int coloum) {
        String cellValue = "";
        By row = By.cssSelector("tr[pl_index='" + rowNumber + "']");
        By cell = By.cssSelector("td[data-ui-meta*='pyCells(" + coloum + ")']");
        try {
            cellValue = getBrowser().getDriver().findElement(tableEle).findElement(row).findElement(cell).getText();
        } catch (Exception var7) {
            this.getBrowser().getLogWriter().log("No cell found in row" + rowNumber + "/colum" + coloum);
            cellValue = null;
        }
        return cellValue;
    }

    private WebElement getCellByHeadingValue(By tableEle, String headingName, int rowNo) {
        int i= getColumnNumber(tableEle,headingName);
            return getBrowser().getDriver().findElement(tableEle).
                    findElement(By.xpath(".//th//*[contains(text(),'" + headingName + "')]//following::tr[" + rowNo + "]//td[" + i + "]"));
    }

    public int getColumnNumber(By tableEle, String headingName){
        List<WebElement> elements = getBrowser().getDriver().findElement(tableEle)
                .findElements(By.cssSelector("[class='cellCont rowHandleHead  ']"));
        List<WebElement> elements2 = getBrowser().getDriver().findElement(tableEle)
                .findElements(By.cssSelector("th"));
        elements.addAll(elements2);
        int i = 1;
        for (WebElement ele : elements) {
            if (ele.getText().equals(headingName)) {
                break;
            }
            i++;
        }
        return i;
    }

    public int getRowNumber(By tableEle, String rowIdentifier){
        List<WebElement> elements = getBrowser().getDriver().findElement(tableEle).findElements(By.cssSelector("tr"));
        new WebDriverWait(this.getDriver(),12).until(ExpectedConditions.visibilityOfAllElements(elements));
        int i = 0;
        for (WebElement ele : elements) {
            List<WebElement> elle1 = ele.findElements(By.xpath(".//*[text()='" + rowIdentifier + "']"));
            if (elle1.size() == 1) {
                break;
            }
            i++;
        }
        return i;
    }
    public WebElement getCellByIdentifierCellValue(By tableEle, String headingName, String rowIdentifier) {
      int i=getRowNumber( tableEle,rowIdentifier);
        return getCellByHeadingValue(tableEle, headingName, i);
    }
    public WebElement getRowByIdentifierCellValueWebElement(WebElement tableEle, String rowIdentifier){
        List<WebElement> elements = tableEle.findElements(By.cssSelector("tr"));
        for (WebElement ele : elements) {
            List<WebElement> elle1 = ele.findElements(By.xpath(".//*[contains(text(),'" + rowIdentifier + "')]"));
            if (elle1.size() == 1) {
               return ele;
            }
        }
        return null;
    }
    public String getCellValueByHeadName(By tableEle, String headingName, int rowNo) {
       return getCellByHeadingValue(tableEle, headingName, rowNo).getText();
    }

    }
*/