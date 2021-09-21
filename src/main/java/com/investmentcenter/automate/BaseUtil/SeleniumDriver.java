package com.investmentcenter.automate.BaseUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumDriver {

    private static final Logger LOGGER = LogManager.getLogger(SeleniumDriver.class.getName());
    private static Properties prop;
    private WebDriver driver;

    static {
        prop = new Properties();
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("data.properties");
        try {
            prop.load(inputStream);
        } catch (IOException e) {
            LOGGER.error("Exception thrown while loading properties", e);
        }
    }

    public static Properties getProperties() {
        return prop;
    }

    public WebDriver initialize() {
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", prop.getProperty("selenium.browser.chrome"));
            driver = new ChromeDriver();
        } else {
            System.setProperty("webdriver.gecko.driver", prop.getProperty("selenium.browser.mozilla"));
            System.setProperty("webdriver.firefox.bin", prop.getProperty("browser.mozilla.path"));
            driver = new FirefoxDriver();
        }
        return driver;
    }


}


