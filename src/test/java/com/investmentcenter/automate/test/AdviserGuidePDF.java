package com.investmentcenter.automate.test;

import com.investmentcenter.automate.BaseUtil.SeleniumDriver;
import com.investmentcenter.automate.pageobjects.ChargesPage;
import com.investmentcenter.automate.pageobjects.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AdviserGuidePDF extends SeleniumDriver {

    private static final Logger log = LogManager.getLogger(AdviserGuidePDF.class.getName());
    private WebDriver driver = null;

    @BeforeTest
    public void initialise() {
        driver = initialize();
        log.info("Browser is initialised");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        log.info("Browser is closed!!");
    }

    @Test
    public void shouldOpenPdfInNewWindowWhileClickingOnChargesLink() {

        driver.get(getProperties().getProperty("url"));
        driver.findElement(By.cssSelector("input[id='gateway-adviser']")).click();

        final JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1100)");

        final HomePage homePage = new HomePage(driver);
        homePage.getCharges().click();

        final ChargesPage chargePage = new ChargesPage(driver);
        chargePage.getChargesPage().click();

        final String parent = driver.getWindowHandle();
        log.debug("parent window: ", parent);
        final Set<String> windowHandles = driver.getWindowHandles();

        final Iterator<String> iterator = windowHandles.iterator();
        final List<String> windowsTitles = new ArrayList<>();
        while (iterator.hasNext()) {
            final String childWindow = iterator.next();
            if (!parent.equals(childWindow)) {
                driver.switchTo().window(childWindow);
                final String title = driver.switchTo().window(childWindow).getCurrentUrl();
                windowsTitles.add(title);
            }
        }
        System.out.println(windowsTitles);
        Assert.assertTrue(windowsTitles.contains("https://www.investcentre.co.uk/sites/default/files/AJBIC_charges_and_rates.pdf"));
    }
}