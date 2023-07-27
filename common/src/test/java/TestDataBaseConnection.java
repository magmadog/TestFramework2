import org.example.db.ProjectRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestDataBaseConnection {

    @Test
    void testConnectionToDB() {

        var expectedProjectName = "Home Credit";

        var projects = ProjectRepository.getAllProjects();
        Assertions.assertFalse(
                projects.isEmpty(),
                "Table mustn't be empty");

        var project = ProjectRepository.getProjectById(1);
        Assertions.assertEquals(
                expectedProjectName,
                project.getName(),
                "Can't get data from postgres table");
    }
}
