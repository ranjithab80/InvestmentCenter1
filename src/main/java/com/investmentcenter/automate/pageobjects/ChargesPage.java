package com.investmentcenter.automate.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChargesPage {

    private final WebDriver driver;
    private final By chargesPage = By.xpath("//a[@href='/sites/default/files/AJBIC_charges_and_rates.pdf']");
    public ChargesPage(final WebDriver driver) {
        this.driver = driver;
    }

   public WebElement getChargesPage() {
        return (driver.findElement(chargesPage));
    }
}