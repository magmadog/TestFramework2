package org.example.db;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.model.Project;

import java.util.List;

import static org.example.db.DataBase.jdbi;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProjectRepository {

    public static List<Project> getAllProjects(){
        return jdbi.withExtension(ProjectDAO.class, ProjectDAO::getAllProjects);
    }

    public static Project getProjectById(Integer id){
        return jdbi.withExtension(ProjectDAO.class, dao -> dao.getProjectByID(id));
    }
}
