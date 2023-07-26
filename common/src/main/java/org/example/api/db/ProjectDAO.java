package org.example.api.db;

import org.example.model.Project;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface ProjectDAO {

    @SqlQuery("SELECT * FROM projects ORDER BY project_id")
    @RegisterBeanMapper(Project.class)
    List<Project> getAllProjects();

    @SqlQuery("SELECT * FROM projects WHERE project_id=:id")
    @RegisterBeanMapper(Project.class)
    Project getProjectByID(@Bind("id") Integer id);

    @SqlUpdate("INSERT INTO projects(project_id, start_date, name) VALUES (:id, :startDate, :name)")
    void insertBean(@BindBean Project project);
}
