package levelp.model.tasks;

import levelp.model.Tag;
import levelp.model.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Задача: выполяется за один раз
 */
@Entity
public class Task {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;
    /**
     * id задачи
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     * Задача имеет следующие свойства:
     * имя, описание, приоритет, подзадачи, тэги
     */
    private String name;
    private String description;
    private TaskPriority priority;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Task> subTasks = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Tag> tags = new ArrayList<>();

    /**
     * При создании экземпляра, мы передаем конструктору имя задачи.
     * Остальные свойства дописываем по умолчанию
     */
    public Task(String name) {

        this.name = name;
        this.tags.add(new Tag("#todo"));
        this.priority = TaskPriority.HIGH;
        this.description = "You need something to do!";
    }

    /**
     * Добавляем геттеры/сеттеры к свойствам
     * + два метода: добавить тэг, добавить подзадачу.
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public List<Task> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(List<Task> subTasks) {
        this.subTasks = subTasks;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public void addSubTasks(List<Task> subTasks) {
        this.subTasks.addAll(subTasks);
    }

    public void addTags(List<Tag> tags) {
        this.tags.addAll(tags);
    }

    /**
     * Переопределяем методы equals, hashCode, toString для нашего класса
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (!name.equals(task.name)) return false;
        if (description != null ? !description.equals(task.description) : task.description != null) return false;
        if (priority != task.priority) return false;
        if (subTasks != null ? !subTasks.equals(task.subTasks) : task.subTasks != null) return false;
        return !(tags != null ? !tags.equals(task.tags) : task.tags != null);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + priority.hashCode();
        result = 31 * result + (subTasks != null ? subTasks.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Необходимо выполнить" +
                "задачу '" + name + '\'' +
                ", тэги: " + tags +
                ", приоритет задачи: " + priority +
                ", подзадачи: " + subTasks +
                ", описание задачи: '" + description + '\'' +
                '}';
    }

    public enum TaskPriority {
        HIGH, MEDIUM, LOW
    }

}
