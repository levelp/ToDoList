package tasks;

import contacts.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Проект: состоит из нескольких задач и/или подпроектов
 */
public class Project {
    /**
     * Подпроекты
     */
    final public List<Project> subProjects = new ArrayList<>();

    /**
     * Задачи
     */
    public List<Task> tasks = new ArrayList<>();

    /**
     * Ответственные за проект
     */
    public List<Contact> responsible = new ArrayList<>();

    /**
     * Название проекта
     */
    String name;

    /**
     * Ссылка на сайт/страницу проекта (если есть)
     */
    String link;


    public Project(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
