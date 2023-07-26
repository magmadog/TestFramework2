package org.example.lib;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPageObject {

    private final By helloWorldTextSelector = By.xpath("//*[contains(@text, 'Hello World!')]");

    public String getHelloWorldText() {
        return $(helloWorldTextSelector).getText();
    }
}
