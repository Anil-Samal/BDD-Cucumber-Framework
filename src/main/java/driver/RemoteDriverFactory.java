package driver;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class RemoteDriverFactory {


    private static ThreadLocal<WebDriver> driver =
            new ThreadLocal<>();


    public static void initializeDriver(String browser)
            throws MalformedURLException {


        DesiredCapabilities capabilities =
                new DesiredCapabilities();


        if(browser.equalsIgnoreCase("chrome")) {

            capabilities.setBrowserName("chrome");

        }


        else if(browser.equalsIgnoreCase("firefox")) {

            capabilities.setBrowserName("firefox");

        }



        WebDriver remoteDriver =
                new RemoteWebDriver(
                    new URL(
                    "http://localhost:4444/wd/hub"),
                    capabilities
                );


        driver.set(remoteDriver);


    }



    public static WebDriver getDriver(){

        return driver.get();

    }



    public static void quitDriver(){

        if(driver.get()!=null){

            driver.get().quit();

            driver.remove();

        }

    }


}