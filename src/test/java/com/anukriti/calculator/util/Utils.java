package com.anukriti.calculator.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Utils {

    private Utils(){
        //hiding constructor to enforce static method calls only
    }

    public static void setData(WebDriver driver, String xpathValue, String data) {
        WebElement element = driver.findElement(By.xpath(xpathValue));
        element.clear();
        element.sendKeys(data);
    }

    public static void verify(String actual, String expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    public static String getText(WebDriver driver, String xpathValue){
        WebElement getText = driver.findElement(By.xpath(xpathValue));
        String titleText = getText.getText();
        return titleText;
    }

    public static void selectDropdown(WebDriver driver, String xpathValue, String option){

        Select selectDropdown = new Select(driver.findElement(By.xpath(xpathValue)));
        selectDropdown.selectByVisibleText(option);
    }
}
