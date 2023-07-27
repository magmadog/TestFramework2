package org.example.util;

import org.aeonbits.owner.Config;

@Config.Sources({"file:src/main/resources/AppiumConfig.properties"})
public interface AppiumConfig extends Config {
    String appiumServerUrl();
}
