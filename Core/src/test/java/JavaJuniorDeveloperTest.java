import contacts.Contact;
import org.junit.Test;
import tasks.Project;
import tasks.Task;

import static org.junit.Assert.assertEquals;

/**
 * Описание курса в виде модульных тестов
 * для создаваемой системы
 * TDD: Test-driven development, TDD, Разработка через тестирование
 */
public class JavaJuniorDeveloperTest {

    @Test
    public void testCoursePlan() {
        Project course = new Project("Java Junior Developer");
        assertEquals("Java Junior Developer", course.getName());
        Contact c = new Contact("Степулёнок Денис Олегович", "super.denis@gmail.com");
        course.responsible.add(c);
        assertEquals("Степулёнок", c.getSurname());
        assertEquals("Денис", c.getName());
        assertEquals("Олегович", c.getPatronymic());
        assertEquals("super.denis@gmail.com", c.emails.get(0).getAddress());

        Project ToDoList = new Project("ToDoList");
        ToDoList.setLink("https://github.com/levelp/ToDoList");
        course.subProjects.add(ToDoList);

        Project JavaEE = new Project("Изучение JavaEE");
        course.subProjects.add(JavaEE);

        Project infra = new Project("Инфраструктура: GitHub: код, Bug-tracker...");
        Task gitHubSignUp = new Task("Зарегистироваться на GitHub");
        assertEquals("Зарегистироваться на GitHub", gitHubSignUp.getName());
        infra.tasks.add(gitHubSignUp);

        Project tools = new Project("Инструменты: git, maven, tomcat...");
        Project git = new Project("Git");
        git.setLink("http://git-scm.com/book/ru/v1");
        tools.subProjects.add(git);

        Project model = new Project("Модель предметной области");
        ToDoList.subProjects.add(model);
    }
}
