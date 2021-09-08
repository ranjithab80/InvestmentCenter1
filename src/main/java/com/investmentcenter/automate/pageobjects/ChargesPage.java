package com.investmentcenter.automate.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChargesPage {

    private final WebDriver driver;
    //    private final By chargesPage = By.xpath("//strong[contains(text(),'CHARGES – SIPP, ISA OR GIA')]");
    private final By chargesPage = By.xpath("/html/body/div[2]/div/div/div[3]/main/div/section[1]/article/section[1]/div/div/div[1]/div/div/div/p[1]/strong/a/strong");


    public ChargesPage(final WebDriver driver) {
        this.driver = driver;
    }

   public WebElement getChargesPage() {
        return (driver.findElement(chargesPage));
    }
}