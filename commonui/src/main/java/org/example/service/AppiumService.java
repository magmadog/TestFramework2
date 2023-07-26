package org.example.service;

import org.example.api.service.PropertiesService;
import org.example.util.PropertiesFileReader;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilitiesService extends PropertiesFileReader {

    static {
        load(PropertiesService.class.getClassLoader().getResourceAsStream("capabilities.properties"));
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
}
