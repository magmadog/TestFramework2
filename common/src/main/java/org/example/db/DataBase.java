package org.example.db;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.api.service.PropertiesService;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
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
