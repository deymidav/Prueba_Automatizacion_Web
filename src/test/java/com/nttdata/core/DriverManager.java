package com.nttdata.core;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static WebDriver driver;
    private static Scenario scenario;

    public static WebDriver getDriver(){
        if (driver == null) {
            System.setProperty("webdriver.http.factory", "jdk-http-client");
            System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    @Before(order = 0)
    public void setUp(){
        getDriver();
    }

    @Before(order = 1)
    public void setScenario(Scenario scenario){
        DriverManager.scenario = scenario;
    }

    @After
    public void quitDriver(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void screenShot(){
        if (scenario != null) {
            byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(evidencia, "image/png", "evidencias");
        }
    }
}
