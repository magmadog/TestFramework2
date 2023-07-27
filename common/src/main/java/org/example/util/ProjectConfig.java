package org.example.util;

import org.aeonbits.owner.Config;

@Config.Sources({"file:src/main/resources/ProjectConfig.properties"})
public interface ProjectConfig extends Config {
    @Key("base_url")
    String baseUrl();
    @Key("db_url")
    String dbUrl();
    @Key("pg_username")
    @DefaultValue("postgres")
    String pgUsername();
    @Key("pg_password")
    String pgPassword();
}