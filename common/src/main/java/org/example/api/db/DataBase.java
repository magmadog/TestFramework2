package org.example.util;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

public class DataBase {

    public static Jdbi jdbi;

    static {
        jdbi = Jdbi.create(
                PropertiesLoader.getDBurl(),
                PropertiesLoader.getPGUsername(),
                PropertiesLoader.getPGPassword());

        jdbi.installPlugin(new SqlObjectPlugin());
    }
}
