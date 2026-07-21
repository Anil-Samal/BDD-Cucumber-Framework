package config;

import constants.FrameworkConstants;

public class EnvironmentManager {

    private EnvironmentManager() {
        // Prevent instantiation
    }

    public static String getEnvironment() {

        return System.getProperty(
                "env",
                FrameworkConstants.DEFAULT_ENV);

    }
}