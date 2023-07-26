package org.example.config;

import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.example.service.AppiumService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.net.MalformedURLException;

public class CapabilitiesConfig {

    public AppiumDriver driver;

    @BeforeEach
    public final void setUp() throws MalformedURLException {
        driver = new AndroidDriver(AppiumService.getAppiumUrl(), AppiumService.getCapabilities());

        WebDriverRunner.setWebDriver(driver);
    }

    @AfterEach
    public final void tearDown() {
        driver.quit();
    }
}
