package com.investmentcenter.automate.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private final WebDriver driver;
    private final By charges = By.xpath("/html/body/div[2]/div/div/div[3]/main/div/section[1]/article/section[4]/div/div[1]/div/div[2]/div[2]/div/div/a");
    private final By register = By.xpath("//header/div[1]/div[1]/div[2]/nav[2]/ul[1]/li[1]/a[1]");

    public HomePage(final WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getCharges() {
        return driver.findElement(charges);
    }

    public WebElement getRegister() {
        return driver.findElement(register);
    }
}
