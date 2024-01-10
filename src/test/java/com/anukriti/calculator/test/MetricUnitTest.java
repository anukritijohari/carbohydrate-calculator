package com.anukriti.calculator.test;

import com.anukriti.calculator.util.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class MetricUnitTest {

    @Test(testName = "TEST-27", description = "Run E2E Test")
    public void test27() {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.calculator.net/carbohydrate-calculator.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        // Verify the heading/title
        String titleText = Utils.getText(driver,"//h1");
        Utils.verify(titleText, "Carbohydrate Calculator", "Title matched");

        // verify that by default Metric Units tab is selected

        String selectedTabName =  Utils.getText(driver,"//li[@id='menuon']");
        Utils.verify(selectedTabName,"Metric Units","Metric Units tab is selected");

        // Enter details in the corresponding fields
        Utils.setData(driver,"//input[@id='cage']","28");

        // Select Female Checkbox
        WebElement selectFemaleGender = driver.findElement(By.xpath("//label[@for='csex2']"));
        selectFemaleGender.click();

        // Enter Height and Weight value
        Utils.setData(driver,"//input[@id='cheightmeter']","160");

        Utils.setData(driver,"//input[@id='ckg']","65");

        //select drop down
        Utils.selectDropdown(driver,"//select[@id='cactivity']","Moderate: exercise 4-5 times/week");

        //Click on Calculate
        WebElement calculateButton = driver.findElement(By.xpath("//input[@value='Calculate']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        calculateButton.click();

        String resultsBar =  Utils.getText(driver,"//h2[text()='Result']");
        Utils.verify(resultsBar, "Result","Result bar is visible after calculate button clicked");

        driver.quit();

    }

}