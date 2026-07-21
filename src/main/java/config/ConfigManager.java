package config;

public class ConfigManager {

    private final PropertyLoader loader =
            new PropertyLoader();

    public String getBrowser() {

        return loader.getProperty("browser");

    }

    public String getUrl() {

        return loader.getProperty("url");

    }

    public String getUsername() {

        return loader.getProperty("username");

    }

    public String getPassword() {

        return loader.getProperty("password");

    }

    public boolean isHeadless() {

        return Boolean.parseBoolean(

                loader.getProperty("headless"));

    }

    public int getExplicitWait() {

        return Integer.parseInt(

                loader.getProperty("explicitWait"));

    }

    public int getImplicitWait() {

        return Integer.parseInt(

                loader.getProperty("implicitWait"));

    }

    public int getPageLoadTimeout() {

        return Integer.parseInt(

                loader.getProperty("pageLoadTimeout"));

    }

}