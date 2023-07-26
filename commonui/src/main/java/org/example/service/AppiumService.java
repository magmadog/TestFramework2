package org.example.service;

import org.example.api.service.PropertiesService;
import org.example.util.PropertiesFileReader;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumService extends PropertiesFileReader {

    static {
        load(PropertiesService.class.getClassLoader().getResourceAsStream("appium.properties"));
    }

    public static DesiredCapabilities getCapabilities() {
        var capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", properties.getProperty("platformName"));
        capabilities.setCapability("deviceName", properties.getProperty("deviceName"));
        capabilities.setCapability("platformVersion", properties.getProperty("platformVersion"));
        capabilities.setCapability("automationName", properties.getProperty("automationName"));
        capabilities.setCapability("appPackage", properties.getProperty("appPackage"));
        capabilities.setCapability("appActivity", properties.getProperty("appActivity"));

        return capabilities;
    }

    public static URL getAppiumUrl() throws MalformedURLException {
        return new URL(properties.getProperty("appiumServerUrl"));
    }
}
