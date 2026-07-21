package factory;

import config.ConfigManager;
import enums.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    private final ConfigManager config = new ConfigManager();

    public WebDriver createBrowser() {

        BrowserType browser =
                BrowserType.valueOf(config.getBrowser().toUpperCase());

        switch (browser) {

            case EDGE:
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();

            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();

            case CHROME:
            default:

                WebDriverManager.chromedriver().setup();

                ChromeOptions options = new ChromeOptions();

                if (config.isHeadless()) {
                    options.addArguments("--headless=new");
                }

                options.addArguments("--start-maximized");

                return new ChromeDriver(options);
        }
    }
}