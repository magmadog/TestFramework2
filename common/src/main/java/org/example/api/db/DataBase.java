package org.example.api.db;

import org.example.api.service.PropertiesService;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

public class DataBase {

    public static final Jdbi jdbi;

    static {
        jdbi = Jdbi.create(
                PropertiesService.getDBurl(),
                PropertiesService.getPGUsername(),
                PropertiesService.getPGPassword());

        jdbi.installPlugin(new SqlObjectPlugin());
    }
}
