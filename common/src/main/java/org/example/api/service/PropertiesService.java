package org.example.api.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.aeonbits.owner.ConfigFactory;
import org.example.util.ProjectConfig;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PropertiesService {

    private static final ProjectConfig config;

    static {
        config = ConfigFactory.create(ProjectConfig.class);
    }

    public static String getBaseURL() {
        return config.baseUrl();
    }

    public static String getDBurl() {
        return config.dbUrl();
    }

    public static String getPGUsername() {
        return config.pgUsername();
    }

    public static String getPGPassword() {
        return config.pgPassword();
    }
}
