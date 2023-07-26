import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.api.db.ProjectDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.example.api.db.DataBase.jdbi;

class TestDataBaseConnection {

    private static final Logger logger = LogManager.getLogger();

    @Test
    void testConnectionToDB() {

        var expectedProjectName = "Home Credit";

        var projects = jdbi.withExtension(ProjectDAO.class, ProjectDAO::getAllProjects);
        logger.info("Data retrieved from table: {}", projects.toString());

        var project = jdbi.withExtension(ProjectDAO.class, dao -> dao.getProjectByID(1));
        Assertions.assertEquals(expectedProjectName, project.getName());
    }
}
