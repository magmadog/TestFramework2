package org.example.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileReader {

    protected static Properties properties;

    public static void load(InputStream inputStream) {
        properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
