package org.example;

import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.example.service.CapabilitiesReader;
import org.example.util.AppiumConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.net.URL;

public class BaseTest {
    private static final String CAPABILITY_NAME = "androidDevice";
    private static final String CAPABILITY_FILE_PATH = "src/main/resources/capabilities.json";
    private AppiumDriver driver;

    @BeforeEach
    public final void setUp() throws Exception {

        var capabilities = CapabilitiesReader.getDesiredCapabilities(
                CAPABILITY_NAME,
                CAPABILITY_FILE_PATH);
        var appiumUrl = new URL(ConfigFactory.create(AppiumConfig.class).appiumServerUrl());

        driver = new AndroidDriver(appiumUrl, capabilities);
        WebDriverRunner.setWebDriver(driver);
    }

    @AfterEach
    public final void tearDown() {
        driver.quit();
    }
}
