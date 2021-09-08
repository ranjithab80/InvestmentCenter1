package com.investmentcenter.automate.BaseUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class SeleniumDriver {

    private static Logger LOGGER = LogManager.getLogger(SeleniumDriver.class.getName());
    private WebDriver driver;
    private static Properties prop;

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

    public WebDriver initialize() throws IOException {
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", prop.getProperty("selenium.browser.chrome"));
            driver = new ChromeDriver();
        } else {
            System.setProperty("webdriver.gecko.driver", prop.getProperty("selenium.browser.mozilla"));
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            return driver;
        }
        return null;
    }


}


