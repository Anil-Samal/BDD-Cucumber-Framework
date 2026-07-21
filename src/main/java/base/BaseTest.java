//package base;
//
//import org.openqa.selenium.WebDriver;
//
//import config.ConfigReader;
//import driver.DriverFactory;
//import driver.DriverManager;
//
//public class BaseTest {
//
//    protected WebDriver driver;
//
//    public void setUp() {
//
//        DriverFactory factory =
//                new DriverFactory();
//
//        driver = factory.initializeDriver();
//
//        driver.get(ConfigReader.get("url"));
//        System.out.println("Current URL : " + driver.getCurrentUrl());
//        System.out.println("Page Title  : " + driver.getTitle());
//        System.out.println("Page Source Length : " + driver.getPageSource().length()); 
//    }
//    
//    public void tearDown() {
//
//        if (DriverManager.getDriver() != null) {
//
//            DriverManager.getDriver().quit();
//
//            DriverManager.unload();
//
//        }
//
//    }
//
//}