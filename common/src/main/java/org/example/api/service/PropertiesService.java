package org.example.util;

public class ProjectProperties extends PropertiesFileReader {

    static {
        load(ProjectProperties.class.getClassLoader().getResourceAsStream("project.properties"));
    }

    public static String getBaseURL() {
        return properties.getProperty("base_url");
    }

    public static String getDBurl() {
        return properties.getProperty("db_url");
    }

    public static String getPGUsername(){
        return properties.getProperty("pg_username");
    }

    public static String getPGPassword(){
        return properties.getProperty("pg_password");
    }
}
