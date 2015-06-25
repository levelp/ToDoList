package levelp.model.tasks;

import levelp.model.contacts.Contact;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Проект: состоит из нескольких задач и/или подпроектов
 */
@Entity
public class Project {
    /**
     * Подпроекты
     */
    @OneToMany(fetch = FetchType.LAZY)
    final public List<Project> subProjects = new ArrayList<>();
    /**
     * Задачи входящие в этот проект
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "")
    public List<Task> tasks = new ArrayList<>();
    /**
     * Ответственные за проект
     */
    @OneToMany(fetch = FetchType.LAZY)
    public List<Contact> responsible = new ArrayList<>();
    /**
     * Идентификатор проекта
     */
    @Column(name = "id")
    @Id
    @GeneratedValue
    Long id;
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
